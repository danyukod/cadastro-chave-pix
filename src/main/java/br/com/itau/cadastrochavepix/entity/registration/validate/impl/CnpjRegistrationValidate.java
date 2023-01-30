package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import br.com.itau.cadastrochavepix.entity.registration.validate.RegistrationValidate;

public class CnpjRegistrationValidate implements RegistrationValidate {
    @Override
    public boolean formatValidate(String PixKey) {
        return false;
    }
}
