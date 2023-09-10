package loanmanagement;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="emischedule")
@Entity
public class LoanEMISchedule {

	@Id
	int applicantid;
	int emiIndex;
	Date emiDate;
	double emiAmount;
	
	
	public LoanEMISchedule() {
		
	}
	
	
	public int getApplicantid() {
		return applicantid;
	}
	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}
	public int getEmiIndex() {
		return emiIndex;
	}
	public void setEmiIndex(int emiIndex) {
		this.emiIndex = emiIndex;
	}
	public Date getEmiDate() {
		return emiDate;
	}
	public void setEmiDate(Date emiDate) {
		this.emiDate = emiDate;
	}
	public double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}
	
	
	
}
