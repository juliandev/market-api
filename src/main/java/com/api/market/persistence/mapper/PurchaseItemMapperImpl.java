package com.api.market.persistence.mapper;

import com.api.market.domain.PurchaseItem;
import com.api.market.persistence.entity.ComprasProducto;
import com.api.market.persistence.mapper.PurchaseItemMapper;

import org.springframework.stereotype.Component;

@Component(value = "purchaseItemMapperV0")
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

	@Override
	public PurchaseItem toPurchaseItem(ComprasProducto producto) {
		return null;
	}

	@Override
	public ComprasProducto toComprasProducto(PurchaseItem item) {
		return null;
	}

}
