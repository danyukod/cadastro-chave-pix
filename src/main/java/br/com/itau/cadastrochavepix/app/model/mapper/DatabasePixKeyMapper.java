package br.com.itau.cadastrochavepix.app.model.mapper;

import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;

import java.time.LocalDateTime;

public class DatabasePixKeyMapper {

    public br.com.itau.cadastrochavepix.infra.entity.PixKey mapPixKeyToInfraPixKey(PixKey pixKey) {
        var p = pixKey;

        return br.com.itau.cadastrochavepix.infra.entity.PixKey.builder()
                .pixKeyType(p.getPixKeyType())
                .pixKey(p.getPixKey())
                .accountType(p.getAccount().getAccountType())
                .agencyNumber(p.getAccount().getNumber())
                .accountNumber(p.getAccount().getNumber())
                .accountHolderName(p.getAccount().getHolderName())
                .accountHolderLastName(p.getAccount().getHolderLastName())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public PixKeyRegisterResponse mapPixKeyToRegisterResponse(br.com.itau.cadastrochavepix.infra.entity.PixKey pixKey) {
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
