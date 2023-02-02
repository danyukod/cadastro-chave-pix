package br.com.itau.cadastrochavepix.service.database;

import br.com.itau.cadastrochavepix.model.requests.PixKeyDeletionRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyDeletionResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.service.PixKeyService;
import br.com.itau.cadastrochavepix.service.database.impl.PixKeyDeletionService;
import br.com.itau.cadastrochavepix.service.database.impl.PixKeyModificationService;
import br.com.itau.cadastrochavepix.service.database.impl.PixKeyRegistrationService;

public class PixKeyDataBaseService implements PixKeyService {

    @Override
    public PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        return new PixKeyRegistrationService().registerPixKey(pixKeyRegisterRequest);
    }

    @Override
    public PixKeyModificationResponse modificationPixKey(PixKeyModificationRequest pixKeyModificationRequest) {
        return new PixKeyModificationService().updatePixKey(pixKeyModificationRequest);
    }

    @Override
    public PixKeyDeletionResponse deletionPixKey(PixKeyDeletionRequest pixKeyDeletionRequest) {
        return new PixKeyDeletionService().deletePixKey(pixKeyDeletionRequest);
    }

}
