package br.com.itau.cadastrochavepix.app.model.enums;

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

    public abstract RegistrationValidation validateFactory();

}
