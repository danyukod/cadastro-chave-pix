package br.com.itau.cadastrochavepix.models.enums;

import br.com.itau.cadastrochavepix.entities.registration.validate.PixKeyRegistrationValidate;
import br.com.itau.cadastrochavepix.entities.registration.validate.impl.*;

public enum PixKeyType {
    //Strategy pattern && Factory pattern
    CPF {
        @Override
        public PixKeyRegistrationValidate validateFactory() {
            return new CpfPixKeyRegistrationValidate();
        }
    },
    CNPJ {
        @Override
        public PixKeyRegistrationValidate validateFactory() {
            return new CnpjPixKeyRegistrationValidate();
        }
    },
    PHONE {
        @Override
        public PixKeyRegistrationValidate validateFactory() {
            return new PhonePixKeyRegistrationValidate();
        }
    },
    EMAIL {
        @Override
        public PixKeyRegistrationValidate validateFactory() {
            return new EmailPixKeyRegistrationValidate();
        }
    },
    RANDOM {
        @Override
        public PixKeyRegistrationValidate validateFactory() {
            return new RandomPixKeyRegistrationValidate();
        }
    };

    public abstract PixKeyRegistrationValidate validateFactory();

}
