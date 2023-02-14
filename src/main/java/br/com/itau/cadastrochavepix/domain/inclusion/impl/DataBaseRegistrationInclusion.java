package br.com.itau.cadastrochavepix.domain.inclusion.impl;

import br.com.itau.cadastrochavepix.app.model.mapper.PixKeyMapper;
import br.com.itau.cadastrochavepix.app.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;
import br.com.itau.cadastrochavepix.infra.repository.PixKeyRepository;

public class DataBaseRegistrationInclusion implements RegistrationInclusion {

    private final PixKeyRepository pixKeyRepository;

    public DataBaseRegistrationInclusion(PixKeyRepository pixKeyRepository) {
        this.pixKeyRepository = pixKeyRepository;
    }


    @Override
    public PixKeyRegisterResponse includes(PixKeyRegisterRequest request) {
        var mapper = new PixKeyMapper();

        validatesExistingPixKey(request.pixKey());
        validatesPixKeyAmount(request.agencyNumber(), request.accountNumber());

        PixKey pixKey = pixKeyRepository.save(mapper.mapRegisterToPixKey(request));

        return mapper.mapPixKeyToRegisterResponse(pixKey);
    }

    void validatesExistingPixKey(String pixKey) {
        if (pixKeyRepository.existsByPixKey(pixKey))
            throw new IllegalArgumentException("Pix key already exists");
    }

    void validatesPixKeyAmount(Integer agencyNumber, Integer accountNumber) {
        if (pixKeyRepository.countByAgencyNumberAndAccountNumber(agencyNumber, accountNumber) >= 5)
            throw new IllegalArgumentException("Pix key amount exceeded");
    }
}
