package com.vibhanshu.locationweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.vibhanshu.locationweb.entities.LocationEntity;



public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}
