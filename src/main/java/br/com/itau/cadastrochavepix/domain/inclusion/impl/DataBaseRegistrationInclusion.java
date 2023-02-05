package br.com.itau.cadastrochavepix.domain.inclusion.impl;

import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.model.entity.PixKey;
import br.com.itau.cadastrochavepix.model.mapper.PixKeyMapper;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.repository.PixKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBaseRegistrationInclusion implements RegistrationInclusion {

    @Autowired
    PixKeyRepository pixKeyRepository;

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
