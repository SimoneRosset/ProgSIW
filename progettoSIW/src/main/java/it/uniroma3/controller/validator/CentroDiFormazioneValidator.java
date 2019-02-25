package it.uniroma3.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.CentroDiFormazione;
@Component
public class CentroDiFormazioneValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CentroDiFormazione.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capienzaMassima", "required");

		
	}




}
