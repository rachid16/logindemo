package com.rachid.logindemo.registration;

import com.rachid.logindemo.appuser.AppUser;
import com.rachid.logindemo.appuser.AppUserRole;
import com.rachid.logindemo.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail) throw new IllegalStateException("Email not valid");

        return appUserService.signUpUser( new AppUser(request.getFirstName(),
                request.getLastName(), request.getEmail(), request.getPassword(), AppUserRole.USER ));
    }
}
