package com.api.market.persistence.mapper;

import com.api.market.domain.Category;
import com.api.market.persistence.entity.Categoria;

public interface CategoryMapper {

	Category toCategory(Categoria categoria);
	Categoria toCategoria(Category category);

}
