package com.codegym.repository;

import com.codegym.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.object.SqlCall;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
     Bill findByBorrowCode(int borrowCode);
     
}
