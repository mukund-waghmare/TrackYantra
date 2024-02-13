package com.ty.TrackYantra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Location;

import jakarta.annotation.PostConstruct;

@SpringBootApplication

public class TrackYantraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackYantraApplication.class, args);
	}
 
	@Autowired
	AdminDao adminDaoObject;
	
	@PostConstruct
	private void init() {
		

		Admin admin= new Admin();
		Admin adminCheck=adminDaoObject.getAdminByDesignation(Designation.ADMIN);
		
		if(adminCheck==null)
		{
			admin.setAdminId(1);
		
		
			admin.setAdminFirstName("James");
			admin.setAdminLastName("Bond");
			admin.setAdminEmail("James@gmail.com");
			admin.setAdminPassword("james@123");
			admin.setAdminContact(98521456);
			admin.setAdminAge(30);
			admin.setDesignation(Designation.ADMIN);
			
			Admin admin1=adminDaoObject.saveAdmin(admin);
			
			if(admin1!=null)
			{
				System.out.println("Admin Created Successfully");
			}
			else
			{
				System.out.println("Admin Email Already Exist");
			}
			
		}
		else
		{
			System.out.println("Admin Already Exists");
		}
		
	}
	
}
