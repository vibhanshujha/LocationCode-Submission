package com.vibhanshu.locationweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vibhanshu.locationweb.emailutil.EmailUtil;
import com.vibhanshu.locationweb.entities.LocationEntity;
import com.vibhanshu.locationweb.services.LocationServices;

@Controller
public class LocationController {
	@Autowired
	LocationServices service;
	@Autowired
	EmailUtil emailUtil;
	
		@RequestMapping("/showCreate")
		public String showCreate() {
			return "createLocation";
		}
		@RequestMapping("/saveLoc")
		public String saveLocation(@ModelAttribute("location")LocationEntity location, ModelMap modelMap) {
			LocationEntity locationSaved = service.saveLocation(location);
			String msg="location saved with id:" + locationSaved.getId();
			modelMap.addAttribute("msg", msg);
			emailUtil.sendEmail("spring.test116@gmail.com", "Location Saved", "Location Saved Successfully and this is an autogenerated response." );
			
			return "createLocation";
		}
		@RequestMapping("/displayLocations")
		public String displayLocations(ModelMap modelMap) {
			List<LocationEntity>locations=service.getAllLocation();
			modelMap.addAttribute("locations", locations);
			return "displayLocations";
		}
		@RequestMapping("/deleteLocation")
		public String deleteLocation(@RequestParam("id") Long id, ModelMap modelMap) {
			LocationEntity location = service.getLocationById(id);
			service.deleteLocation(location);
			List<LocationEntity> locations = service.getAllLocation();
			modelMap.addAttribute("locations", locations);
			return "displayLocations";
		}
		@RequestMapping("/showUpdate")
		public String showUpdate(@RequestParam("id") Long id, ModelMap modelMap) {
			LocationEntity locations = service.getLocationById(id);
			modelMap.addAttribute("locations", locations);
			return "updateLocation";
		}
		@RequestMapping("/updateLoc")
		public String updateLocation(@ModelAttribute("location")LocationEntity location, ModelMap modelMap) {
			service.updateLocation(location);
			List<LocationEntity> locations = service.getAllLocation();
			modelMap.addAttribute("locations", locations);
			return "displayLocations";
		}
		
}




























