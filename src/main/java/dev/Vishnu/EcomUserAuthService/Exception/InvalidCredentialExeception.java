package dev.Vishnu.EcomUserAuthService.Exception;

public class InvalidCredentialExeception extends RuntimeException {

    public InvalidCredentialExeception() {

    }

    public InvalidCredentialExeception(String message) {
        super(message);
    }

}
