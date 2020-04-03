
package com.blogging.modal;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.blogging.utitlity.UtilityClass;

@Entity

public class RegisterUser {
	
	
	@Id
	private int id;

	@NotBlank(message="plz First Name !")
	private String firstName;
	@NotBlank(message="plz Email !")
	private String email;
	
	private String password;
	@NotBlank(message="plz marritial status !")
	private String marritialStatus;
	@NotBlank(message="plz gender !")
	private String gender;
	@NotBlank(message="plz role !")
	private String role;
	private boolean enabled;
	private String salt;
	
	
	
	

	public RegisterUser() {
		this.enabled=true;
		this.id=new Random().nextInt(52);
	}
	

	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getMarritialStatus() {
		return marritialStatus;
	}
	public void setMarritialStatus(String marritialStatus) {
		this.marritialStatus = marritialStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
