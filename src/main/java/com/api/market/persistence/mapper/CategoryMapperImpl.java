package com.api.market.persistence.mapper;

import com.api.market.domain.Category;
import com.api.market.persistence.entity.Categoria;
import com.api.market.persistence.mapper.CategoryMapper;

import org.springframework.stereotype.Component;

@Component(value = "categoryMapperV0")
public class CategoryMapperImpl implements CategoryMapper {

	@Override
	public Category toCategory(Categoria categoria) {
		Category category = null;
		if (categoria != null) {
			category = new Category();
			category.setCategoryId(categoria.getIdCategoria());
			category.setCategory(categoria.getDescripcion());
			category.setActive(categoria.getEstado());

		}
		return category;
	}

	@Override
	public Categoria toCategoria(Category category) {
		return null;
	}

}
