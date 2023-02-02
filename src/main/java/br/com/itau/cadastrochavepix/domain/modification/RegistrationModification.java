package br.com.itau.cadastrochavepix.domain.modification;

import br.com.itau.cadastrochavepix.model.requests.PixKeyModificationRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyModificationResponse;

public interface RegistrationModification {

    PixKeyModificationResponse modification(PixKeyModificationRequest pixKeyModificationRequest);

}
