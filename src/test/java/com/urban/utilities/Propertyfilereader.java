package com.urban.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyfilereader
{
	public static Properties prop;
	public static FileInputStream file;
	//File src =new File("C:\\Users\\Personal\\eclipse-workspace\\inetBanking1\\configuration\\config.properties");
	public static Properties propfile()
	{
		try
		{
	     file=new  FileInputStream(".\\Configuration\\config.properties");
		prop=new Properties();
		prop.load(file);
		}
		catch(Exception e)
		{
		  System.out.println("Property file is not loaded");	
		}
		return prop;
	}
	public static String loadurl()
	{
		 propfile();
		String url=prop.getProperty("url");
		return url;
	}
	public static String browsername()
	{
		 propfile();
		String browser=prop.getProperty("browser");
		return browser;
	}
	public static String getUsername()
	{
		 propfile();
	String username=prop.getProperty("username");
	return username;
	}
	public static String getPassword()
	{
		 propfile();
	String password=prop.getProperty("password");
	return password;
	}
	
	public static String getChromePath()
	{
		 propfile();
	String chromepath=prop.getProperty("chromepath");
	return chromepath;
	}
	
	public static String getEdge()
	{
		 propfile();
	String iepath=prop.getProperty("edge");
	return iepath;
	}
	
	public static String getFirefoxPath()
	{
		 propfile();
	String firefoxpath=prop.getProperty("firebox");
	return firefoxpath;
	}
	public static String getSheetName()
	{
		 propfile();
	String nameofSheet=prop.getProperty("sheetName");
	return  nameofSheet;
	}
	public static String getXllocation()
	{
		 propfile();
	String pathofSheet=prop.getProperty("SheetPath");
	return pathofSheet;
	}	
	public static String getScreenshot()
	{
		 propfile();
	String screen=prop.getProperty("screenshot");
	return screen;
	}	
}
