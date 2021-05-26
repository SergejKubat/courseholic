package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.model.Category;
import com.metropolitan.courseholic.payload.CategoryDto;
import com.metropolitan.courseholic.repository.CategoryRepository;
import com.metropolitan.courseholic.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = mapToEntity(categoryDto);

        Category newCategory = categoryRepository.save(category);

        CategoryDto categoryResponse = mapToDTO(newCategory);

        return categoryResponse;
    }

    private CategoryDto mapToDTO(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        return categoryDto;
    }

    private Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();

        category.setName(categoryDto.getName());

        return category;
    }

}
