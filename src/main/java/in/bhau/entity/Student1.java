package in.bhau.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private String smail;
	
	public Student1() {}
		
	public Student1(String sname, String smail) {
		super();
		this.sname = sname;
		this.smail = smail;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

	public Integer getSid() {
		return sid;
	}

	@Override
	public String toString() {
		return "Student1 [sid=" + sid + ", sname=" + sname + ", smail=" + smail +"]";
	}
	

}
