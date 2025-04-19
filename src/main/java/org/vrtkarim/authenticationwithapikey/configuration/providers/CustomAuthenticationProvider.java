package org.vrtkarim.authenticationwithapikey.configuration.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.vrtkarim.authenticationwithapikey.configuration.authentication.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${secret.key}")
    private String apiKey;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomAuthentication ca = (CustomAuthentication) authentication;
        String key = ca.getKey();
        if (apiKey.equals(key)){
            return new CustomAuthentication(true, null);

        }

        throw new BadCredentialsException("Invalid API Key");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
