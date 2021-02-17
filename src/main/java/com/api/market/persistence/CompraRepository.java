package com.api.market.persistence;

import javax.annotation.Resource;

import com.api.market.domain.Purchase;
import com.api.market.domain.repository.PurchaseRepository;
import com.api.market.persistence.crud.CompraCrudRepository;
import com.api.market.persistence.entity.Compra;
import com.api.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

	@Autowired
	private CompraCrudRepository compraCrudRepository;

	@Resource(name = "purchaseMapperV0")
	private PurchaseMapper mapper;

	@Override
	public List<Purchase> getAllPurchases() {
		return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
	}

	@Override
	public Optional<List<Purchase>> getPurchasesByClient(String clientId) {
		return compraCrudRepository.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
	}

	@Override
	public Purchase save(Purchase purchase) {
		Compra compra = mapper.toCompra(purchase);
		compra.getProductos().forEach(producto -> producto.setCompra(compra));
		return mapper.toPurchase(compraCrudRepository.save(compra));
	}

}
