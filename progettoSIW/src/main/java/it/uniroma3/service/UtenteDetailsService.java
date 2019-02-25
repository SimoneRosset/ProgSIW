package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Utente;

@Service
public class UtenteDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Utente utente= userService.findByUsername(username);

    UserBuilder builder = null;
    if (utente!=null) {
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.password(new BCryptPasswordEncoder().encode(utente.getPassword()));
      builder.roles(utente.getRole());
    } else {
      throw new UsernameNotFoundException("Utente non trovato.");
    }

    return builder.build();
  }
}