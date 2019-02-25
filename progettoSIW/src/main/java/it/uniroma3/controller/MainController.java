package it.uniroma3.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
		@GetMapping("/loginok")
		public String loginok(){
			return "loginOk";
		}
		
		@GetMapping("/logoutok")
		public String logoutok(){
			return "logoutOk";
		}


		@GetMapping("/errorlog")
		public String loginError() {
			return "login";
		}
		
		@RequestMapping("/error403")
		public String accessDenied() {
			return "accessoNegato";
		}
		
		
		
}
