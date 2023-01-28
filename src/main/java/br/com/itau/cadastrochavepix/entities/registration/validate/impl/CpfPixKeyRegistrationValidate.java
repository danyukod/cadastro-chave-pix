package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import br.com.itau.cadastrochavepix.entities.registration.validate.PixKeyRegistrationValidate;

public class CpfPixKeyRegistrationValidate implements PixKeyRegistrationValidate {
    @Override
    public boolean formatValidate(String PixKey) {
        return false;
    }
}
