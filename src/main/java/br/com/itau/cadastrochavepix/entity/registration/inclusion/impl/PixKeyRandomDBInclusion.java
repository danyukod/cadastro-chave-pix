package br.com.itau.cadastrochavepix.entity.registration.inclusion.impl;

import br.com.itau.cadastrochavepix.entity.registration.inclusion.PixKeyInclusion;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

public class PixKeyRandomDBInclusion implements PixKeyInclusion {

    @Override
    public PixKeyRegisterResponse inclusion(PixKeyRegisterRequest request) {
        if (pixKeyDBValidation(generateRandomPixKey()))
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

    private String generateRandomPixKey() {
        return UUID.randomUUID().toString().replace("-", randomNumber());
    }

    private CharSequence randomNumber() {
        return String.valueOf(new Random().nextInt(9));
    }
}

