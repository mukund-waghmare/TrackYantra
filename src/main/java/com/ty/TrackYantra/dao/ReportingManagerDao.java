package com.ty.TrackYantra.dao;

import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.repository.RepotingManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ReportingManagerDao {
    @Autowired
    private RepotingManagerRepository repotingManagerRepository;

    public ReportingManager getReportingManagerById(int reportingManagerId) {
        Optional<ReportingManager> optionalReportingManager= repotingManagerRepository.findById(reportingManagerId);
        if (optionalReportingManager.isPresent()){
            return optionalReportingManager.get();
        }else
            return null;
    }

    public ReportingManager updateReportingManagerById(ReportingManager recReportingManager) {
        return repotingManagerRepository.save(recReportingManager);
    }

    public ReportingManager deleteReportingManager(ReportingManager recReportingManager) {
         repotingManagerRepository.delete(recReportingManager);
         return recReportingManager;
    }

    public ReportingManager saveReportingManager(ReportingManager reportingManager) {
        return repotingManagerRepository.save(reportingManager);
    }

    public ReportingManager getReportingManagerByEmailAndPassword(String reportingManagerEmail, String reportingManagerPassword) {
        ReportingManager reportingManager = repotingManagerRepository.findByEmailAndPassword(reportingManagerEmail,reportingManagerPassword);
        if (reportingManager!=null){
            return  reportingManager;
        }else
            return null;
    }
}
