package it.uniroma3.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Attivita;

public interface AttivitaRepository extends CrudRepository<Attivita,Long>{
	public List<Attivita> findByNome(String nome);
	public List<Attivita> findByData(Date data);
	public List<Attivita> findByOrario(Date orario);
	public List<Attivita> findByNomeAndDataAndOrario(String nome, Date data, Date orario);

}
