package com.rudniev.synergywaytest.entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "aircompanies")
public class AirCompany {
	@Id
	private int id;
	private String name;
	private String company_type;
	private Date founded_at;
	
	
	public AirCompany() {
	}
	public AirCompany(int id, String name, String company_type, Date founded_at) {
		super();
		this.id = id;
		this.name = name;
		this.company_type = company_type;
		this.founded_at = founded_at;
	}
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
	public String getCompany_type() {
		return company_type;
	}
	public void setCompany_type(String company_type) {
		this.company_type = company_type;
	}
	public Date getFounded_at() {
		return founded_at;
	}
	public void setFounded_at(Date founded_at) {
		this.founded_at = founded_at;
	}
	
	
	
	
}
