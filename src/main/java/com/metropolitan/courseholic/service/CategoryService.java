package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto findById(long categoryId);

    List<CategoryDto> findAll();

}
