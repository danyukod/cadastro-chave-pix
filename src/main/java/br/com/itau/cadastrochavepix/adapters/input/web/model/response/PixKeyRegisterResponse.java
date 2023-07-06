package br.com.itau.cadastrochavepix.adapters.input.web.model.response;

import br.com.itau.cadastrochavepix.domain.enums.AccountType;
import br.com.itau.cadastrochavepix.domain.enums.PixKeyType;
import lombok.Builder;

import java.time.Instant;

@Builder
public record PixKeyRegisterResponse(
        String id,
        PixKeyType pixKeyType,
        String pixKey,
        AccountType accountType,
        Integer agencyNumber,
        Integer accountNumber,
        String accountHolderName,
        String accountHolderLastName,
        Instant createdAt
) {
}
