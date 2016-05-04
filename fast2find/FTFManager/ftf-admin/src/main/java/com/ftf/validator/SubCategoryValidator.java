package com.ftf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ftf.model.SubCatageory;

@Component
public class SubCategoryValidator implements Validator {

  public boolean supports(Class<?> clazz) {
    return SubCatageory.class.isAssignableFrom(clazz);
  }

  public void validate(Object target, Errors errors) {
    SubCatageory subCatageory = (SubCatageory) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subCatageoryName",
        "error.subCatageoryName.empty");
    if (subCatageory.getCatageory().getCatageoryId() == 0) {
      errors.rejectValue("catageory.catageoryId", "error.category.select");
    }
  }

}
