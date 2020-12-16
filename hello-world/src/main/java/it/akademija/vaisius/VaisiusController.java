package it.akademija.vaisius;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vaisius")
public class VaisiusController {

	@Autowired
	private VaisiuServisas vaisiusService;

	@RequestMapping(method = RequestMethod.GET)
	public List<VaisiuInfo> getVaisiai() {
		return vaisiusService.findAllVaisiai().stream()
				.map(vaisiusIsServico -> new VaisiuInfo(vaisiusIsServico.getPavadinimas(),
						vaisiusIsServico.getMedzioPavadinimas()))
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{medzioPavadinimas}")
	public List<VaisiuInfo> gautiVaisiusNuoMedzio(@PathVariable("medzioPavadinimas") String medzioPavadinimas) {
		return vaisiusService.findAllVaisiaiOnTree(medzioPavadinimas).stream()
				.map(vaisiusIsServico -> new VaisiuInfo(vaisiusIsServico.getPavadinimas(),
						vaisiusIsServico.getMedzioPavadinimas()))
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.POST, path = "/{pavadinimas}/{medzioPavadinimas}")
	public String issaugotiVaisius(@PathVariable("pavadinimas") String pavadinimas,
			@PathVariable("medzioPavadinimas") String medzioPavadinimas) {
		var vaisius = new VaisiusIsServiso(pavadinimas, medzioPavadinimas);
		vaisiusService.saveVaisius(vaisius);
		return "Vaisius buvo issaugotas";
	}

	public VaisiuServisas getVaisiusService() {
		return vaisiusService;
	}

	public void setVaisiusService(VaisiuServisas vaisiusService) {
		this.vaisiusService = vaisiusService;
	}

}