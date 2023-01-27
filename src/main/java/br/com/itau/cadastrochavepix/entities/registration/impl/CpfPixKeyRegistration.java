package br.com.itau.cadastrochavepix.entities.registration.impl;

import br.com.itau.cadastrochavepix.entities.registration.PixKeyRegistration;

public class CpfPixKeyRegistration implements PixKeyRegistration {
    @Override
    public void inclusion() {

    }

    @Override
    public boolean pixKeyNumberValidate() {
        return false;
    }

    @Override
    public boolean quantityValidate() {
        return false;
    }

    @Override
    public boolean formatValidate(String PixKey) {
        return false;
    }
}
