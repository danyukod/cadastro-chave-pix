package br.com.itau.cadastrochavepix.service.impl;

import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.inclusion.impl.DataBaseRegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.modification.RegistrationModification;
import br.com.itau.cadastrochavepix.domain.modification.impl.DataBaseRegistrationModification;
import br.com.itau.cadastrochavepix.model.requests.PixKeyDeletionRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyDeletionResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.service.PixKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PixKeyServiceImpl implements PixKeyService {

    @Autowired
    private DataBaseRegistrationInclusion dataBaseRegistrationInclusion;

    @Override
    public PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var validation = pixKeyRegisterRequest.pixKeyType().validateFactory();

        if (validation.pixKeyValidate(pixKeyRegisterRequest.pixKey())
                && validation.accountValidate(pixKeyRegisterRequest))
            return includesPixKey(pixKeyRegisterRequest, dataBaseRegistrationInclusion);
        else
            throw new IllegalArgumentException("Register Pix Key Request is invalid");
    }

    private PixKeyRegisterResponse includesPixKey(PixKeyRegisterRequest pixKeyRegisterRequest, RegistrationInclusion registrationInclusion) {
        return registrationInclusion.includes(pixKeyRegisterRequest);
    }

    @Override
    public PixKeyModificationResponse modificationPixKey(PixKeyModificationRequest pixKeyModificationRequest) {
        var validation = pixKeyModificationRequest.pixKeyType().validateFactory();

        if (validation.pixKeyValidate(pixKeyModificationRequest.pixKey())
                && validation.accountValidate(pixKeyModificationRequest))
            return modifyPixKey(pixKeyModificationRequest, new DataBaseRegistrationModification());
        else
            throw new IllegalArgumentException("Register Pix Key Request is invalid");
    }

    private PixKeyModificationResponse modifyPixKey(PixKeyModificationRequest pixKeyRegisterRequest, RegistrationModification registrationModification) {
        return registrationModification.modify(pixKeyRegisterRequest);
    }

    @Override
    public PixKeyDeletionResponse deletionPixKey(PixKeyDeletionRequest pixKeyDeletionRequest) {
        return null;
    }

}
