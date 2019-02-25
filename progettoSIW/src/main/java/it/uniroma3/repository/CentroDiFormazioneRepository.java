package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.CentroDiFormazione;

public interface CentroDiFormazioneRepository extends CrudRepository<CentroDiFormazione,Long>{
	public List<CentroDiFormazione> findByNome(String nome);
	public List<CentroDiFormazione> findByIndirizzo(String indirizzo);
	public List<CentroDiFormazione> findByEmail(String email);
	public List<CentroDiFormazione> findByTel(String tel);
	public List<CentroDiFormazione> findByCapienzaMassima(String capienzaMassima);
	public List<CentroDiFormazione> findByNomeAndIndirizzoAndEmailAndTelAndCapienzaMassima(String nome, String indirizzo, String email, String tel, String capienzaMassima);

}
