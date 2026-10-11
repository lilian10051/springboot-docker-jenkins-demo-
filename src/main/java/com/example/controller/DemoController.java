package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

// 1. Simple REST endpoint returning plain text
	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Spring Boot REST API!";
	}

// 2. Return JSON
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getJson() {
		return Map.of("message", "Hello from Spring Boot", "application", "springbasic", "language", "Java", "status",
				"success");
	}

// 3. Return XML
	@GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public DemoResponse getXml() {
		return new DemoResponse("Hello from Spring Boot", "springbasic", "Java", "success");
	}

// 4. Return a list of objects as JSON
	@GetMapping("/users")
	public List<DemoResponse> getUsers() {
		return List.of(new DemoResponse("Kofi", "User Service", "Java", "active"),
				new DemoResponse("Ama", "User Service", "Java", "active"),
				new DemoResponse("Kwame", "User Service", "Java", "active"));
	}

// 5. Accept JSON through a POST request
	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DemoResponse> createUser(@RequestBody DemoResponse request) {

		return ResponseEntity.status(HttpStatus.CREATED).body(request);
	}

// 6. Return a custom HTTP status
	@GetMapping("/status")
	public ResponseEntity<Map<String, String>> getStatus() {
		return ResponseEntity.ok(Map.of("status", "success", "message", "Request completed successfully"));
	}

// 7. Return JSON or XML based on the Accept header
	@GetMapping(value = "/negotiate", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public DemoResponse negotiateResponse() {
		return new DemoResponse("Content negotiation example", "springbasic", "Java", "success");
	}

}
