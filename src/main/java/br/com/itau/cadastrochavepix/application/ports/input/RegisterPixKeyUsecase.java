package br.com.itau.cadastrochavepix.application.ports.input;

import br.com.itau.cadastrochavepix.adapters.input.web.model.request.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.adapters.input.web.model.response.PixKeyRegisterResponse;

public interface RegisterPixKeyUsecase {

    PixKeyRegisterResponse execute(PixKeyRegisterRequest pixKeyRegisterRequest);

}
