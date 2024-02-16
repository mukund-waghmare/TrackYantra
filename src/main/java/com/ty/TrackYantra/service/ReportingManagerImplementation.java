
package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.EmployeeDao;
import com.ty.TrackYantra.dao.LocationDao;
import com.ty.TrackYantra.dao.ReportingManagerDao;
import com.ty.TrackYantra.dto.*;
import com.ty.TrackYantra.exception.AdminNotFoundException;
import com.ty.TrackYantra.exception.IdNotFoundException;
import com.ty.TrackYantra.exception.ReportingManagerNotFound;
import com.ty.TrackYantra.exception.ReportingManagerNotSaved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ReportingManagerImplementation implements ReportingManagerService {
    @Autowired
    private ReportingManagerDao reportingManagerDao;
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private LocationDao locationDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerEmailById(int reportingManagerId, String adminEmail,String adminPassword, ReportingManager reportingManager) {
        ReportingManager recReportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail, adminPassword);
        if (admin != null) {
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
        } else
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
                    employeeDao.saveEmployee(employee);
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
    public ResponseEntity<ResponseStructure<ReportingManager>> saveReportingManager(String adminEmail, String adminPassword, ReportingManager reportingManager){
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
        if (admin!=null) {
            Location location = reportingManager.getLocation();
            if (location!=null){
                locationDao.saveLocation(location);
            }
            ReportingManager savedReportingManager = reportingManagerDao.saveReportingManager(reportingManager);
            if (savedReportingManager != null) {
                ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                responseStructure.setStatusCode(HttpStatus.CREATED.value());
                responseStructure.setMessage("Added Successfully");
                responseStructure.setData(savedReportingManager);
                return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure, HttpStatus.CREATED);
            } else {
                throw new ReportingManagerNotSaved("Reporting Manager Details Not Saved");
            }
        }
        else{
            throw new IdNotFoundException("Admin Not Found");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerPasswordById(int reportingManagerId, String adminEmail, String adminPassword, ReportingManager reportingManager) {
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
        ReportingManager recReportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
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
    public ResponseEntity<ResponseStructure<ReportingManager>> getReportingManagerByEmailAndPassword(String reportingManagerEmail, String reportingManagerPassword,String adminEmail,String adminPassword) {
         ReportingManager reportingManager = reportingManagerDao.getReportingManagerByEmailAndPassword(reportingManagerEmail,reportingManagerPassword);
         Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
         if (admin!=null) {
             if (reportingManager != null) {
                 ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                 responseStructure.setStatusCode(HttpStatus.OK.value());
                 responseStructure.setMessage("Success");
                 responseStructure.setData(reportingManager);
                 return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure, HttpStatus.OK);
             } else
                 throw new ReportingManagerNotFound("Reporting Manager of Specified Id Not Found!!");
         }else
             throw new AdminNotFoundException("Admin Data Not Found");
    }


    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerLocationByReportingManagerId(int reportingManagerId, int locationId,String adminEmail,String adminPassword) {
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
        if (admin!=null) {
            ReportingManager reportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
            Location recLocation = locationDao.getLocationByLocationId(locationId);
            if (reportingManager != null && recLocation != null) {
                Location toUpdateLocation = reportingManager.getLocation();
                toUpdateLocation.setLatitude(recLocation.getLatitude());
                toUpdateLocation.setLongitude(recLocation.getLongitude());
                toUpdateLocation.setOrganisationAddress(recLocation.getOrganisationAddress());
                toUpdateLocation.setCity(recLocation.getCity());
                toUpdateLocation.setCountry(recLocation.getCountry());
                reportingManager.setLocation(toUpdateLocation);
                reportingManagerDao.saveReportingManager(reportingManager);
                ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                responseStructure.setMessage("Success");
                responseStructure.setData(reportingManager);
                responseStructure.setStatusCode(HttpStatus.OK.value());
                return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure, HttpStatus.OK);
            } else
                throw new ReportingManagerNotFound("Reporting Manager Not Found");
        }else
            throw new AdminNotFoundException("Admin Not Found!!");

    }

    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> deleteReportingManagerLocationByReportingManagerId(int reportingManagerId, String adminPassword, String adminEmail) {
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
        if (admin!=null){
            ReportingManager reportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
            if (reportingManager!=null){
                reportingManager.setLocation(null);
                reportingManagerDao.saveReportingManager(reportingManager);
                ResponseStructure<ReportingManager> responseStructure = new ResponseStructure<>();
                responseStructure.setStatusCode(HttpStatus.OK.value());
                responseStructure.setData(reportingManager);
                responseStructure.setMessage("Success");
                return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure,HttpStatus.OK);
            }else
                throw new ReportingManagerNotFound("Reporting Manager of Specified Id Not Found");
        }else
            throw new AdminNotFoundException("Admin Not Found");
    }

    @Override
    public ResponseEntity<ResponseStructure<ReportingManager>> uploadProfileImage(int reportingManagerId, MultipartFile file) {
        ReportingManager reportingManager = reportingManagerDao.getReportingManagerById(reportingManagerId);
        if (reportingManager!=null){
            try {
                byte[] imageBytes = file.getBytes();
                reportingManager.setImage(imageBytes);
                reportingManagerDao.saveReportingManager(reportingManager);
                ResponseStructure<ReportingManager> responseStructure =new ResponseStructure<>();
                responseStructure.setData(reportingManager);
                responseStructure.setMessage("Uploaded Successfully");
                responseStructure.setStatusCode(HttpStatus.OK.value());
                return new ResponseEntity<ResponseStructure<ReportingManager>>(responseStructure,HttpStatus.OK);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {
            throw new ReportingManagerNotFound("Reporting Manager Not Found");
        }
    }

    @Override
	public ResponseEntity<ResponseStructure<ReportingManager>> updateReportingManagerById(int reportingManagerId,
			ReportingManager reportingManager) {
		// TODO Auto-generated method stub
		return null;
	}
}
