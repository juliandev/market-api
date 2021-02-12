package com.api.market.persistence.mapper;

import com.api.market.domain.PurchaseItem;
import com.api.market.persistence.entity.ComprasProducto;

public interface PurchaseItemMapper {

	PurchaseItem toPurchaseItem(ComprasProducto producto);
	ComprasProducto toComprasProducto(PurchaseItem item);

}
