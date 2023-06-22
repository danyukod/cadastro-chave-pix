package br.com.itau.cadastrochavepix.application;

import br.com.itau.cadastrochavepix.adapters.input.web.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.adapters.input.web.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.entity.Account;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;
import br.com.itau.cadastrochavepix.domain.ports.input.RegisterPixKeyUsecase;
import br.com.itau.cadastrochavepix.domain.ports.output.PixKeyPort;

public class RegisterPixKeyService implements RegisterPixKeyUsecase {

    PixKeyPort pixKeyPort;

    public RegisterPixKeyService(PixKeyPort pixKeyPort) {
        this.pixKeyPort = pixKeyPort;
    }

    public PixKeyRegisterResponse execute(PixKeyRegisterRequest pixKeyRegisterRequest) {
        PixKey pixKey = createPixKey(pixKeyRegisterRequest);

        validate(pixKey);

        return includesPixKey(pixKey, pixKeyPort);
    }

    private PixKey createPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        Account account = createAccount(pixKeyRegisterRequest);

        return new PixKey(pixKeyRegisterRequest.pixKeyType(),
                pixKeyRegisterRequest.pixKey(),
                account);
    }

    private Account createAccount(PixKeyRegisterRequest pixKeyRegisterRequest) {
        return new Account(pixKeyRegisterRequest.accountType(),
                pixKeyRegisterRequest.accountNumber(),
                pixKeyRegisterRequest.agencyNumber(),
                pixKeyRegisterRequest.accountHolderName(),
                pixKeyRegisterRequest.accountHolderLastName());
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
