
package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.ReportingManagerDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.IdNotFoundException;
import com.ty.TrackYantra.exception.ReportingManagerNotFound;
import com.ty.TrackYantra.exception.ReportingManagerNotSaved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportingManagerImplementation implements ReportingManagerService {
    @Autowired
    private ReportingManagerDao reportingManagerDao;
    @Autowired
    private AdminDao adminDao;
    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerEmailById(int reportingManagerId, String adminEmail,String adminPassword, ReportingManager reportingManager) {
         ReportingManager recReportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
         Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
         if (admin!=null) {
             if (recReportingManager != null) {
                 recReportingManager.setEmail(reportingManager.getEmail());
                 ReportingManager updatedReportingManager = reportingManagerDao.updateReportingManagerById(recReportingManager);
                 ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                 responseStructure.setStatusCode(HttpStatus.OK.value());
                 responseStructure.setMessage("Updated Successfully");
                 responseStructure.setData(updatedReportingManager);
                 return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure, HttpStatus.OK);
             } else {
                 throw new ReportingManagerNotFound("Reporting Manager Not Found of Specified Id");
             }
         }else
             throw new IdNotFoundException("Admin with specified id");
    }

    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> deleteReportingManagerById(String adminEmail,String adminPassword,int reportingManagerId) {
        ReportingManager recReportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
        if (admin!=null) {
            if (recReportingManager != null) {
                List<Employee> employees = recReportingManager.getEmployeeList();
                for (Employee employee : employees) {
                    employee.setReportingManager(null);
                }
                recReportingManager.setEmployeeList(employees);
                ReportingManager reportingManager = reportingManagerDao.updateReportingManagerById(recReportingManager);
                ReportingManager deletedReportingManager = reportingManagerDao.deleteReportingManager(reportingManager);
                ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                responseStructure.setStatusCode(HttpStatus.OK.value());
                responseStructure.setMessage("Deleted Successfully");
                responseStructure.setData(deletedReportingManager);
                return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure, HttpStatus.OK);
            } else {
                throw new ReportingManagerNotFound("Reporting Manager Not Found of Specified Id");
            }
        }else
            throw new IdNotFoundException("Admin Not Found");
    }

    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> saveReportingManager(String adminEmail,String adminPassword,ReportingManager reportingManager) {
        ReportingManager savedReportingManager = reportingManagerDao.saveReportingManager(reportingManager);
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
        if (admin!=null) {
            if (savedReportingManager != null) {
                ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                responseStructure.setStatusCode(HttpStatus.CREATED.value());
                responseStructure.setMessage("Added Successfully");
                responseStructure.setData(savedReportingManager);
                return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure, HttpStatus.CREATED);
            } else {
                throw new ReportingManagerNotSaved("Reporting Manager Details Not Saved");
            }
        }else{
            throw new IdNotFoundException("Admin Not Found");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerPasswordById(int reportingManagerId, String adminEmail, String adminPassword, ReportingManager reportingManager) {
        ReportingManager recReportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
        if (admin!=null) {
            if (recReportingManager != null) {
                recReportingManager.setPassword(reportingManager.getPassword());
                ReportingManager updatedReportingManager = reportingManagerDao.updateReportingManagerById(recReportingManager);
                ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                responseStructure.setStatusCode(HttpStatus.OK.value());
                responseStructure.setMessage("Updated Successfully");
                responseStructure.setData(updatedReportingManager);
                return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure, HttpStatus.OK);
            } else {
                throw new ReportingManagerNotFound("Reporting Manager Not Found of Specified Id");
            }
        }else
            throw new IdNotFoundException("Admin with specified id");
    }


	@Override
	public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerById(int reportingManagerId,
			ReportingManager reportingManager) {
		// TODO Auto-generated method stub
		return null;
	}
}
