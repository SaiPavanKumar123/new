package loanmanagement;

import java.util.List;

public interface LoanDAOContractor {

	void addCustomer(LoanCustomer customer);

	List<Loan> findAll();

	void addApplication(LoanApplication application);

	void addNominee(Nominee nomine);

	List<User> getAllCredentials();

	void addLoan(Loan ln);

	List<LoanCustomer> getAllCustomers();

	void updateApplication(String status, int id);

}
