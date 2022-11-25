package com.EazySchool1.EazySchoolSite1.service;

import com.EazySchool1.EazySchoolSite1.Constants.EazySchoolConstants;
import com.EazySchool1.EazySchoolSite1.model.Person;
import com.EazySchool1.EazySchoolSite1.model.Roles;
import com.EazySchool1.EazySchoolSite1.repository.PersonRepository;
import com.EazySchool1.EazySchoolSite1.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
   private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
      //  person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));// password erncrypted
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}