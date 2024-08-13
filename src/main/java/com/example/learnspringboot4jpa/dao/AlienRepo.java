package com.example.learnspringboot4jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.learnspringboot4jpa.model.Alien;

@Repository
//public interface AlienRepo extends CrudRepository<Alien, Integer> {
public interface AlienRepo extends JpaRepository<Alien, Integer> {

	List<Alien> findByTech(String lang);

	List<Alien> findByAidGreaterThan(int id);

	@Query("from Alien where tech=?1 order by aid desc")
	List<Alien> findAllAliensByJavaInDescOrder(String tech);

}
