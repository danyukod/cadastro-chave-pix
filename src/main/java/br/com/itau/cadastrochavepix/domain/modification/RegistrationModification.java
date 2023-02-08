package br.com.itau.cadastrochavepix.domain.modification;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyModificationResponse;

public interface RegistrationModification {

    PixKeyModificationResponse modify(PixKeyModificationRequest pixKeyModificationRequest);

}
