package br.com.itau.cadastrochavepix.app.service.impl;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyDeletionRequest;
import br.com.itau.cadastrochavepix.app.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.app.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyDeletionResponse;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.app.service.PixKeyService;
import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;

public class DomainPixKeyService implements PixKeyService{

    RegistrationInclusion registrationInclusion;
    public DomainPixKeyService(RegistrationInclusion registrationInclusion) {
        this.registrationInclusion = registrationInclusion;
    }

    public PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        return new RegisterPixKeyService(registrationInclusion).registerPixKey(pixKeyRegisterRequest);
    }

    public PixKeyModificationResponse modificationPixKey(PixKeyModificationRequest pixKeyModificationRequest) {
        return null;
    }

    public PixKeyDeletionResponse deletionPixKey(PixKeyDeletionRequest pixKeyDeletionRequest) {
        return null;
    }



}
