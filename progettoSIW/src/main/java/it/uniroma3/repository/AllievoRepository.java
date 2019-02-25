package it.uniroma3.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long>{
	
	public List<Allievo> findByNome(String nome);
	public List<Allievo> findByCognome(String cognome);
	public List<Allievo> findByEmail(String email);
	public List<Allievo> findByTel(String tel);
	public List<Allievo> findByDataNascita(Date data);
	public List<Allievo> findByCitta(String citta);
	public List<Allievo> findByNomeAndCognomeAndEmailAndTelAndDataNascitaAndCitta(String nome, String cognome, String email, String tel, Date data, String citta);

}
