import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.dao.EmployeeDAO;
import com.revature.util.RequestProcessor;

public class testClass {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		RequestProcessor rp = RequestProcessor.getInstance();
		
//		EmployeeDAO dao = new EmployeeDAO();
//		System.out.println(dao.getDepartment("2"));
		
		System.out.println(rp.viewSubmittedReimbursementRequests("2"));
	}

}
