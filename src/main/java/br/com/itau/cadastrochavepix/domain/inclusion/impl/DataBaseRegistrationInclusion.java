package br.com.itau.cadastrochavepix.domain.inclusion.impl;

import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

public class DataBaseRegistrationInclusion implements RegistrationInclusion {



    @Override
    public PixKeyRegisterResponse includes(PixKeyRegisterRequest request) {
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
