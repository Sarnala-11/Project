package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
	@Column(name="gender")
	String gender;
	@Column(name="age")
	int age;
	@Column(name="specialization")
	String specialization;
	@Column(name="mobilenumber")
	long mobilenumber;
	@Column(name="aadharnumber")
	long aadharnumber;
	@Column(name="location")
	String location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", gender="
				+ gender + ", age=" + age + ", specialization=" + specialization + ", mobilenumber=" + mobilenumber
				+ ", aadharnumber=" + aadharnumber + ", location=" + location + "]";
	}
	public Doctor(int id, String name, String username, String password, String gender, int age, String specialization,
			long mobilenumber, long aadharnumber, String location, String string) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.specialization = specialization;
		this.mobilenumber = mobilenumber;
		this.aadharnumber = aadharnumber;
		this.location = location;
	}
	public Doctor() 
	{
		super();
	}
	
}