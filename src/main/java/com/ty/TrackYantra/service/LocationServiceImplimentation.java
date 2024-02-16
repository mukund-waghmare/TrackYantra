package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dao.LocationDao;
import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.LocationByAddressNotFound;
import com.ty.TrackYantra.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImplimentation implements LocationService {

    @Autowired
    private LocationDao locationDao;


    @Override
    public ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(String address) {
        Location location = locationDao.findLocationByLocationAddress(address);
        if (location!=null){
            ResponseStructure<Location> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Success");
            responseStructure.setData(location);
            return new ResponseEntity<ResponseStructure<Location>>(responseStructure,HttpStatus.OK);
        }else
            throw new LocationByAddressNotFound("Location Of Corresponding Address Not Found");
    }
}
