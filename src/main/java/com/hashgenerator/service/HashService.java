package com.hashgenerator.service;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class HashService {
    
    public String generateHash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printHexBinary(hash).toLowerCase();
    }
    
    public boolean isValidAlgorithm(String algorithm) {
        try {
            MessageDigest.getInstance(algorithm);
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
