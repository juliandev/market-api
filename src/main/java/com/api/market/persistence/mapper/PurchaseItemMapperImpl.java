package com.api.market.persistence.mapper;

import com.api.market.domain.PurchaseItem;
import com.api.market.persistence.entity.ComprasProducto;
import com.api.market.persistence.mapper.PurchaseItemMapper;

import org.springframework.stereotype.Component;

@Component(value = "purchaseItemMapperV0")
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

	@Override
	public PurchaseItem toPurchaseItem(ComprasProducto producto) {
		PurchaseItem purchaseItem = null;
		if (producto != null) {
			purchaseItem = new PurchaseItem();
			purchaseItem.setProductId(producto.getId().getIdProducto());
			purchaseItem.setQuantity(producto.getCantidad());
			purchaseItem.setActive(producto.getEstado());
		}
		return purchaseItem;
	}

	@Override
	public ComprasProducto toComprasProducto(PurchaseItem item) {
		ComprasProducto comprasProducto = null;
		if (item != null) {
			comprasProducto = new ComprasProducto();
			comprasProducto.setCantidad(item.getQuantity());
			comprasProducto.setTotal(item.getTotal());
			comprasProducto.setEstado(item.isActive());
		}
		return comprasProducto;
	}

}
