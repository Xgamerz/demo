package com.example.demo.service;

import java.util.Collection;

public interface BaseService<T, K> {
    T getById(K id);
    Collection<T> getAll();
    void save(T item);
    void delete(T item);
    void deleteById(K id);
}
