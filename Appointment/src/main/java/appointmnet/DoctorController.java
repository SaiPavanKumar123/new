package appointmnet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


	
public class DoctorController {
	
	
	DoctorInterface doctor;
	DoctorLogic mydoc;
//	DoctorInterface mydoc;
	@Autowired
	public DoctorController(DoctorInterface doctor,DoctorLogic mydoc) {
		
		this.doctor = doctor;
		this.mydoc=mydoc;
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	@RequestMapping(value="/verify",method=RequestMethod.GET)
	public String Verify(Model model) {
		List<Doctors> doc=doctor.getalldoctors();
		model.addAttribute("alldoctors",doc);
				
		return "alldoctors";
	}
	
	@RequestMapping(value="/doctorinfo",method=RequestMethod.GET)
	public String Mydoctor(@RequestParam("doctorid") int id,Model model) {
		
		
		model.addAttribute("doctorinfo", mydoc.getdoctor(id));
		return "doctorinfo";
	}
	@RequestMapping(value = "/slots", method = RequestMethod.GET)
	public String AvailableSlots(@RequestParam("doctorid") int id, Model mod) {
		//int ID = Integer.parseInt(id);

		mod.addAttribute("slots", doctor.getAllSlots(id));
		return "slots";
	}
	
	
	
	 @RequestMapping(value = "/slotbooking", method = RequestMethod.GET)
	    public String showSlotTimings( @RequestParam("selectedDate") String selectedDate, Model model) {

	        List<SlotCalendar> slotTimings = doctor.fetchSlotTimings(selectedDate);

	
	        model.addAttribute("slotTimings", slotTimings);

	        return "bookingslot"; 
	    }
	 
	 @RequestMapping(value = "/Patient", method = RequestMethod.GET)
		public String PatientDetails() {
			//int ID = Integer.parseInt(id);

//			mod.addAttribute("slots", doctor.getAllSlots(id));
			return "Patient";
		}
		

}
