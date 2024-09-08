package com.library.loren.service;

import java.util.List;

public interface BaseService<T> {

    T save(T t);

    T update(T t);

    T findById(Long id);

    void deleteById(Long id);

    List<T> findAll();
}
