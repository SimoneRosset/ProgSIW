package it.uniroma3.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.uniroma3.model.CentroDiFormazione;
import it.uniroma3.model.Utente;
import it.uniroma3.repository.UserRepository;

@Transactional
@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository; 

    public List<Utente> findAll() {
        return this.userRepository.findAll();
    }

	public Utente findbyId(Long id) {
		Optional<Utente> o = this.userRepository.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		else 
			return null;
	}
	
	public Utente findCurrentUser(Principal principal) {
		String username = principal.getName();
		return this.userRepository.findByUsername(username);
	}

	public Utente findByCentroDiFormazione(CentroDiFormazione centroDiFormazione) {
		return this.userRepository.findByCentroDiFormazione(centroDiFormazione);
	}

	public Utente save(Utente utente) {
		return this.userRepository.save(utente);
	}

	public Utente findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

}
