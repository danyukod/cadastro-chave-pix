package br.com.itau.cadastrochavepix.app.service;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyDeletionRequest;
import br.com.itau.cadastrochavepix.app.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.app.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyDeletionResponse;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;

public interface PixKeyService {

    PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRegisterRequest);

    PixKeyModificationResponse modificationPixKey(PixKeyModificationRequest pixKeyModificationRequest);

    PixKeyDeletionResponse deletionPixKey(PixKeyDeletionRequest pixKeyDeletionRequest);

}
