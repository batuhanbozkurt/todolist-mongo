package com.bozkurt.todolistmongo.provider;

import com.bozkurt.todolistmongo.model.User;
import com.bozkurt.todolistmongo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(AuthenticationProviderImpl.class);

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();
        logger.info("Authantication has started for user {}", id);

        try {
            User user = userService.findById(id);
            if(user.getPassword().equals(bCryptPasswordEncoder.encode(password))){
                return new UsernamePasswordAuthenticationToken(user, password, Collections.emptyList());
            }
            throw new AuthenticationCredentialsNotFoundException("User could not authanticated.");
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("User could not authanticated.", e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
