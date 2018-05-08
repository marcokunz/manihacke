package manihacke;

import java.sql.SQLException;

import com.ibm.wsdl.util.StringUtils;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAO.emptyAccountTable();
		DAO.emptyCustomerTable();
		BankVCT.launch();
		ClientWebService.launch();
//		DAO.cleanUp();
//		DAO.StatusChecker();

		
	}

}
