package com.ty.TrackYantra.exception;

public class LocationByAddressNotFound extends RuntimeException{
    public LocationByAddressNotFound(String message) {
        super(message);
    }
}
