package com.leotest.logtest.test1;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * 如果要想classpath:log4j.properties不生效，需要在vm options中增加以下配置
 * -Dlog4j.configuration=file:/full_path/log4j.properties
 * 
 * https://www.cnblogs.com/Ming8006/p/6170428.html
 */
public class TestLog4j_4 {
	private static final Logger logger = Logger.getLogger(TestLog4j_4.class);
	
	public static void main(String[] args) {
		LogConfiguration.initLog("D:\\log\\result.log");
        logger.info("log info");
        logger.warn("log warn");
        logger.error("log error");
        
        try {
        	Thread.sleep(2000);
        }
        catch(Exception ex){
        	
        }
        
        logger.info("log1 info");
        logger.warn("log1 warn");
        logger.error("log1 error");
	}
}

class LogConfiguration {
    public static void initLog(String logFilePath){
        //声明日志文件存储路径以及文件名、格式
        Properties prop = new Properties();
        //配置日志输出的格式
        prop.setProperty("log4j.rootLogger","info, toConsole, toFile");
        prop.setProperty("log4j.appender.file.encoding","UTF-8" );
        
        prop.setProperty("log4j.appender.toConsole","org.apache.log4j.ConsoleAppender");
        prop.setProperty("log4j.appender.toConsole.Target","System.out");
        prop.setProperty("log4j.appender.toConsole.layout","org.apache.log4j.PatternLayout ");
        prop.setProperty("log4j.appender.toConsole.layout.ConversionPattern","[%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");    
        
        prop.setProperty("log4j.appender.toFile.file", logFilePath);        //每天产生一个日志文件
        prop.setProperty("log4j.appender.toFile", "org.apache.log4j.DailyRollingFileAppender");        
        //服务器启动日志是追加，false：服务器启动后会生成日志文件把老的覆盖掉
        prop.setProperty("log4j.appender.toFile.Append","true");
        prop.setProperty("log4j.appender.toFile.Threshold", "info");
        prop.setProperty("log4j.appender.toFile.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.toFile.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");          
        //[2017-03-31 14:10:44] [ERROR] HttpResponseAnalyze:31 - Not equal
        //prop.setProperty("log4j.appender.toFile.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}] [%p] %c{1}:%L - %m%n");
        //设置每天生成一个文件名后添加的名称,备份名称：年月日.log         
        prop.setProperty("log4j.appender.toFile.DatePattern","'.'yyyy-MM-dd'.log'");
        //使配置生效  
        PropertyConfigurator.configure(prop); 
    }
}