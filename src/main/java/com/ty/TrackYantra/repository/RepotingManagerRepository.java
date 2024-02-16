package com.ty.TrackYantra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.TrackYantra.dto.ReportingManager;

public interface RepotingManagerRepository extends JpaRepository<ReportingManager, Integer> {


    ReportingManager findByEmailAndPassword(String reportingManagerEmail, String reportingManagerPassword);
}
