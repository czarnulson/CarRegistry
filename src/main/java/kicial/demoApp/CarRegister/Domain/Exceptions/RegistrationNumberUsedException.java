package kicial.demoApp.CarRegister.Domain.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Registration number already used")
public class RegistrationNumberUsedException extends Exception{
    public RegistrationNumberUsedException() {
        super("Registration number already used.");
    }
}
