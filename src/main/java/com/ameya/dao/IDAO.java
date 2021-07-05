package com.ameya.dao;

import java.util.List;

public interface IDAO<T> {
    List<T> findAll();

    T findById(Long id);
}
