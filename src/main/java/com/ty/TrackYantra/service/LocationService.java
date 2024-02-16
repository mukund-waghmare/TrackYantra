package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface LocationService {

    ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(String address);
}
