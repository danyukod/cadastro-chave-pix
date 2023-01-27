package br.com.itau.cadastrochavepix.service.registration.impl;

import br.com.itau.cadastrochavepix.service.registration.PixKeyRegistration;

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
    public boolean formatValidate() {
        return false;
    }
}
