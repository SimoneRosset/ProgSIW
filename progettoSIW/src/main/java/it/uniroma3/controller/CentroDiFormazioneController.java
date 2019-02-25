
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

import it.uniroma3.controller.validator.CentroDiFormazioneValidator;
import it.uniroma3.model.CentroDiFormazione;
import it.uniroma3.service.CentroDiFormazioneService;

@Controller
public class CentroDiFormazioneController {

	@Autowired CentroDiFormazioneService centroDiFormazioneService;
	@Autowired CentroDiFormazioneValidator centroDiFormazioneValidator;
	
	@RequestMapping("/centri")
	public String centri(Model model) {
		model.addAttribute("centri", this.centroDiFormazioneService.findAll());
		return "centroDiFormazioneList";
	}
	@RequestMapping("/addCentro")
	public String addCentroDiFormazione(Model model) {
		model.addAttribute("centro", new CentroDiFormazione());
		return "centroDiFormazioneForm";
	}
	@RequestMapping(value="/centro/{id}", method=RequestMethod.GET)
	public String getCentroDiFormazione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroDiFormazioneService.findById(id));
		return "showCentroDiFormazione";
	}
	@RequestMapping(value="/centro", method=RequestMethod.POST)
	public String newCentroDiFormazione(@Valid @ModelAttribute("centro") CentroDiFormazione centroDiFormazione, Model model, BindingResult bindingResult) {
		this.centroDiFormazioneValidator.validate(centroDiFormazione, bindingResult);
		if(this.centroDiFormazioneService.alreadyExists(centroDiFormazione)) {
			model.addAttribute("exists", "centro di formazione già eisistente");
			return "centroDiFormazioneForm";
		}
		else {
			if(!bindingResult.hasErrors()) {
				this.centroDiFormazioneService.save(centroDiFormazione);
				model.addAttribute("centri", this.centroDiFormazioneService.findAll());
				return "centroDiFormazioneList";
			}			
		}
		return "centroDiFormazioneForm";
	}
	
}
