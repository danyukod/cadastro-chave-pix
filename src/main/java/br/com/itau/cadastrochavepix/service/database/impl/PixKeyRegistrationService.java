package br.com.itau.cadastrochavepix.service.database.impl;

import br.com.itau.cadastrochavepix.domain.inclusion.impl.DataBaseRegistrationInclusion;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

public class PixKeyRegistrationService {

    public PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRequest) {
        if (pixKeyRegistrationValidate(pixKeyRequest))
            return pixKeyRegisterDBInclusion(pixKeyRequest);
        else
            throw new IllegalArgumentException("Register Pix Key Request is invalid");
    }

    private boolean pixKeyRegistrationValidate(PixKeyRegisterRequest pixKeyRequest) {
        var validate = pixKeyRequest.pixKeyType().validateFactory();
        var pixKey = pixKeyRequest.pixKey();

        return validate.pixKeyValidate(pixKey);
    }

    private PixKeyRegisterResponse pixKeyRegisterDBInclusion(PixKeyRegisterRequest pixKeyRequest) {
        return new DataBaseRegistrationInclusion().inclusion(pixKeyRequest);
    }

}
