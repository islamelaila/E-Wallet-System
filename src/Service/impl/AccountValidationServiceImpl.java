package Service.impl;

import Model.User;
import Service.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {
    @Override
    public boolean isUserNameValid(String userName) {
        userName = userName.trim();
        if (userName.length() < 2 || userName.length() > 20) {
            return false;
        }
            char firstChar = userName.charAt(0);
        if (!Character.isUpperCase(firstChar) ) {
                return false;
            }

        return true;
    }

    @Override
    public boolean isEmailValid(String email) {
        email = email.trim();
        if (!email.contains("@gmail.com")){
            return false;
        }
        return true;
    }

    @Override
    public boolean isPasswordValid(String password) {
        if (!(password.length() >=10)){
            return false;
        }
        String letter = "[@#$%&^*_+)(!]";
        for (char c : password.toCharArray()){
            if (Character.isUpperCase(c)){
                return true;
            }

            if (letter.contains(String.valueOf(c))){
                return true;
            }
        }


        return true;
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) {
        if (!(phoneNumber.length() == 12) ){
            return false;
        }
        if (!phoneNumber.startsWith("20")){
            return false;
            }
        return true;
    }
}
