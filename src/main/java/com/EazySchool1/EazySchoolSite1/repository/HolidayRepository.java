package com.EazySchool1.EazySchoolSite1.repository;


import com.EazySchool1.EazySchoolSite1.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday,String> {
}
