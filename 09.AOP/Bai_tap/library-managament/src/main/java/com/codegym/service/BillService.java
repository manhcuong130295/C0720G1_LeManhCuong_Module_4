package com.codegym.service;

import com.codegym.entity.Bill;
import com.codegym.entity.Book;

import java.util.List;

public interface BillService {
    List<Bill> findAll();
    void save(Bill bill);
    void remove(int id);
    Bill findById(int id);
    Bill findByBorrowCode(int borrowCode);
}
