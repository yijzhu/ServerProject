package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HenryUtil {

	private static String resource = "MyBatis-Configuration.xml"; 
			
	public static SqlSession getSqlSession() throws IOException {
		String resource = "MyBatis-Configuration.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        
        SqlSession session = factory.openSession();
        
        return session;
	}
}
