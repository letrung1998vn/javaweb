/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.registration;

import java.io.Serializable;

/**
 *
 * @author letru
 */
public class RegistrationCreateError implements Serializable{
    private String userNameLengthError;
    private String passwordLengthError;
    private String confirmLengthError;
    private String fullNameLengthError;
    private String userNameisExist;

    public String getUserNameLengthError() {
        return userNameLengthError;
    }

    public void setUserNameLengthError(String userNameLengthError) {
        this.userNameLengthError = userNameLengthError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    

    public String getConfirmLengthError() {
        return confirmLengthError;
    }

    public void setConfirmLengthError(String confirmLengthError) {
        this.confirmLengthError = confirmLengthError;
    }

    public String getFullNameLengthError() {
        return fullNameLengthError;
    }

    public void setFullNameLengthError(String fullNameLengthError) {
        this.fullNameLengthError = fullNameLengthError;
    }

    public String getUserNameisExist() {
        return userNameisExist;
    }

    public void setUserNameisExist(String userNameisExist) {
        this.userNameisExist = userNameisExist;
    }
    
}
