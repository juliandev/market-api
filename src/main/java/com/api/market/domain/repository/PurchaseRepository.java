package com.api.market.domain.repository;

import com.api.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

	List<Purchase> getAllPurchases();
	Optional<List<Purchase>> getPurchasesByClient(String clientId);
	Purchase save(Purchase purchase);

}
