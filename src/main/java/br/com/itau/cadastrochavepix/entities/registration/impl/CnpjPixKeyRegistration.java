package br.com.itau.cadastrochavepix.entities.registration.impl;

import br.com.itau.cadastrochavepix.entities.registration.PixKeyRegistration;

public class CnpjPixKeyRegistration implements PixKeyRegistration {

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
