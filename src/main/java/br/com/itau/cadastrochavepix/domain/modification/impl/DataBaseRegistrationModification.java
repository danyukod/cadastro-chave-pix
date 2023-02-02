package br.com.itau.cadastrochavepix.domain.modification.impl;

import br.com.itau.cadastrochavepix.domain.modification.RegistrationModification;
import br.com.itau.cadastrochavepix.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyModificationResponse;

public class DataBaseRegistrationModification implements RegistrationModification {
    @Override
    public PixKeyModificationResponse modification(PixKeyModificationRequest pixKeyModificationRequest) {
        return new PixKeyModificationResponse();
    }
}
