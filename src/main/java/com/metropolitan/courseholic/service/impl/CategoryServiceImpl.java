package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Category;
import com.metropolitan.courseholic.payload.CategoryDto;
import com.metropolitan.courseholic.repository.CategoryRepository;
import com.metropolitan.courseholic.service.CategoryService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import com.metropolitan.courseholic.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    private EntityMapper entityMapper;
    private DTOMapper dtoMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, EntityMapper entityMapper, DTOMapper dtoMapper) {
        this.categoryRepository = categoryRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = entityMapper.mapToCategoryEntity(categoryDto);

        Category newCategory = categoryRepository.save(category);

        CategoryDto categoryResponse = dtoMapper.mapToCategoryDTO(newCategory);

        return categoryResponse;
    }

    @Override
    public CategoryDto findById(long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", String.valueOf(categoryId)));

        return dtoMapper.mapToCategoryDTO(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(category -> dtoMapper.mapToCategoryDTO(category))
                .collect(Collectors.toList());
    }

}
