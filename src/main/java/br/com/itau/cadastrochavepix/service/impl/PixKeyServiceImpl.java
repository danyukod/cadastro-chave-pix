package br.com.itau.cadastrochavepix.service.impl;

import br.com.itau.cadastrochavepix.domain.deletion.RegistrationDeletion;
import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.modification.RegistrationModification;
import br.com.itau.cadastrochavepix.model.requests.PixKeyDeletionRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyDeletionResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.service.PixKeyService;

public class PixKeyServiceImpl implements PixKeyService {


    private RegistrationInclusion registrationInclusion;

    private RegistrationModification registrationModification;

    private RegistrationDeletion registrationDeletion;

    public PixKeyServiceImpl(RegistrationInclusion registrationInclusion,
                             RegistrationModification registrationModification,
                             RegistrationDeletion registrationDeletion) {
        this.registrationInclusion = registrationInclusion;
        this.registrationModification = registrationModification;
        this.registrationDeletion = registrationDeletion;
    }

    @Override
    public PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var validation = pixKeyRegisterRequest.pixKeyType().validateFactory();

        if (validation.pixKeyValidate(pixKeyRegisterRequest.pixKey())
                && validation.accountValidate(pixKeyRegisterRequest))
            return registrationInclusion.inclusion(pixKeyRegisterRequest);
        else
            throw new IllegalArgumentException("Register Pix Key Request is invalid");
    }

    @Override
    public PixKeyModificationResponse modificationPixKey(PixKeyModificationRequest pixKeyModificationRequest) {
        var validation = pixKeyModificationRequest.pixKeyType().validateFactory();

        if (validation.pixKeyValidate(pixKeyModificationRequest.pixKey())
                && validation.accountValidate(pixKeyModificationRequest))
            return registrationModification.modification(pixKeyModificationRequest);
        else
            throw new IllegalArgumentException("Register Pix Key Request is invalid");
    }

    @Override
    public PixKeyDeletionResponse deletionPixKey(PixKeyDeletionRequest pixKeyDeletionRequest) {
        return null;
    }

}
