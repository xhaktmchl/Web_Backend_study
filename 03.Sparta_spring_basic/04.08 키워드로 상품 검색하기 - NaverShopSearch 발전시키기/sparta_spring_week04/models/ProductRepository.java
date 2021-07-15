package com.sparta_spring.sparta_spring_week04.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
