package br.com.itau.cadastrochavepix.app.model.requests;

import br.com.itau.cadastrochavepix.app.model.enums.AccountType;
import br.com.itau.cadastrochavepix.app.model.enums.PixKeyType;
import jakarta.validation.constraints.NotNull;

public interface PixKeyRequest {

    String pixKey();

    PixKeyType pixKeyType();

    @NotNull AccountType accountType();

    Integer agencyNumber();

    Integer accountNumber();

}
