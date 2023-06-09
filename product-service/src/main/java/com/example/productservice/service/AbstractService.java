package com.example.productservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, ID> implements Service<T, ID> {
    protected JpaRepository<T, ID> jpaRepository;

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return jpaRepository.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Override
    public Page<T> findAll(Pageable pageable, String sortBy) {
        if (sortBy == null) {
            return findAll(pageable);
        }

        pageable = getPageable(pageable, sortBy);

        return findAll(pageable);
    }

    protected Pageable getPageable(Pageable pageable, String sortBy) {
        char order = sortBy.charAt(0);
        sortBy = sortBy.replaceFirst(order + "_", "");
        if (order == 'a') {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(Sort.Direction.ASC, sortBy));
        }

        if (order == 'd') {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(Sort.Direction.DESC, sortBy));
        }
        return pageable;
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public void save(T entity) {
        jpaRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        jpaRepository.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        jpaRepository.deleteAll();
    }
}
