package com.api.market.web.controller;

import com.api.market.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0")
public class PurchaseController {

        @GetMapping("/purchases")
        public ResponseEntity<List<Purchase>> getAllPurchases() {
                return null;
        }

        @GetMapping("/purchases/clients/{client-id}")
        public ResponseEntity<List<Purchase>> getPurchasesByClient(@PathVariable("client-id") String clientId) {
                return null;
        }

        @PostMapping("/purchases")
        public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
                return null;
        }

}

