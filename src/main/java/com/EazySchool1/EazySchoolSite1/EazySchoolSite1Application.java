package com.EazySchool1.EazySchoolSite1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.EazySchool1.EazySchoolSite1.repository")
@EntityScan("com.EazySchool1.EazySchoolSite1.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class EazySchoolSite1Application {

	public static void main(String[] args) {
		SpringApplication.run(EazySchoolSite1Application.class, args);
	}

}
