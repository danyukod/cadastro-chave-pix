package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import br.com.itau.cadastrochavepix.entity.registration.validate.RegistrationValidate;

import java.util.regex.Pattern;

public class RandomRegistrationValidate implements RegistrationValidate {

    private static Pattern regexPatternPhoneNumber = Pattern.compile("^[a-zA-Z0-9]{36}$");

    @Override
    public boolean formatValidate(String pixKey) {
        if (pixKey == null)
            return false;

        return regexPatternPhoneNumber.matcher(pixKey).matches();
    }


}
