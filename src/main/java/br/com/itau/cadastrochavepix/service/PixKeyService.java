package br.com.itau.cadastrochavepix.service;

import br.com.itau.cadastrochavepix.model.requests.PixKeyDeletionRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyDeletionResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyModificationResponse;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

public interface PixKeyService {

    PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRegisterRequest);

    PixKeyModificationResponse modificationPixKey(PixKeyModificationRequest pixKeyModificationRequest);

    PixKeyDeletionResponse deletionPixKey(PixKeyDeletionRequest pixKeyDeletionRequest);

}
