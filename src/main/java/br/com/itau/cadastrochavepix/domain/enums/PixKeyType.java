package br.com.itau.cadastrochavepix.domain.enums;

import br.com.itau.cadastrochavepix.domain.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.domain.validation.impl.*;

public enum PixKeyType {
    //Strategy pattern && Factory pattern
    CPF {
        @Override
        public RegistrationValidation validateFactory() {
            return new CpfValidate();
        }
    },
    CNPJ {
        @Override
        public RegistrationValidation validateFactory() {
            return new CnpjValidate();
        }
    },
    PHONE {
        @Override
        public RegistrationValidation validateFactory() {
            return new PhoneValidate();
        }
    },
    EMAIL {
        @Override
        public RegistrationValidation validateFactory() {
            return new EmailValidate();
        }
    },
    RANDOM {
        @Override
        public RegistrationValidation validateFactory() {
            return new RandomValidate();
        }
    };

    public static PixKeyType getPixKeyTypeFromString(String type) {
        return switch (type.toUpperCase()) {
            case "CPF" -> CPF;
            case "CNPJ" -> CNPJ;
            case "PHONE" -> PHONE;
            case "EMAIL" -> EMAIL;
            case "RANDOM" -> RANDOM;
            default -> throw new IllegalArgumentException("Tipo de chave inválido");
        };
    }

    public abstract RegistrationValidation validateFactory();

}
