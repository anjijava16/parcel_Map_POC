package com.iwinner.belk.ajax.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class DbUtils {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = DbUtils.class.getClassLoader()
						.getResourceAsStream("db.properties");
				prop.load(inputStream);
				String driver = prop.getProperty("jdbc.driverClassName");
				String url = prop.getProperty("jdbc.databaseurl");
				String user = prop.getProperty("jdbc.username");
				String password = prop.getProperty("jdbc.password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
	 public static String getCommaSeparatedStringFromList(Collection<Integer> intCollection)
	  {
	    StringBuilder builder = new StringBuilder();
	    for (Iterator localIterator = intCollection.iterator(); localIterator.hasNext(); )
	    {
	    	Integer intVal = (Integer)localIterator.next();
	      if (builder.length() == 0) {
	        builder.append(intVal);
	      }
	      builder.append("," + intVal);
	    }
	    return builder.toString();
	  }
	  public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();
		set.add(45);
		set.add(32);
		set.add(12);
		set.add(35);
		set.add(22);
		set.add(62);
		set.add(5);
		set.add(18);
		set.add(13);
		String str=getCommaSeparatedStringFromList(set);
		System.out.println(str);
	}
}