package com.api.market.persistence.mapper;

import com.api.market.domain.Purchase;
import com.api.market.persistence.entity.Compra;

import java.util.List;

public interface PurchaseMapper {

	Purchase toPurchase(Compra compra);
	List<Purchase> toPurchases(List<Compra> compras);
	Compra toCompra(Purchase purchase);

}
