package org.vrtkarim.authenticationwithapikey.configuration.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.vrtkarim.authenticationwithapikey.configuration.providers.CustomAuthenticationProvider;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    private final CustomAuthenticationProvider customAuthenticationProvider;

    public CustomAuthenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (customAuthenticationProvider.supports(authentication.getClass())){
            return customAuthenticationProvider.authenticate(authentication);
        }
        throw new BadCredentialsException(":(");
    }
}
