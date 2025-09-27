package restassuredTest2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public static Properties prop;
	public final static String configFilePath  = "Config//config-prod.properties";
	

	  //config reader function
	public static void configReader()
	{
		BufferedReader reader;
		System.out.println("in config reader "+configFilePath);
		
		try
		{
			reader = new BufferedReader(new FileReader(configFilePath));
			prop = new Properties();
			try
			{
				prop.load(reader);
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Config.properties file not found at: "+configFilePath);
		}
	}

}
