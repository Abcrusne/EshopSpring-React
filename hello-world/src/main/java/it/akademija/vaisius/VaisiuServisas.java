package it.akademija.vaisius;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VaisiuServisas {

	@Autowired
	private VaisiuDao vaisiusDao;

	@Autowired
	private MedziuDao medziuDao;

	public MedziuDao getMedziuDao() {
		return medziuDao;
	}

	public void setMedziuDao(MedziuDao medziuDao) {
		this.medziuDao = medziuDao;
	}

	@Transactional(readOnly = true)
	public List<VaisiusIsServiso> findAllVaisiai() {
		return vaisiusDao.findAll().stream().map(
				vaisiusDB -> new VaisiusIsServiso(vaisiusDB.getPavadinimas(), vaisiusDB.getMedis().getPavadinimas()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<VaisiusIsServiso> findAllVaisiaiOnTree(String medzioPavadinimas) {
		var medis = medziuDao.findById(medzioPavadinimas).orElse(null);
		return vaisiusDao.findByMedis(medis).stream().map(
				vaisiusDB -> new VaisiusIsServiso(vaisiusDB.getPavadinimas(), vaisiusDB.getMedis().getPavadinimas()))
				.collect(Collectors.toList());
	}

	@Transactional
	public void saveVaisius(VaisiusIsServiso vaisiusIsServiso) {
		var vaisius = new Vaisius(vaisiusIsServiso.getPavadinimas());
		var medis = new Medis(vaisiusIsServiso.getMedzioPavadinimas());
		var issaugotasMedis = medziuDao.save(medis);
		vaisius.setMedis(issaugotasMedis);
		vaisiusDao.save(vaisius);

	}

	public VaisiuDao getVaisiusDao() {
		return vaisiusDao;
	}

	public void setVaisiusDao(VaisiuDao vaisiusDao) {
		this.vaisiusDao = vaisiusDao;
	}

}