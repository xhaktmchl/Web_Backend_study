package com.sparta_spring.sparta_spring_week02_assingment.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
