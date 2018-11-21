package com.example.email.dao;

import com.example.email.bean.category;
import java.util.List;

public interface CategoryDao {
    List<category> findAll();
}
