package appointmnet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DoctorLogic implements Logiclayer {

	DoctorInterface doct;
	Doctors doctor;
	@Autowired
	public DoctorLogic(DoctorInterface doct) {
		this.doct=doct;
		
	}
	
	List<Doctors> d=new ArrayList<Doctors>();
	@Override
	public Doctors getdoctor(int doctorid) {
		d=doct.getalldoctors();
		//Doctors doctor=new Doctors();
		for(Doctors myd:d) {
			if(myd.getDoctorId()==doctorid) {
				doctor=myd;
			}
			
		}
		return doctor;
		
	
	}

	
	

}
