package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.CentroDiFormazione;
import it.uniroma3.repository.CentroDiFormazioneRepository;

@Transactional
@Service
public class CentroDiFormazioneService {

	@Autowired CentroDiFormazioneRepository centroDiFormazioneRepository;
	
	public CentroDiFormazione save(CentroDiFormazione centroDiFormazione) {
		return this.centroDiFormazioneRepository.save(centroDiFormazione);
	}
	public List<CentroDiFormazione> findByNome(String nome){
		return this.centroDiFormazioneRepository.findByNome(nome);
	}
	public List<CentroDiFormazione> findByIndirizzo(String indirizzo){
		return this.centroDiFormazioneRepository.findByIndirizzo(indirizzo);
	}
	public List<CentroDiFormazione> findByEmail(String email){
		return this.centroDiFormazioneRepository.findByEmail(email);
	}
	public List<CentroDiFormazione> findByTel(String tel){
		return this.centroDiFormazioneRepository.findByTel(tel);
	}
	public List<CentroDiFormazione> findByCapienzaMassima(String capienzaMassima){
		return this.centroDiFormazioneRepository.findByCapienzaMassima(capienzaMassima);
	}
	public List<CentroDiFormazione> findByNomeAndIndirizzoAndEmailAndTelAndCapienzaMassima(String nome, String indirizzo,String  email, String tel, String capienzaMassima){
		return this.centroDiFormazioneRepository.findByNomeAndIndirizzoAndEmailAndTelAndCapienzaMassima(nome, indirizzo, email, tel, capienzaMassima);
	}
	public CentroDiFormazione findById(Long id) {
		Optional<CentroDiFormazione> centroDiFormazione= this.centroDiFormazioneRepository.findById(id);
		if(centroDiFormazione.isPresent())
			return centroDiFormazione.get();
		else return null;
	}
	public boolean alreadyExists(CentroDiFormazione centroDiFormazione) {
		List<CentroDiFormazione> centri= this.centroDiFormazioneRepository.findByNomeAndIndirizzoAndEmailAndTelAndCapienzaMassima(centroDiFormazione.getNome(), centroDiFormazione.getIndirizzo(), centroDiFormazione.getEmail(), centroDiFormazione.getTel(), centroDiFormazione.getCapienzaMassima());
		if(centri.size()>0)
			return true;
		else return false;
	}
	public List<CentroDiFormazione> findAll(){
		return (List<CentroDiFormazione>) this.centroDiFormazioneRepository.findAll();
	}
}
