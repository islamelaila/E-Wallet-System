package Service;

public interface AccountValidationService {

    boolean isUserNameValid(String userName);
    boolean isEmailValid(String email);
    boolean isPasswordValid(String password);
    boolean isPhoneNumberValid(String phoneNumber);
}
