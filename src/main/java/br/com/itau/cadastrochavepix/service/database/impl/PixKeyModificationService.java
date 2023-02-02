package br.com.itau.cadastrochavepix.service.database.impl;

import br.com.itau.cadastrochavepix.domain.inclusion.impl.DataBaseRegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.modification.impl.DataBaseRegistrationModification;
import br.com.itau.cadastrochavepix.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

public class PixKeyModificationService {

    public PixKeyModificationResponse updatePixKey(PixKeyModificationRequest pixKeyModificationRequest) {
        if (pixKeyModificationValidate(pixKeyModificationRequest))
            return pixKeyModificationDBInclusion(pixKeyModificationRequest);
        else
            throw new IllegalArgumentException("Update Pix Key Request is invalid");
    }

    private boolean pixKeyModificationValidate(PixKeyModificationRequest pixKeyModificationRequest){
        return false;
    }

    private PixKeyModificationResponse pixKeyModificationDBInclusion(PixKeyModificationRequest pixKeyModificationRequest) {
        return new DataBaseRegistrationModification().modification(pixKeyModificationRequest);
    }

}
