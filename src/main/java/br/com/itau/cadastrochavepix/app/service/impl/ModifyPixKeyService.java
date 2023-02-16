package br.com.itau.cadastrochavepix.app.service.impl;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.domain.modification.RegistrationModification;

public class ModifyPixKeyService {

    public PixKeyModificationResponse modificationPixKey(PixKeyModificationRequest pixKeyModificationRequest) {
        return null;
    }

    private PixKeyModificationResponse modifyPixKey(PixKeyModificationRequest pixKeyRegisterRequest, RegistrationModification registrationModification) {
        return registrationModification.modify(pixKeyRegisterRequest);
    }


}
