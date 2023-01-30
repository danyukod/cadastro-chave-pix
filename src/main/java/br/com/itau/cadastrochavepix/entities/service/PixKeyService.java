package br.com.itau.cadastrochavepix.entities.service;

import br.com.itau.cadastrochavepix.entities.registration.inclusion.impl.PixKeyDBInclusion;
import br.com.itau.cadastrochavepix.models.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.models.responses.PixKeyRegisterResponse;

public class PixKeyService {

    public PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRequest) {
        var pixKeyInclusion = new PixKeyDBInclusion();

        if (pixKeyRegisterValidate(pixKeyRequest)) {
            return pixKeyInclusion.inclusion(pixKeyRequest);
        } else {
            throw new IllegalArgumentException("Pix key is invalid");
        }
    }

    //TODO
    public PixKeyRegisterResponse updatePixKey(String pixKey, PixKeyRegisterRequest pixKeyRequest) {
        return null;
    }

    //TODO
    public PixKeyRegisterResponse deletePixKey(String pixKey) {
        return null;
    }

    private boolean pixKeyRegisterValidate(PixKeyRegisterRequest pixKeyRequest) {
        var validate = pixKeyRequest.pixKeyType().validateFactory();
        var pixKey = pixKeyRequest.pixKey();

        return validate.formatValidate(pixKey);
    }

}
