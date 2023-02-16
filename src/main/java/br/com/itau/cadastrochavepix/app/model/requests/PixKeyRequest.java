package br.com.itau.cadastrochavepix.app.model.requests;

import br.com.itau.cadastrochavepix.app.model.enums.AccountType;
import br.com.itau.cadastrochavepix.app.model.enums.PixKeyType;

public interface PixKeyRequest {

    String pixKey();

    String pixKeyType();

    String accountType();

    Integer agencyNumber();

    Integer accountNumber();

}
