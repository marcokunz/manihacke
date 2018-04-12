package manihacke;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAO.emptyAccountTable();
		DAO.emptyCustomerTable();
		BankVCT.launch();
		ClientWebService.launch();
		
	}

}
