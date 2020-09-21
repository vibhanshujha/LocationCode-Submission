package com.vibhanshu.locationweb.services;

import java.util.List;

import com.vibhanshu.locationweb.entities.LocationEntity;

//import com.vibhanshu.location.locationweb.entity.LocationEntity;

public interface LocationServices {
			LocationEntity saveLocation(LocationEntity location);
			LocationEntity updateLocation(LocationEntity location);
			void deleteLocation(LocationEntity location);
			LocationEntity getLocationById(Long id);
			List<LocationEntity>getAllLocation();
}
