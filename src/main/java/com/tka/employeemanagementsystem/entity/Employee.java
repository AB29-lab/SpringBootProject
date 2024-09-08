package com.tka.employeemanagementsystem.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobileno;
	@Column(unique=true)
	private String emailid;
	private double salary;
	private String department;
	private String status;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	@ManyToOne
	@JoinColumn(name="c_id")
	Country country;

}
