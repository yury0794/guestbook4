package com.estsoft.guestbook.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Guestbook {
	
	@Id
	@Column( name = "no" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long no;
	
	@Column( name = "name", nullable = false, length=100 )
	private String name;
	
	@Column( name = "reg_date", nullable = false )
	@Temporal( value = TemporalType.TIMESTAMP )
	private Date regDate;
	
	@Column( name = "passwd", nullable = false, length=64 )
	private String password;
	
	@Column( name = "message", nullable = false )
	@Lob
	private String message;

	
	@Column( name = "gender", nullable = false )
	@Enumerated( )
	private Gender gender;
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Guestbook [no=" + no + ", name=" + name + ", regDate=" + regDate + ", password=" + password
				+ ", message=" + message + "]";
	}
}
