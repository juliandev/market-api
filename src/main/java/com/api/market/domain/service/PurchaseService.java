package com.api.market.domain.service;

import com.api.market.domain.Purchase;
import com.api.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	public List<Purchase> getAllPurchases() {
		return purchaseRepository.getAllPurchases();
	}

	public Optional<List<Purchase>> getPurchasesByClient(String clientId) {
		return purchaseRepository.getPurchasesByClient(clientId);
	}

	public Purchase save(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

}
