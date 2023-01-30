package br.com.itau.cadastrochavepix.entities.registration.inclusion.impl;

import br.com.itau.cadastrochavepix.entities.registration.inclusion.PixKeyInclusion;
import br.com.itau.cadastrochavepix.models.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.models.responses.PixKeyRegisterResponse;

public class PixKeyDBInclusion implements PixKeyInclusion {

    @Override
    public PixKeyRegisterResponse inclusion(PixKeyRegisterRequest request) {
        if (pixKeyDBValidation(request.pixKey()))
            return null;
        else
            throw new IllegalArgumentException("Pix key is invalid");
    }

    private boolean pixKeyDBValidation(String pixKey) {
        return verifyEqualsPixKeyNumber(pixKey) && verifyPixKeyQuantity(pixKey);
    }

    boolean verifyEqualsPixKeyNumber(String pixKey) {
        return false;
    }

    ;

    boolean verifyPixKeyQuantity(String pixKey) {
        return false;
    }

    ;
}
