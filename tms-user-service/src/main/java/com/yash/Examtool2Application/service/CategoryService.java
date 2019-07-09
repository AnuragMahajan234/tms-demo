package com.yash.Examtool2Application.service;

import com.yash.Examtool2Application.domain.Category;

public interface CategoryService {
	
	  public Category create(Category category);
		
		public void delete(Long id);
		
		public Category update(Category category);
		
		public Iterable<Category> list();
}
