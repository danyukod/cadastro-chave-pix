package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import br.com.itau.cadastrochavepix.entity.registration.validate.RegistrationValidate;

public class EmailRegistrationValidate implements RegistrationValidate {

    public static final int MIN_EMAIL_LENGTH = 3;
    public static final int MAX_EMAIL_LENGHT = 77;
    private static String regexPatternEmail = "^[A-Za-z0-9+_.-]+@(.+)$";


    @Override
    public boolean formatValidate(String pixKey) {
        if (pixKey == null) {
            return false;
        }
        return pixKey.matches(regexPatternEmail) && verifyLength(pixKey);
    }

    private boolean verifyLength(String PixKey) {
        return PixKey.length() >= MIN_EMAIL_LENGTH && PixKey.length() <= MAX_EMAIL_LENGHT;
    }

}
