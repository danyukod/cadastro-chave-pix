package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import br.com.itau.cadastrochavepix.entities.registration.validate.PixKeyRegistrationValidate;

public class EmailPixKeyRegistrationValidate implements PixKeyRegistrationValidate {
    @Override
    public boolean formatValidate(String PixKey) {
        if (PixKey == null) {
            return false;
        }
        return PixKey.matches(emailRegex) && verifyLength(PixKey);
    }

    private boolean verifyLength(String PixKey) {
        return PixKey.length() >= 3 && PixKey.length() <= 77;
    }

    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
}
