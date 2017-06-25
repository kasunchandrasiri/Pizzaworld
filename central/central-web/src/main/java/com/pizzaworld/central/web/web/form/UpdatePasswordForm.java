package com.pizzaworld.central.web.web.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdatePasswordForm {
    private Long userId;

    @NotEmpty(message = "Current password cannot be empty")
    private String currentPassword;

    @NotEmpty(message = "New password cannot be empty")
    private String newPassword;

    @NotEmpty(message = "New confirm password cannot be empty")
    private String newPasswordConfirmed;

    public UpdatePasswordForm() {
    }

    public UpdatePasswordForm(Long userId) {
        this.userId = userId;
    }

    public UpdatePasswordForm(Long userId, String currentPassword, String newPassword, String newPasswordConfirmed) {
        this.userId = userId;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.newPasswordConfirmed = newPasswordConfirmed;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirmed() {
        return newPasswordConfirmed;
    }

    public void setNewPasswordConfirmed(String newPasswordConfirmed) {
        this.newPasswordConfirmed = newPasswordConfirmed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
