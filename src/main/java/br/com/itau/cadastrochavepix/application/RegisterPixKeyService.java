package br.com.itau.cadastrochavepix.application;

import br.com.itau.cadastrochavepix.adapters.input.web.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.adapters.input.web.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.application.ports.input.RegisterPixKeyUsecase;
import br.com.itau.cadastrochavepix.application.ports.output.PixKeyPort;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;
import br.com.itau.cadastrochavepix.domain.services.DomainService;

public class RegisterPixKeyService implements RegisterPixKeyUsecase {

    PixKeyPort pixKeyPort;

    DomainService<PixKey, PixKeyRegisterRequest> domainService;

    public RegisterPixKeyService(PixKeyPort pixKeyPort, DomainService domainService) {
        this.pixKeyPort = pixKeyPort;
        this.domainService = domainService;
    }

    public PixKeyRegisterResponse execute(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var pixKey = domainService.create(pixKeyRegisterRequest);

        validate(pixKey);

        return includesPixKey(pixKey, pixKeyPort);
    }

    private PixKeyRegisterResponse includesPixKey(PixKey pixKey, PixKeyPort pixKeyPort) {
        return pixKeyPort.save(pixKey);
    }

    private void validate(PixKey pixKey) {
        var key = pixKey.getPixKey();
        var agencyNumber = pixKey.getAccount().getAgency();
        var accountNumber = pixKey.getAccount().getNumber();

        validatesExistingPixKey(key);
        validatesPixKeyAmount(agencyNumber, accountNumber);
    }

    private void validatesExistingPixKey(String pixKey) {
        if (pixKeyPort.existsByPixKey(pixKey))
            throw new IllegalArgumentException("Pix key already exists");
    }

    private void validatesPixKeyAmount(Integer agencyNumber, Integer accountNumber) {
        if (pixKeyPort.countByAgencyNumberAndAccountNumber(agencyNumber, accountNumber) >= 5)
            throw new IllegalArgumentException("Pix key amount exceeded");
    }

}
