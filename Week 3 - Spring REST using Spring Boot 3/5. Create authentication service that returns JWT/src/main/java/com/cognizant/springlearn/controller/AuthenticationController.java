package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header : {}", authHeader);

        String user = getUser(authHeader);

        LOGGER.debug("Authenticated User : {}", user);

        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {

        LOGGER.debug("Start getUser()");

        // Remove "Basic "
        String encodedCredentials = authHeader.substring("Basic ".length());

        LOGGER.debug("Encoded Credentials : {}", encodedCredentials);

        // Decode Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes);

        LOGGER.debug("Decoded Credentials : {}", credentials);

        // Extract username
        String user = credentials.substring(0, credentials.indexOf(":"));

        LOGGER.debug("User : {}", user);

        LOGGER.debug("End getUser()");

        return user;
    }

    private String generateJwt(String user) {

        LOGGER.debug("Start generateJwt()");

        JwtBuilder builder = Jwts.builder();

        builder.setSubject(user);

        // Token issued time
        builder.setIssuedAt(new Date());

        // Token expiry time (20 minutes)
        builder.setExpiration(new Date(new Date().getTime() + 1200000));

        // Sign the token
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();

        LOGGER.debug("Generated Token : {}", token);

        LOGGER.debug("End generateJwt()");

        return token;
    }
}