package com.Beetles.systempayout.backend.shared.exception;

import java.util.UUID;

public class PaymentNotMadeException extends RuntimeException {
    public PaymentNotMadeException(UUID id) {
        super("Pagamento com Id: "+id+" não foi efetuado");
    }
}
