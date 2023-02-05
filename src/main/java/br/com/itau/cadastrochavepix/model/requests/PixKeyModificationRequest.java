package br.com.itau.cadastrochavepix.model.requests;

import br.com.itau.cadastrochavepix.model.enums.AccountType;
import br.com.itau.cadastrochavepix.model.enums.PixKeyType;

public record PixKeyModificationRequest(
        String pixKey,
        PixKeyType pixKeyType,
        AccountType accountType,
        Integer agencyNumber,
        Integer accountNumber
) implements PixKeyRequest {
}
