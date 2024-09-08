package com.tka.employeemanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.employeemanagementsystem.dao.EmpDao;
import com.tka.employeemanagementsystem.entity.Country;
import com.tka.employeemanagementsystem.entity.Employee;

@Service
public class Empservice {
     
	 @Autowired
	 EmpDao dao;
	
	public String getCountry(Country c) {
	    String msg=dao.getCountry(c);
	    return msg;
	}

	public String updateCountry(int id, Country c) {
	    String msg=dao.updateCountry(id,c);
	    if(Objects.isNull(msg)) {
	    	System.out.println("Country not to be added...");
	    }
		return msg;
	}

	public String deleteCountry(int cid) {
		String msg=dao.deleteCountry(cid);
		if(Objects.isNull(msg)) {
			System.out.println("Country is not deleted....");
		}
		return msg;
		
	}

	public List<Country> getAllCountry() {
		List<Country> list=dao.getAllCountry();
		      if(Objects.isNull(list)) {
		    	  System.out.println("Data is not fetched...");
		      }
		return list;
	}

	public Country getParticularByID(int cid) {
		Country country=dao.getParticularByID(cid);
		   if(Objects.isNull(country)) {
			   System.out.println("Country id is not fetched...");
		   }
		return country;
		
	}

	public String addEmployee(Employee emp) {
		String msg=dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
		   msg="Employee is not be added...";
		}
		return msg;
	}

	public String updateEmployee(int id, Employee emp) {
		String msg=dao.updateEmployee(id,emp);
		if(Objects.isNull(msg)) {
			msg="Employee is not updated";
		}
		return msg;
	}

	public String deleteEmployee(int id) {
	     String msg=dao.deleteEmployee(id);
		 if(Objects.isNull(msg)) {
			 msg="Employee is not deleted...";
			 
		 }
		 return msg;
	}

	public List<Employee> getAllRecord() {
		List<Employee> list= dao.getAllRecord();
		if(Objects.isNull(list)) {
			System.out.println("Employee is not added....");
		}
		return list;
	}

	public Employee getParticularEmpByID(int id) {
		Employee e=dao.getParticularEmpByID(id);
		if(Objects.isNull(e)) {
			System.out.println("Data is not fetched...");
		}
		return e;
	}

	public HashMap loginCheck(Employee emp) {
		 Employee e=dao.loginCheck(emp);
		 HashMap map=new HashMap();
		 if(Objects.isNull(e)) {
			 map.put("msg", "Invalid user....");
	  }else {
		  map.put("msg","Valid User...");
	  }
	    map.put("user", e);
	   return map;
  }

	public List<Employee> getEmpSalary(double ssalary,double esalary) {
		List<Employee> list=dao.getEmpSalary(ssalary,esalary);
		return list;
	}

	public List<Employee> getStatus(String status) {
	   List<Employee> list=  dao.getStatus(status);
		return list;
	}

	public String updateStatus(int id) {
		String msg=dao.updateStatus(id);
		return msg;
	}


  
}
