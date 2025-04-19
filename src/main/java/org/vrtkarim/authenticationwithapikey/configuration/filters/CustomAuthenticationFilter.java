package org.vrtkarim.authenticationwithapikey.configuration.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.vrtkarim.authenticationwithapikey.configuration.authentication.CustomAuthentication;
import org.vrtkarim.authenticationwithapikey.configuration.managers.CustomAuthenticationManager;

import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    public CustomAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        // create an authentication object which is not yet authenticated

        //delegate the authentication object to the manager

        // get back the authentication from the manager

        //if the object is authenticated then send request to the next filter in the chain
        String key = String.valueOf(request.getHeader("key"));
        CustomAuthentication customAuthentication = new CustomAuthentication(false,key);
        var a = customAuthenticationManager.authenticate(customAuthentication);
        if(a.isAuthenticated()){

            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);

        }

    }
}
