package kicial.demoApp.CarRegister.Domain.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client not found")
public class ClientNotFoundException extends Exception {
    public ClientNotFoundException() {
        super("Client not found.");
    }
}
