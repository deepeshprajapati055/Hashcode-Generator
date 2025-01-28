package com.hashgenerator.controller;

import com.hashgenerator.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HashController {
	
	private static final Logger logger = LoggerFactory.getLogger(HashController.class);

    @Autowired
    private HashService hashService;

    private final List<String> SUPPORTED_ALGORITHMS = Arrays.asList("MD5", "SHA-1", "SHA-256", "SHA-512");

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("algorithms", SUPPORTED_ALGORITHMS);
        return "index";
    }

    @PostMapping("/generate")
    @ResponseBody
    public ResponseEntity<?> generateHash(@RequestParam String input, @RequestParam String algorithm) {
        try {
            if (!SUPPORTED_ALGORITHMS.contains(algorithm)) {
                return ResponseEntity.badRequest().body("Invalid algorithm selected");
            }
            String hash = hashService.generateHash(input, algorithm);
            return ResponseEntity.ok(hash);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error generating hash", e);
            return ResponseEntity.badRequest().body("Error generating hash: " + e.getMessage());
        }
    }
}
