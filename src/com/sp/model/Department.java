package com.sp.model;

import java.util.ArrayList;
import java.util.List;


public class Department {
	private String deptID;
	List<Degree> degrees = new ArrayList<Degree>();
	private String deptName;
	private String researchDesc;
	private int managerID;
	
	private String imageUrl;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String deptID, String deptName, String researchDesc, int managerID,String imageUrl) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.researchDesc = researchDesc;
		this.managerID = managerID;
		this.imageUrl=imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getResearchDesc() {
		return researchDesc;
	}

	public void setResearchDesc(String researchDesc) {
		this.researchDesc = researchDesc;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
public List<Degree> getAll(String deptID)
{
	return degrees;
	
}
	

}
