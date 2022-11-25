package com.EazySchool1.EazySchoolSite1.repository;

import com.EazySchool1.EazySchoolSite1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
      Person readByEmail(String email);
}