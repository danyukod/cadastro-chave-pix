package br.com.itau.cadastrochavepix.domain.modification.impl;

import br.com.itau.cadastrochavepix.domain.modification.RegistrationModification;
import br.com.itau.cadastrochavepix.app.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyModificationResponse;

public class DataBaseRegistrationModification implements RegistrationModification {
    @Override
    public PixKeyModificationResponse modify(PixKeyModificationRequest pixKeyModificationRequest) {
        return new PixKeyModificationResponse();
    }
}
