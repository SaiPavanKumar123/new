package appointmnet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SlotMapper implements RowMapper<SlotCalendar> {

	@Override
	public SlotCalendar mapRow(ResultSet rs, int rowNum) throws SQLException {
		SlotCalendar sc = new SlotCalendar();
		sc.setSlotId(rs.getInt(1));
		sc.setSlotDoctorid(rs.getInt(2));
		sc.setSlotdate(rs.getDate(3));
		sc.setSlotfrom(rs.getTime(4));
		sc.setSlotto(rs.getTime(5));
		sc.setSlotstatus(rs.getString(6));

		return sc;
	}

}