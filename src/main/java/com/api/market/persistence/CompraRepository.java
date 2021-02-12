package com.api.market.persistence;

import com.api.market.domain.Purchase;
import com.api.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

	@Override
	public List<Purchase> getAllPurchases() {
		return null;
	}

	@Override
	public Optional<List<Purchase>> getPurchasesByClient(String clientId) {
		return null;
	}

	@Override
	public Purchase save(Purchase purchase) {
		return null;
	}

}
