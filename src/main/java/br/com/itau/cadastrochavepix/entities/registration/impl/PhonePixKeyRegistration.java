package br.com.itau.cadastrochavepix.entities.registration.impl;

import br.com.itau.cadastrochavepix.entities.registration.PixKeyRegistration;

import java.util.regex.Pattern;

public class PhonePixKeyRegistration implements PixKeyRegistration {

    @Override
    public void inclusion() {

    }

    @Override
    public boolean formatValidate(String PixPhoneNumber) {
        return regexPatternPhoneNumber.matcher(PixPhoneNumber).matches();
    }

    private static Pattern regexPatternPhoneNumber = Pattern.compile("\\+55\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");

}
