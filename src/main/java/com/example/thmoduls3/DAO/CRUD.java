package com.example.thmoduls3.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CRUD<E> {
    ArrayList<E> findAll();
    void insert(E e);
    E findById(int id);
    boolean delete(int id) throws SQLException;
    boolean update(E e) throws SQLException;
}
