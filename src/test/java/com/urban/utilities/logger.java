package com.urban.utilities;

import org.apache.logging.log4j.Logger;

public class logger 
{
  
	public  static void loginfo(Logger log, String value)
	{
	     log.info(value);
	}
	public static void logerror(Logger log, String value)
	{
	     log.error(value);
	}
	public static void logfatal(Logger log, String value)
	{
	     log.fatal(value);
	}
	public static void logwarn(Logger log, String value)
	{
	     log.warn(value);
	}		
	}