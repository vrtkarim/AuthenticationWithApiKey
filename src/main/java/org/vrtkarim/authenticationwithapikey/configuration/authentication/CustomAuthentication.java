package org.vrtkarim.authenticationwithapikey.configuration.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class CustomAuthentication implements Authentication {


    private boolean auth;
    private  String key;
    public CustomAuthentication(boolean auth, String key) {
        this.auth = auth;
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    public void  setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean isAuthenticated() {
        return auth;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

        this.auth=true;
    }





















    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }



    @Override
    public String getName() {
        return "";
    }


}
