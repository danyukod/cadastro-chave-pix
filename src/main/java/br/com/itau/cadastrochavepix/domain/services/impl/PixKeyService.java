package br.com.itau.cadastrochavepix.domain.services.impl;

import br.com.itau.cadastrochavepix.adapters.input.web.model.request.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.domain.Account;
import br.com.itau.cadastrochavepix.domain.PixKey;
import br.com.itau.cadastrochavepix.domain.enums.PixKeyType;
import br.com.itau.cadastrochavepix.domain.services.DomainService;

public class PixKeyService implements DomainService<PixKey, PixKeyRegisterRequest> {

    private DomainService<Account, PixKeyRegisterRequest> domainService;

    public PixKeyService(DomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public PixKey create(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var account = domainService.create(pixKeyRegisterRequest);
        var pixKeyType = PixKeyType.getPixKeyTypeFromString(pixKeyRegisterRequest.pixKeyType());
        return new PixKey(pixKeyType,
                pixKeyRegisterRequest.pixKey(),
                account);
    }

}
