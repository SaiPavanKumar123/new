package appointmnet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DoctorMapper implements RowMapper<Doctors> {

	@Override
	public Doctors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctors d=new Doctors();
		d.setDoctorId(rs.getInt(1));
		d.setFullName(rs.getString(2));
		d.setSpecilization(rs.getInt(3));
		d.setQualification(rs.getString(4));
		d.setExperiance(rs.getInt(5));
		d.setDesignation(rs.getString(6));
		d.setPhoto(rs.getString(7));
		
		return d;
	}

}
