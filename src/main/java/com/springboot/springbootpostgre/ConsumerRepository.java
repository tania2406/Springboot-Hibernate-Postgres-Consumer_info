package com.springboot.springbootpostgre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ConsumerRepository extends JpaRepository<Consumer,Integer>{

	List<Consumer> findByName(String name);

	List<Consumer> findByCity(String city);

	List<Consumer> findByNameAndCity(String name, String city);

	List<Consumer> findByNameAndAge(String name, int age);

	List<Consumer> findByNameOrAge(String name, int age);

	List<Consumer> findByNameOrCity(String name, String city);

	

}
