package com.yash.Examtool2Application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.Examtool2Application.domain.Category;
import com.yash.Examtool2Application.repository.CategoryRepository;
import com.yash.Examtool2Application.service.CategoryService;

@Service 
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Iterable<Category> list() {
		return categoryRepository.findAll();
	}

}
