package br.com.itau.cadastrochavepix.domain.services.impl;

import br.com.itau.cadastrochavepix.adapters.input.web.model.request.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.domain.entity.Account;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;
import br.com.itau.cadastrochavepix.domain.services.DomainService;

public class PixKeyService implements DomainService<PixKey, PixKeyRegisterRequest> {

    private DomainService<Account, PixKeyRegisterRequest> domainService;

    public PixKeyService(DomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public PixKey create(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var account = domainService.create(pixKeyRegisterRequest);

        return new PixKey(pixKeyRegisterRequest.pixKeyType(),
                pixKeyRegisterRequest.pixKey(),
                account);
    }

}
