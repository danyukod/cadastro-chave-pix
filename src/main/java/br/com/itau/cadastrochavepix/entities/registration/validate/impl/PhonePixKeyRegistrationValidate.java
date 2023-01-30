package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import br.com.itau.cadastrochavepix.entities.registration.validate.PixKeyRegistrationValidate;

import java.util.regex.Pattern;

public class PhonePixKeyRegistrationValidate implements PixKeyRegistrationValidate {

    private static Pattern regexPatternPhoneNumber = Pattern.compile("\\+((\\d{11,14}))");

    @Override
    public boolean formatValidate(String PixPhoneNumber) {
        if (PixPhoneNumber == null) {
            return false;
        }
        return regexPatternPhoneNumber.matcher(PixPhoneNumber).matches();
    }

}
