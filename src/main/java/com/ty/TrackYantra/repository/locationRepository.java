package com.ty.TrackYantra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.TrackYantra.dto.Location;

public interface locationRepository extends JpaRepository<Location, Integer> {
	

}
