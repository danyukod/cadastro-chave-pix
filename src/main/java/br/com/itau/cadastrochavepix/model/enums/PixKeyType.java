package br.com.itau.cadastrochavepix.model.enums;

import br.com.itau.cadastrochavepix.entity.registration.validate.RegistrationValidate;
import br.com.itau.cadastrochavepix.entity.registration.validate.impl.*;

public enum PixKeyType {
    //Strategy pattern && Factory pattern
    CPF {
        @Override
        public RegistrationValidate validateFactory() {
            return new CpfRegistrationValidate();
        }
    },
    CNPJ {
        @Override
        public RegistrationValidate validateFactory() {
            return new CnpjRegistrationValidate();
        }
    },
    PHONE {
        @Override
        public RegistrationValidate validateFactory() {
            return new PhoneRegistrationValidate();
        }
    },
    EMAIL {
        @Override
        public RegistrationValidate validateFactory() {
            return new EmailRegistrationValidate();
        }
    },
    RANDOM {
        @Override
        public RegistrationValidate validateFactory() {
            return new RandomRegistrationValidate();
        }
    };

    public abstract RegistrationValidate validateFactory();

}
