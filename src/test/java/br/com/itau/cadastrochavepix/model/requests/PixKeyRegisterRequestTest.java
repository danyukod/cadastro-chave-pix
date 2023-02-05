package br.com.itau.cadastrochavepix.model.requests;

import br.com.itau.cadastrochavepix.model.enums.AccountType;
import br.com.itau.cadastrochavepix.model.enums.PixKeyType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PixKeyRegisterRequestTest {

    public static final int AGENCY_NUMBER = 1234;
    public static final int ACCOUNT_NUMBER = 123456;
    public static final String ACCOUNT_HOLDER_NAME = "Fulano";
    public static final String ACCOUNT_HOLDER_LAST_NAME = "de Tal";
    public static final String PIX_KEY = "123456789";

    @Test
    @DisplayName("Test PixKeyRegisterRequest with any PixKeyType")
    public void testPixKeyRegisterRequestWithAnyPixType() {
        PixKeyRegisterRequest pixKeyRegisterRequest =
                new PixKeyRegisterRequest(PixKeyType.CPF,
                        PIX_KEY,
                        AccountType.CORRENTE,
                        AGENCY_NUMBER,
                        ACCOUNT_NUMBER,
                        ACCOUNT_HOLDER_NAME,
                        ACCOUNT_HOLDER_LAST_NAME);

        assertEquals(PixKeyType.CPF, pixKeyRegisterRequest.pixKeyType());
        assertEquals(PIX_KEY, pixKeyRegisterRequest.pixKey());
        assertEquals(AccountType.CORRENTE, pixKeyRegisterRequest.accountType());
        assertEquals(AGENCY_NUMBER, pixKeyRegisterRequest.agencyNumber());
        assertEquals(ACCOUNT_NUMBER, pixKeyRegisterRequest.accountNumber());
        assertEquals(ACCOUNT_HOLDER_NAME, pixKeyRegisterRequest.accountHolderName());
        assertEquals(ACCOUNT_HOLDER_LAST_NAME, pixKeyRegisterRequest.accountHolderLastName());
    }

    @Test
    @DisplayName("Test PixKeyRegisterRequest with RANDOM PixKeyType")
    public void testPixKeyRegisterRequestWithRandomType() {
        PixKeyRegisterRequest pixKeyRegisterRequest =
                new PixKeyRegisterRequest(PixKeyType.RANDOM,
                        null,
                        AccountType.CORRENTE,
                        AGENCY_NUMBER,
                        ACCOUNT_NUMBER,
                        ACCOUNT_HOLDER_NAME,
                        ACCOUNT_HOLDER_LAST_NAME);

        assertEquals(PixKeyType.RANDOM, pixKeyRegisterRequest.pixKeyType());
        assertNotNull(pixKeyRegisterRequest.pixKey());
        assertEquals(AccountType.CORRENTE, pixKeyRegisterRequest.accountType());
        assertEquals(AGENCY_NUMBER, pixKeyRegisterRequest.agencyNumber());
        assertEquals(ACCOUNT_NUMBER, pixKeyRegisterRequest.accountNumber());
        assertEquals(ACCOUNT_HOLDER_NAME, pixKeyRegisterRequest.accountHolderName());
        assertEquals(ACCOUNT_HOLDER_LAST_NAME, pixKeyRegisterRequest.accountHolderLastName());
    }
}