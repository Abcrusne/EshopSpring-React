package it.akademija.vaisius;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaisiuDao extends JpaRepository<Vaisius, Long> {

	List<Vaisius> findByMedis(Medis medis);

}
