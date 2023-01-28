package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import br.com.itau.cadastrochavepix.entities.registration.validate.PixKeyRegistrationValidate;

import java.util.regex.Pattern;

public class PhonePixKeyRegistrationValidate implements PixKeyRegistrationValidate {
    @Override
    public boolean formatValidate(String PixPhoneNumber) {
        if (PixPhoneNumber == null) {
            return false;
        }
        return regexPatternPhoneNumber.matcher(PixPhoneNumber).matches();
    }

    private static Pattern regexPatternPhoneNumber = Pattern.compile("\\+55\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");

}
