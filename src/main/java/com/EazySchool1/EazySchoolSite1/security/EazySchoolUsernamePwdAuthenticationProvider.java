package com.EazySchool1.EazySchoolSite1.security;

import com.EazySchool1.EazySchoolSite1.model.Person;
import com.EazySchool1.EazySchoolSite1.model.Roles;
import com.EazySchool1.EazySchoolSite1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EazySchoolUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String email = authentication.getName();
        String pwd=authentication.getCredentials().toString();
        Person person=personRepository.readByEmail(email);
        if(person!=null && person.getPersonId()>0 && passwordEncoder.matches(pwd,person.getPwd()))
        {
            return new UsernamePasswordAuthenticationToken
                    (email,pwd,getGrantedAuthorities(person.getRoles()));
        }
        else
        {
         throw new BadCredentialsException("Invalid Credentials!");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles)
    {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
            return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
