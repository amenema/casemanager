package com.la.common.nonblank;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: amen
 * @date: 2019-08-22
 */
public class NonBlankValidator implements ConstraintValidator<NonBlank, String> {
    @Override
    public void initialize(NonBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return false;
        }
        return true;
    }
}
