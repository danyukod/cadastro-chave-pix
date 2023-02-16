package br.com.itau.cadastrochavepix.domain.inclusion.impl;

import br.com.itau.cadastrochavepix.app.model.mapper.DatabasePixKeyMapper;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;
import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.infra.repository.PixKeyRepository;

public class DataBaseRegistrationInclusion implements RegistrationInclusion {

    private final PixKeyRepository pixKeyRepository;

    private final DatabasePixKeyMapper pixKeyMapper;

    public DataBaseRegistrationInclusion(PixKeyRepository pixKeyRepository, DatabasePixKeyMapper pixKeyMapper) {
        this.pixKeyRepository = pixKeyRepository;
        this.pixKeyMapper = pixKeyMapper;
    }


    @Override
    public PixKeyRegisterResponse includes(PixKey pixKey) {

        var pixKeyToSave = pixKeyMapper.mapPixKeyToInfraPixKey(pixKey);

        validatesExistingPixKey(pixKeyToSave.getPixKey());
        validatesPixKeyAmount(pixKeyToSave.getAgencyNumber(), pixKeyToSave.getAccountNumber());

        var savedPixKey = pixKeyRepository.save(pixKeyToSave);

        return pixKeyMapper.mapPixKeyToRegisterResponse(savedPixKey);
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
