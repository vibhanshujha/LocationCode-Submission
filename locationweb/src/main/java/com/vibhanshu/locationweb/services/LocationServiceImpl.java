package com.vibhanshu.locationweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vibhanshu.locationweb.entities.LocationEntity;
import com.vibhanshu.locationweb.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationServices {
	@Autowired
	private LocationRepository repository;
	
	@Override
	public LocationEntity saveLocation(LocationEntity location) {
		// TODO Auto-generated method stub
		return repository.save(location);
	}

	@Override
	public LocationEntity updateLocation(LocationEntity location) {
		// TODO Auto-generated method stub
		return repository.save(location);
	}

	@Override
	public void deleteLocation(LocationEntity location) {
		// TODO Auto-generated method stub
		repository.delete(location);
	}

	@Override
	public LocationEntity getLocationById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<LocationEntity> getAllLocation() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
