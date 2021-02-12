package com.api.market.persistence.mapper;

import com.api.market.domain.Purchase;
import com.api.market.persistence.entity.Compra;
import com.api.market.persistence.mapper.PurchaseMapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "purchaseMapperV0")
public class PurchaseMapperImpl implements PurchaseMapper {

	@Override
	public Purchase toPurchase(Compra compra) {
		return null;
	}

	@Override
	public List<Purchase> toPurchases(List<Compra> compras) {
		return null;
	}

	@Override
	public Compra toCompra(Purchase purchase) {
		return null;
	}

}
