package com.example.demo.service;

import java.util.Collection;

/*
generic common service contains standard calls
 */
public interface BaseService<T, K> {
    /*
    get item from repository
    @param id of item to be selected
     */
    T getById(K id);
    /*
    get all items from repository
     */
    Collection<T> getAll();
    /*
    save item into repository
    @param item to add or edit
     */
    void save(T item);
    /*
    delete item from repository
    @param item to be deleted
     */
    void delete(T item);
    /*
    delete item from repository
    @param id to define item to be deleted
     */
    void deleteById(K id);
}
