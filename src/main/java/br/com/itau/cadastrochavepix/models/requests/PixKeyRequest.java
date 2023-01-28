package br.com.itau.cadastrochavepix.models.requests;

public record PixKeyRequest(
        String pixKeyType,
        String pixKey,
        String pixAccountType,
        Integer agencyNumber,
        Integer accountNumber,
        String accountHolderName,
        String accountHolderLastName
) {

}
