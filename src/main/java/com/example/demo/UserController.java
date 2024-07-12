package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
	@RequestMapping("/api/users")
	public class UserController {
	    
	    @Autowired
	    private userrepository userrepository;
	    
	    @GetMapping
	    public List<User> getAllUsers() {
	        return userrepository.findAll();
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        Optional<User> user = userrepository.findById(id);
	        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	    
	    // Other CRUD operations as needed
	}


