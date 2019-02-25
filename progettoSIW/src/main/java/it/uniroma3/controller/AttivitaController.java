package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.controller.validator.AttivitaValidator;
import it.uniroma3.model.Allievo;
import it.uniroma3.model.Attivita;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.AttivitaService;

@Controller
public class AttivitaController {
	
	@Autowired AttivitaService attivitaService;
	
	@Autowired AttivitaValidator attivitaValidator;
	
	@Autowired AllievoService allievoService;
	
	@RequestMapping("/attivitas")
	public String attivitas(Model model) {
		model.addAttribute("attivitas", this.attivitaService.findAll());
		return "attivitaList";
	}
	@RequestMapping("/addAttivita")
	public String addAttivita(Model model) {
		model.addAttribute("attivita", new Attivita());
		return "attivitaForm";
	}
	@RequestMapping(value="/attivita/{id}", method=RequestMethod.GET)
	public String getAttivita(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attivita",this.attivitaService.findById(id));
		return "showAttivita";
	}
	@RequestMapping(value="/attivita", method=RequestMethod.POST)
	public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, Model model, BindingResult bindingResult) {
		this.attivitaValidator.validate(attivita, bindingResult);
		if(this.attivitaService.alreadyExists(attivita)) {
			model.addAttribute("exists","attivita già presente");
			return "attivitaForm";
		}
		else {
			if(!bindingResult.hasErrors()) {
				this.attivitaService.save(attivita);
				model.addAttribute("attivitas",this.attivitaService.findAll());
				return "attivitaList";
			}
		}
		return "attivitaForm";
		
	}
	@RequestMapping("/salvaIscrizione")
	public String salvaIscrizione(Model model, @RequestParam(value="allievo") Long idAllievo,
			@RequestParam(value="attivita") Long idAttivita, BindingResult result) {
		Allievo allievo = this.allievoService.findById(idAllievo);
		Attivita attivita = this.attivitaService.findById(idAttivita);
		this.attivitaService.iscriviAllievo(attivita, allievo);
		return "home";
	}


}
