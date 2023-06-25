package br.com.itau.cadastrochavepix.adapters.output.database.model.mapper;

import br.com.itau.cadastrochavepix.adapters.input.web.model.response.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.adapters.output.database.entity.PixKeyEntity;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;

import java.time.Instant;

public class DatabasePixKeyMapper {

    public PixKeyEntity mapPixKeyToInfraPixKey(PixKey pixKey) {
        var account = pixKey.getAccount();
        var holder = account.getHolder();

        return PixKeyEntity.builder()
                .pixKeyType(pixKey.getPixKeyType())
                .pixKey(pixKey.getPixKey())
                .accountType(account.getAccountType())
                .agencyNumber(account.getNumber())
                .accountNumber(account.getNumber())
                .accountHolderName(holder.getName())
                .accountHolderLastName(holder.getLastName())
                .createdAt(Instant.now())
                .build();
    }

    public PixKeyRegisterResponse mapPixKeyToRegisterResponse(PixKeyEntity pixKey) {

        return PixKeyRegisterResponse.builder()
                .id(pixKey.getId())
                .pixKeyType(pixKey.getPixKeyType())
                .pixKey(pixKey.getPixKey())
                .accountType(pixKey.getAccountType())
                .agencyNumber(pixKey.getAgencyNumber())
                .accountNumber(pixKey.getAccountNumber())
                .accountHolderName(pixKey.getAccountHolderName())
                .accountHolderLastName(pixKey.getAccountHolderLastName())
                .createdAt(pixKey.getCreatedAt())
                .build();
    }

}
