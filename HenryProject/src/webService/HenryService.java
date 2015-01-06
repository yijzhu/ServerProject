package webService;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import model.Employee;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HenryService {

	 @WebMethod
	 Employee HenryToService(String input);
	 
	 @WebMethod
	 Employee[] getAllEmployee(); 
	 
	 @WebMethod
	 int updateEmployee(Employee emp);
	 
	 @WebMethod
	 int insertEmployee(Employee emp);
	 
	 @WebMethod
	 int deleteEmployee(int id);
}
