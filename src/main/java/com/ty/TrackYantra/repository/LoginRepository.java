package com.ty.TrackYantra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.TrackYantra.dto.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
