package webService;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import util.HenryUtil;
import DAO.EmployeeDao;
import model.Employee;

@WebService(endpointInterface = "webService.HenryService")
public class HenryServiceImpl implements HenryService{
	
	private static Logger logger = Logger.getLogger(HenryServiceImpl.class);

	@Override
	public Employee HenryToService(String id) {
		//String res = "HenryWebService feedback: ";
		Employee employee = null;
		if (id == null) {
			employee = new Employee();
		} else {
			try {
				employee = process(id);
				logger.info("Call process() successfully");
			} catch (Exception e) {
				employee = new Employee();
				logger.error("process() function failed", e);
			}
		}
		return employee;
	}
	
	@Override
	public Employee[] getAllEmployee() {
		SqlSession session = null;
		try {
			session = HenryUtil.getSqlSession();
			logger.info("Call getSqlSession() successfully");
		} catch (IOException e) {
			logger.error("getSqlSession() function failed", e);
		}
		
        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        
        List<Employee> employeeList = employeeDao.getAllEmployee();
        Employee[] employees = employeeList.toArray(new Employee[]{});
        
        session.commit();
        session.close();
        
        return employees;
	}
	
	@Override
	public int updateEmployee(Employee emp) {
		SqlSession session = null;
		try {
			session = HenryUtil.getSqlSession();
			logger.info("Call getSqlSession() successfully");
		} catch (IOException e) {
			logger.error("getSqlSession() function failed", e);
		}
		 EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
		 int res = employeeDao.updateEmployee(emp);
		 
		 session.commit();
		 session.close();
		 
		 return res;
	}
	
	@Override
	public int insertEmployee(Employee emp) {
		SqlSession session = null;
		try {
			session = HenryUtil.getSqlSession();
			logger.info("Call getSqlSession() successfully");
		} catch (IOException e) {
			logger.error("getSqlSession() function failed", e);
		}
		 EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
		 int res = employeeDao.insertEmployee(emp);
		 
		 session.commit();
		 session.close();
		 
		 return res;
	}
	
	@Override
	public int deleteEmployee(int id) {
		SqlSession session = null;
		try {
			session = HenryUtil.getSqlSession();
			logger.info("Call getSqlSession() successfully");
		} catch (IOException e) {
			logger.error("getSqlSession() function failed", e);
		}
		 EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
		 int res = employeeDao.deleteEmployee(id);
		 
		 session.commit();
		 session.close();
		 
		 return res;
	}
	
/*	public String processJDBC(String queryColumn) {
		Connection conn = null;
		String res = "";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/henry_db","root","");
			
			if (!conn.isClosed()) {
				System.out.println("isConnected");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM test_tb where id = " + queryColumn);
				while (rs.next()) {
					res = res + rs.getString("name") + "\n";
					System.out.println(rs.getString("name"));
				}
				conn.close();
			} else {
				System.out.println("Disconnected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}*/
	
	public Employee process(String id) throws IOException {
		SqlSession session = HenryUtil.getSqlSession();
        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        
        Employee employee = employeeDao.findByEmployeeID(id);
        
        session.commit();
        session.close();
        
        return employee;
	}




}
