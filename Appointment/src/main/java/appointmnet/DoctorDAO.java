package appointmnet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("appointmnet")
public class DoctorDAO {

	@Autowired
	Environment e;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setDriverClassName("org.postgresql.Driver");
		dm.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dm.setUsername("postgres");
		dm.setPassword("pavan123");
		
		return dm;
		
	}

}
