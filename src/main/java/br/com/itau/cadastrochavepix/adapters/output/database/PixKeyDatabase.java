package br.com.itau.cadastrochavepix.adapters.output.database;

import br.com.itau.cadastrochavepix.adapters.output.database.model.mapper.DatabasePixKeyMapper;
import br.com.itau.cadastrochavepix.adapters.input.web.model.response.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.PixKey;
import br.com.itau.cadastrochavepix.application.ports.output.PixKeyPort;
import br.com.itau.cadastrochavepix.adapters.output.database.repository.PixKeyRepository;

public class PixKeyDatabase implements PixKeyPort {

    private final PixKeyRepository pixKeyRepository;

    private final DatabasePixKeyMapper pixKeyMapper;

    public PixKeyDatabase(PixKeyRepository pixKeyRepository, DatabasePixKeyMapper pixKeyMapper) {
        this.pixKeyRepository = pixKeyRepository;
        this.pixKeyMapper = pixKeyMapper;
    }


    @Override
    public PixKeyRegisterResponse save(PixKey pixKey) {

        var pixKeyToSave = pixKeyMapper.mapPixKeyToInfraPixKey(pixKey);

        var savedPixKey = pixKeyRepository.save(pixKeyToSave);

        return pixKeyMapper.mapPixKeyToRegisterResponse(savedPixKey);
    }

    @Override
    public boolean existsByPixKey(String pixKey) {
        return pixKeyRepository.existsByPixKey(pixKey);
    }

    @Override
    public Long countByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber) {
        return pixKeyRepository.countByAgencyNumberAndAccountNumber(agencyNumber, accountNumber);
    }


}
