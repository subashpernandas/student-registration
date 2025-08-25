package com.tech.subash.controller;

import com.tech.subash.dto.Staff;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v2/validation")
@Tag(name = "Validation About Staff", description = "Operations related to Staff")
public class ValidationController {

	@Autowired
	private Validator validator;

	@PostMapping("/post")
	@Operation(summary = "Store Staff Detaills", description = "Initial store")
	public Staff storeUrbanDetails(@RequestBody @Valid Staff staff){
		//staff.setAge(12);
		Set<ConstraintViolation<Staff>> validate = validator.validate(staff);
		if(!validate.isEmpty()){
			throw new ConstraintViolationException("errorMessage", validate);
		} else {
			return  staff;
		}
    }
}
