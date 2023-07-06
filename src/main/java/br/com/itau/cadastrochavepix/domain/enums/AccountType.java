package br.com.itau.cadastrochavepix.domain.enums;

public enum AccountType {
    CORRENTE,
    POUPANCA;

    public static AccountType getAccountTypeFromString(String type) {
        return switch (type.toUpperCase()) {
            case "CORRENTE" -> CORRENTE;
            case "POUPANCA" -> POUPANCA;
            default -> throw new IllegalArgumentException("Tipo de conta inválido");
        };
    }
}
