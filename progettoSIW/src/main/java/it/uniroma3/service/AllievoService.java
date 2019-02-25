package it.uniroma3.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Allievo;
import it.uniroma3.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService {

	@Autowired AllievoRepository allievoRepository;
	
	public Allievo save(Allievo allievo) {
		return this.allievoRepository.save(allievo);
	}
	public List<Allievo> findByNome(String nome) {
		return this.allievoRepository.findByNome(nome);
	}
	public List<Allievo> findByCognome(String cognome) {
		return this.allievoRepository.findByCognome(cognome);
	}
	public List<Allievo> findByEmaile(String email) {
		return this.allievoRepository.findByEmail(email);
	}
	public List<Allievo> findByTel(String tel) {
		return this.allievoRepository.findByTel(tel);
	}
	public List<Allievo> findByDataNascita(Date data) {
		return this.allievoRepository.findByDataNascita(data);
	}
	public List<Allievo> findByCitta(String citta) {
		return this.allievoRepository.findByCitta(citta);
	}
	public List<Allievo> findByNomeAndCognomeAndEmailAndTelAndDataNascitaAndCitta(String nome, String cognome, String email, String tel, Date data, String citta) {
		return this.allievoRepository.findByNomeAndCognomeAndEmailAndTelAndDataNascitaAndCitta(nome, cognome, email, tel, data, citta);
	}
	public Allievo findById(Long id) {
		Optional<Allievo> allievo=this.allievoRepository.findById(id);
		if(allievo.isPresent())
			return allievo.get();
		else return null;
	}
	public boolean alreadyExists(Allievo allievo) {
		List<Allievo> allievi= this.allievoRepository.findByNomeAndCognomeAndEmailAndTelAndDataNascitaAndCitta(allievo.getNome(), allievo.getCognome(), allievo.getEmail(), allievo.getTel(), allievo.getDataNascita(), allievo.getCitta());
		if(allievi.size()>0)
			return true;
		else return false;
	}
	public List<Allievo> findAll(){
		return(List<Allievo>) this.allievoRepository.findAll();
	}
}