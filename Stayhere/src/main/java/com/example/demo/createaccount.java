package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class createaccount {
@Id	
	@GeneratedValue
	private int uid;
	private String uname;
	private String uemail;
	private String uphno;
	private String upass;
	private String urepass;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUphno() {
		return uphno;
	}
	public void setUphno(String uphno) {
		this.uphno = uphno;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUrepass() {
		return urepass;
	}
	public void setUrepass(String urepass) {
		this.urepass = urepass;
	}
	@Override
	public String toString() {
		return "createaccount [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", uphno=" + uphno + ", upass="
				+ upass + ", urepass=" + urepass + "]";
	}



}