package br.com.itau.cadastrochavepix.domain.validation;

public interface RegistrationValidation {

    boolean pixKeyValidate(String pixKey);

    boolean accountValidate(String accountType, Integer agencyNumber, Integer accountNumber);

}
