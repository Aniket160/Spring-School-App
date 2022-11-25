package com.EazySchool1.EazySchoolSite1.repository;

import com.EazySchool1.EazySchoolSite1.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {

  List<Contact> findByStatus(String status);
}
