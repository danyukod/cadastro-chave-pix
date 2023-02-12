package br.com.itau.cadastrochavepix.app.model.responses;

import br.com.itau.cadastrochavepix.app.model.enums.AccountType;
import br.com.itau.cadastrochavepix.app.model.enums.PixKeyType;
import lombok.Builder;

import java.time.LocalDateTime;
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
        LocalDateTime createdAt
) {


}
