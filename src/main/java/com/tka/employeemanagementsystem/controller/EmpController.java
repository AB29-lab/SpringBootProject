package com.tka.employeemanagementsystem.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.employeemanagementsystem.entity.Country;
import com.tka.employeemanagementsystem.entity.Employee;
import com.tka.employeemanagementsystem.service.Empservice;

@CrossOrigin
@RestController
@RequestMapping("empapi")
public class EmpController {
    
	@Autowired
	Empservice service;
	
	@PostMapping("getcnt")
	public String getCountry(@RequestBody Country c) {
		 String msg=service.getCountry(c); 
		 return msg;
	}
	
	@PutMapping("updatecnt/{id}")
	public String updateCountry(@PathVariable int id, @RequestBody Country c) {
		String msg=service.updateCountry(id,c);
		return msg;
	}
	
	@DeleteMapping("deletecnt/{cid}")
	public String deleteCountry(@PathVariable int cid) {
		String msg=service.deleteCountry(cid);
		return msg;
	}
	
	@GetMapping("getall")
	public List<Country> getAllCountry() {
		List<Country> list=service.getAllCountry();
		return list;
	}
	
	@GetMapping("getParticularID/{cid}")
	public Country getParticularByID(@PathVariable int cid) {
		Country country=service.getParticularByID(cid);
		return country;
	}
	
	@PostMapping("addEmp")
	public String addEmployee(@RequestBody Employee emp) {
		String msg=service.addEmployee(emp);
		return msg;
	}
	@PutMapping("updateEmp/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		String msg=service.updateEmployee(id,emp);
		return msg;
	}
	@DeleteMapping("deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg=service.deleteEmployee(id);
		return msg;
	}
	
	@GetMapping("allRecord")
	public List<Employee> getAllRecord() {
		List<Employee> list= service.getAllRecord();
		return list;
	}
	
	@GetMapping("getParticular/{id}")
	public Employee getParticularEmpByID(@PathVariable int id) {
		Employee emp=service.getParticularEmpByID(id);
		return emp;
	}
	
    @PostMapping("login")
    public HashMap loginCheck(@RequestBody Employee emp) {
       HashMap map=	service.loginCheck(emp);
       return map;
    }
    
    @GetMapping("getsalary/{ssalary}/{esalary}")
    public List<Employee> getEmpSalary(@PathVariable double ssalary, @PathVariable double esalary) {
       List<Employee> list=service.getEmpSalary(ssalary, esalary);
       return list;
    }
    
    @GetMapping("getStatus/{status}")
    public List<Employee> getStatus(@PathVariable String status) {
      List<Employee> list=	service.getStatus(status);
      return list;
    }
    
    @GetMapping("updatestatus/{id}")
    public String updateStatus(@PathVariable int id) {
    	 String msg=service.updateStatus(id);
    	 return msg;
    }
}
