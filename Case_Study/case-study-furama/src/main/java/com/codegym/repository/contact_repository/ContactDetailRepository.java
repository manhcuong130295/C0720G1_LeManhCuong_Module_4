package com.codegym.repository.contact_repository;

import com.codegym.entities.contact_entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetail,Integer> {

}