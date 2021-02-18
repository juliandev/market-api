package com.api.market.web.controller;

import com.api.market.domain.Purchase;
import com.api.market.domain.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0")
@Api(value = "Purchases", description = "REST API for manage Purchases", tags = { "Purchases" })
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

        @GetMapping("/purchases")
	@ApiOperation("Get all purchases")
	@ApiResponse(code = 200, message = "OK")
        public ResponseEntity<List<Purchase>> getAllPurchases() {
                return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
        }

        @GetMapping("/purchases/customers/{customer-id}")
	@ApiOperation("Get all customer's purchases")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 404, message = "Purchases not found"),
	})
        public ResponseEntity<List<Purchase>> getPurchasesByClient(@PathVariable("customer-id") String clientId) {
                return purchaseService.getPurchasesByClient(clientId)
			.map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping("/purchases")
	@ApiOperation("Create purchase")
	@ApiResponse(code = 201, message = "CREATED")
        public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
                return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
        }

}

