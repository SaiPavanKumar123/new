package appointmnet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class Slotbooking implements RowMapper<SlotCalendar> {

	@Override
	public SlotCalendar mapRow(ResultSet rs, int rowNum) throws SQLException {
		SlotCalendar s=new SlotCalendar();
		s.setSlotId(rs.getInt(1));
		s.setSlotDoctorid(rs.getInt(2));
		s.setSlotdate(rs.getDate(3));
		s.setSlotfrom(rs.getTime(4));
		s.setSlotto(rs.getTime(5));
		s.setSlotstatus(rs.getString(6));
		
	
			return s;
	}

}
