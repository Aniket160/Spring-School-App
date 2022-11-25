package com.EazySchool1.EazySchoolSite1.repository;

import com.EazySchool1.EazySchoolSite1.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles getByRoleName(String roleName);
}