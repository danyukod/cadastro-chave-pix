package br.com.itau.cadastrochavepix.adapters.input.web.controller;

import br.com.itau.cadastrochavepix.adapters.input.web.model.request.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.adapters.input.web.model.response.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.application.ports.input.RegisterPixKeyUsecase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pix/keys")
public class PixKeyController {

    private RegisterPixKeyUsecase registerPixKeyUsecase;

    public PixKeyController(RegisterPixKeyUsecase registerPixKeyUsecase) {
        this.registerPixKeyUsecase = registerPixKeyUsecase;
    }

    @PostMapping
    PixKeyRegisterResponse registerPixKey(@RequestBody @Valid PixKeyRegisterRequest request) {
        return registerPixKeyUsecase.execute(request);
    }


}
