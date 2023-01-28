package br.com.itau.cadastrochavepix.entities.registration.inclusion.impl;

import br.com.itau.cadastrochavepix.entities.registration.inclusion.PixKeyInclusion;
import br.com.itau.cadastrochavepix.models.requests.PixKeyRequest;

public class PixKeyDBInclusion implements PixKeyInclusion {
    @Override
    public void inclusion(PixKeyRequest request) {

    }

    @Override
    public boolean verifyEqualsPixKeyNumber() {
        return false;
    }

    @Override
    public boolean verifyPixKeyQuantity() {
        return false;
    }
}
