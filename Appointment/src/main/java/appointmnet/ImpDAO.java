package appointmnet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ImpDAO implements DoctorInterface{

	
	JdbcTemplate jdbc;
	public ImpDAO(DataSource ds) {
		this.jdbc=new JdbcTemplate(ds);
	}
	@Override
	public List<Doctors> getalldoctors() {
		String query="select * from doctor_table";
		
		
		return jdbc.query(query,new DoctorMapper());
	}
	@Override
	public List<SlotCalendar> getAllSlots(int doctorID) {

		String query = "select * from slotbooking where slotdoctorid=" + doctorID;
		return jdbc.query(query, new SlotMapper());
	}
	@Override
	public List<SlotCalendar> fetchSlotTimings(String selectedDate) {
		String query="SELECT * FROM slotbooking WHERE slotdate = "+selectedDate;
		
		return jdbc.query(query,new Slotbooking());
	}
		

}
