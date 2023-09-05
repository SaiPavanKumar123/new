package appointmnet;

import java.util.List;

public interface DoctorInterface {
	public List<Doctors> getalldoctors();

	public List<SlotCalendar> getAllSlots(int iD);


	public List<SlotCalendar> fetchSlotTimings(String selectedDate);

	

}
