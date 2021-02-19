package com.api.market.web.controller;

import com.api.market.domain.dto.AuthenticationRequest;
import com.api.market.domain.dto.AuthenticationResponse;
import com.api.market.domain.service.MarketUserDetailsService;
import com.api.market.web.security.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Api(value = "Authentication", description = "REST API for authentication", tags = { "Authentication" })
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MarketUserDetailsService marketUserDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/authenticate")
	@ApiOperation("Get token to authenticate")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 403, message = "Access Denied"),
	})
	public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails userDetails = marketUserDetailsService.loadUserByUsername(request.getUsername());
			String jwt = jwtUtil.generateToken(userDetails);
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);

		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
