package appointmnet;

public class Doctors {
	int doctorId;
	String fullName;
	int specilization;
	String qualification;
	int experiance;
	String designation;
	String photo;
	public Doctors(int doctorId, String fullName, int specilization, String qualification, int experiance,
			String designation, String photo) {
	
		this.doctorId = doctorId;
		this.fullName = fullName;
		this.specilization = specilization;
		this.qualification = qualification;
		this.experiance = experiance;
		this.designation = designation;
		this.photo = photo;
	}
	public Doctors() {
		
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getSpecilization() {
		return specilization;
	}
	public void setSpecilization(int specilization) {
		this.specilization = specilization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getExperiance() {
		return experiance;
	}
	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


}
