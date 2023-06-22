package br.com.itau.cadastrochavepix.adapters.input.web.model.responses;

import br.com.itau.cadastrochavepix.adapters.input.web.model.enums.AccountType;
import br.com.itau.cadastrochavepix.adapters.input.web.model.enums.PixKeyType;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

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
