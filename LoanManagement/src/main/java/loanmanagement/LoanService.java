package loanmanagement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

	LoanDAOContractor loanDAO;

	@Autowired
	LoanService(LoanDAOContractor loan) {

		this.loanDAO = loan;
	}

	@Transactional
	public void addCustomer(LoanCustomer lc) {
		loanDAO.addCustomer(lc);
	}

	@Transactional
	public void addApplication(LoanApplication loan) {
		loanDAO.addApplication(loan);
	}

	@Transactional
	public void addNominee(Nominee nomine) {
		loanDAO.addNominee(nomine);
	}

	@Transactional
	public boolean verifyCredentials(String user, String password) {

		List<User> ls = loanDAO.getAllCredentials();
		System.out.println(ls.get(3).getPassword());
		boolean check = false;
		for (User c : ls) {
			if (c.getUsername().equals(user) && password.equals(c.getPassword())) {
				check = true;
				break;
			}
		}

		return check;
	}

	@Transactional
	public String verifyuser(String user, String password) {

		List<User> ls = loanDAO.getAllCredentials();
		String type = "";
		int id;
		for (User c : ls) {
			if (c.getUsername().equals(user) && password.equals(c.getPassword())) {
				id = c.getUserid();
				if ("admin".equals(c.getUsertype())) {
					type = "admin";
				} else {
					type = "user";
				}
				break;
			}
		}

		return type;
	}

	//getting all applications
	public List<Application> getAllApplication() {

		List<Loan> list=loanDAO.findAll();
		List<Application> applist=new ArrayList<>();
		List<LoanCustomer> custList=loanDAO.getAllCustomers();
		for(Loan ln:list) {
			Application app= new Application();
			app.setAppid(ln.getApplicantid());
			app.setCustid(ln.getCustomerid());
			app.setAppdate(ln.getApplicationdate());
			app.setAmountreq(ln.getAmountreq());
			String type="";
			if(ln.getLoantype()==1) {
				type="personal";
			}else if(ln.getLoantype()==2) {
				type="home";
			}
			else {
				type="vehical";
			}
			app.setType(type);
			app.setMontsreq(ln.getMonthsreq());
			app.setStatus(ln.getStatus());
			for(LoanCustomer lc:custList) {
				if(lc.getCust_id()==ln.getCustomerid()) {
					app.setName(lc.getCust_firstname()+lc.getCust_lastname());
					app.setMobile(lc.getCust_mobile());
					break;
				}
			}
			applist.add(app);
		}
		
		return applist; 
	
	}
	
	public List<Loan> getAllApplications() {

		return loanDAO.findAll();
	}
	

	
	@Transactional
	public void addLoan(Loan ln) {
		loanDAO.addLoan(ln);
	}

	
	//getting all customers
	public int getAllCustomers() {

		List<LoanCustomer> ls = loanDAO.getAllCustomers();

		return ls.size();
	}

	//getting all applications by application id
	public Loan getLoanApplicant(int appid) {

		List<Loan> ls = loanDAO.findAll();
		Loan loan = new Loan();

		for (Loan ln : ls) {

			if (ln.getApplicantid() == appid) {
				loan = ln;
				break;
			}
		}
		return loan;
	}

	
	//updating the status as by the admin
	@Transactional
	public void updateApplication(String status, int id) {

		loanDAO.updateApplication(status, id);

	}
	
	
	//searching by name
	public List<Application> searchName(String name){
		List<Application> appList=new ArrayList<>();
		List<LoanCustomer> custList=loanDAO.getAllCustomers();
		List<Loan> loanList=loanDAO.findAll();
		for(LoanCustomer cust:custList) {
			if(cust.getCust_firstname().equals(name)) {
				
				for(Loan ln:loanList) {
					if(ln.getCustomerid()==cust.getCust_id()) {
						Application app=new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						app.setName(cust.getCust_firstname()+cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String type="";
						if(ln.getLoantype()==1) {
							type="personal";
						}else if(ln.getLoantype()==2) {
							type="home";
						}
						else {
							type="vehical";
						}
						app.setType(type);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}
		
		return appList;
	}
	
	
	public List<Application> searchMobile(String mobile){
		List<Application> appList=new ArrayList<>();
		List<LoanCustomer> custList=loanDAO.getAllCustomers();
		List<Loan> loanList=loanDAO.findAll();
		for(LoanCustomer cust:custList) {
			if(cust.getCust_mobile().equals(mobile)) {
				
				for(Loan ln:loanList) {
					if(ln.getCustomerid()==cust.getCust_id()) {
						Application app=new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						app.setName(cust.getCust_firstname()+cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String type="";
						if(ln.getLoantype()==1) {
							type="personal";
						}else if(ln.getLoantype()==2) {
							type="home";
						}
						else {
							type="vehical";
						}
						app.setType(type);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}
		
		return appList;
	}
	
	
	//searching loans by type of loan
	public List<Application> searchLoanType(String type){
		int loanType=1;
		if("personal".equalsIgnoreCase(type)) {
			loanType=1;
		}else if("home".equalsIgnoreCase(type)) {
			loanType=2;
		}
		else {
			loanType=3;
		}
		List<Application> appList=new ArrayList<>();
		List<LoanCustomer> custList=loanDAO.getAllCustomers();
		List<Loan> loanList=loanDAO.findAll();
		
				
				for(Loan ln:loanList) {
					if(ln.getLoantype()==loanType) {
						for(LoanCustomer cust:custList) {
							if(cust.getCust_id()==ln.getCustomerid()) {
						Application app=new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						app.setName(cust.getCust_firstname()+cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String lntype="";
						if(ln.getLoantype()==1) {
							lntype="personal";
						}else if(ln.getLoantype()==2) {
							lntype="home";
						}
						else {
							lntype="vehical";
						}
						app.setType(lntype);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}
		
		return appList;
	}
	
	
	// searching loans by the date range
	public List<Application> searchDate(Date from,Date to){
		
		List<Application> appList=new ArrayList<>();
		List<LoanCustomer> custList=loanDAO.getAllCustomers();
		List<Loan> loanList=loanDAO.findAll();
		
				
				for(Loan ln:loanList) {
					if(ln.getApplicationdate().compareTo(from)<0&&ln.getApplicationdate().compareTo(from)>0) {
						for(LoanCustomer cust:custList) {
							if(cust.getCust_id()==ln.getCustomerid()) {
						Application app=new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						app.setName(cust.getCust_firstname()+cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String lntype="";
						if(ln.getLoantype()==1) {
							lntype="personal";
						}else if(ln.getLoantype()==2) {
							lntype="home";
						}
						else {
							lntype="vehical";
						}
						app.setType(lntype);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}
		
		return appList;
	}
	
	
	
	public void checkEligibility(Eligibilty el) {
		
	}
	
}
