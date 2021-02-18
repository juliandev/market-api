package com.api.market.persistence.mapper;

import com.api.market.domain.Category;
import com.api.market.domain.Product;
import com.api.market.domain.Purchase;
import com.api.market.domain.PurchaseItem;
import com.api.market.persistence.entity.Compra;
import com.api.market.persistence.entity.ComprasProducto;
import com.api.market.persistence.entity.ComprasProductoPK;
import com.api.market.persistence.entity.Producto;
import com.api.market.persistence.mapper.PurchaseMapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "purchaseMapperV0")
public class PurchaseMapperImpl implements PurchaseMapper {

	@Override
	public Purchase toPurchase(Compra compra) {
		Purchase purchase = null;
		if (compra != null) {
			purchase = new Purchase();
			purchase.setPurchaseId(compra.getIdCompra());
			purchase.setClientId(compra.getIdCliente());
			purchase.setDate(compra.getFecha());
			purchase.setPaymentMethod(compra.getMedioPago());
			purchase.setComment(compra.getComentario());
			purchase.setState(compra.getEstado());
			
			if (compra.getProductos() != null) {
				List<PurchaseItem> items = new ArrayList<>();
				for (ComprasProducto producto : compra.getProductos()) {
					PurchaseItem purchaseItem = new PurchaseItem();
					purchaseItem.setProductId(producto.getId().getIdProducto());
					purchaseItem.setQuantity(producto.getCantidad());
					purchaseItem.setTotal(producto.getTotal());
					purchaseItem.setActive(producto.getEstado());
					items.add(purchaseItem);
				}
				purchase.setItems(items);
			}
		}
		return purchase;
	}

	@Override
	public List<Purchase> toPurchases(List<Compra> compras) {
		List<Purchase> purchases = null;
		if (compras != null) {
			purchases = new ArrayList<>();
			for (Compra compra : compras) {
				Purchase purchase = new Purchase();
				purchase.setPurchaseId(compra.getIdCompra());
				purchase.setClientId(compra.getIdCliente());
				purchase.setDate(compra.getFecha());
				purchase.setPaymentMethod(compra.getMedioPago());
				purchase.setComment(compra.getComentario());
				purchase.setState(compra.getEstado());
				
				if (compra.getProductos() != null) {
					List<PurchaseItem> items = new ArrayList<>();
					for (ComprasProducto producto : compra.getProductos()) {
						PurchaseItem purchaseItem = new PurchaseItem();
						purchaseItem.setProductId(producto.getId().getIdProducto());
						purchaseItem.setQuantity(producto.getCantidad());
						purchaseItem.setTotal(producto.getTotal());
						purchaseItem.setActive(producto.getEstado());
						items.add(purchaseItem);
					}
					purchase.setItems(items);
				}
				purchases.add(purchase);
                        }
		}
		return purchases;
	}

	@Override
	public Compra toCompra(Purchase purchase) {
		Compra compra = null;
		if (purchase != null) {
			compra = new Compra();
			compra.setIdCliente(purchase.getClientId());
			compra.setFecha(purchase.getDate());
			compra.setMedioPago(purchase.getPaymentMethod());
			compra.setComentario(purchase.getComment());
			compra.setEstado(purchase.getState());
			
			List<ComprasProducto> productos = new ArrayList<>();
			for(PurchaseItem item : purchase.getItems()) {
				ComprasProducto comprasProducto = new ComprasProducto();
				ComprasProductoPK comprasProductoPK = new ComprasProductoPK();
				comprasProductoPK.setIdProducto(item.getProductId());
				comprasProducto.setId(comprasProductoPK);
				comprasProducto.setCantidad(item.getQuantity());
				comprasProducto.setTotal(item.getTotal());
				comprasProducto.setEstado(item.isActive());
				productos.add(comprasProducto);
			}
			compra.setProductos(productos);
			
		}
		return compra;
	}

}
