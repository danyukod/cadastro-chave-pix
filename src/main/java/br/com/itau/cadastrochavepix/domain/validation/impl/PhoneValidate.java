package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.validation.RegistrationValidation;

import java.util.regex.Pattern;

public class PhoneValidate implements RegistrationValidation {

    private static Pattern regexPatternPhoneNumber = Pattern.compile("\\+((\\d{11,14}))");

    @Override
    public boolean pixKeyValidate(String pixKey) {
        if (pixKey == null) {
            return false;
        }
        return regexPatternPhoneNumber.matcher(pixKey).matches();
    }

}
