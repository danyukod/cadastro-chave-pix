package br.com.itau.cadastrochavepix.app.controller;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.app.service.PixKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pix/keys")
public class PixKeyController {

    private PixKeyService pixKeyService;

    @Autowired
    public PixKeyController(PixKeyService pixKeyService) {
        this.pixKeyService = pixKeyService;
    }

    @PostMapping
    PixKeyRegisterResponse registerPixKey(@RequestBody PixKeyRegisterRequest request) {
        return pixKeyService.registerPixKey(request);
    }


}
