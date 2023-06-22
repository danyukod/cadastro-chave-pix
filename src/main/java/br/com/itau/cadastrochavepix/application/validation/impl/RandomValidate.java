package br.com.itau.cadastrochavepix.application.validation.impl;

import br.com.itau.cadastrochavepix.application.validation.RegistrationValidation;

import java.util.regex.Pattern;

public class RandomValidate implements RegistrationValidation {

    private static Pattern regexPatternPhoneNumber = Pattern.compile("^[a-zA-Z0-9]{36}$");

    @Override
    public boolean pixKeyValidate(String pixKey) {
        if (pixKey == null)
            return false;

        return regexPatternPhoneNumber.matcher(pixKey).matches();
    }


}
