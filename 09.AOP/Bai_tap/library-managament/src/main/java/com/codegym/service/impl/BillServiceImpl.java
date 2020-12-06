package com.codegym.service.impl;

import com.codegym.entity.Bill;
import com.codegym.entity.Book;
import com.codegym.repository.BillRepository;
import com.codegym.repository.BookRepository;
import com.codegym.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> findAll() {
        return this.billRepository.findAll();
    }

    @Override
    public void save(Bill bill) {
        this.billRepository.save(bill);
    }

    @Override
    public void remove(int id) {
      this.billRepository.deleteById(id);
    }

    @Override
    public Bill findById(int id) {
        return this.billRepository.findById(id).get();
    }

    @Override
    public Bill findByBorrowCode(int borrowCode) {
        return this.billRepository.findByBorrowCode(borrowCode);
    }
}
