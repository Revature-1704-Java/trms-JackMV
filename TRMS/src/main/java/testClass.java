import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.util.RequestProcessor;

public class testClass {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		RequestProcessor rp = RequestProcessor.getInstance();
		
		System.out.println(rp.processLoginRequest("2", "2").equals("null"));
	}

}
