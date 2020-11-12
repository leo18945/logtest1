package com.leotest.logtest.test1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class TestLog4j_2 extends AppenderSkeleton {
	
	private static Logger log = Logger.getLogger(TestLog4j_2.class);
	
	private OutputStream target;
    private OutputStream out;
	
    public static void main(String[] a) throws InterruptedException {
        
    }
    
    @Override
    public void activateOptions() {
        //log4j单独配置,将当前类中错误信息输出到文件中
        log.removeAllAppenders();//移除所有的appender
        log.setLevel(Level.WARN);//设置日志级别
        log.setAdditivity(false);//移除继承关系
        // 生成新的Appender
        DailyRollingFileAppender appender = new DailyRollingFileAppender();
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss,SSS} %5p %c{1}:%L ---- %m%n";
        layout.setConversionPattern(conversionPattern);
        appender.setLayout(layout);
        
        // log输出路径
        appender.setFile("d://temp//kafka.error");
        appender.setDatePattern("'.'yyyy-MM-dd'.log'");
        appender.setEncoding("UTF-8");
        // 适用当前配置
        appender.activateOptions();
        // 将新的Appender加到Logger中
        log.addAppender(appender);
    }
    
    public void setTarget(String target) {
        if (target.equals("System.out")){
            this.target = System.out;
        }else if(target.equals("System.err")){
            this.target = System.err;
        }
    }
    
    public void setFile(String path) {
        System.out.println(path);
       /* File f = new File(path);
        if(f.exists()){
            if (f.isDirectory()){
                path=path+"/definelog.log";
            }else {
                int i = path.lastIndexOf("/");
                String dir = path.substring(i);
                File df = new File(dir);
                df.mkdirs();
            }
        }*/
        try {
            out = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        closed = true;
        //这里我们不能关闭流，因为这样只会输出一条日志
//        try {
//            target.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

	@Override
	public boolean requiresLayout() {
		return true;
	}

	@Override
    protected void append(LoggingEvent loggingEvent) {
        String log = getLayout().format(loggingEvent);
        try {
            byte[] bytes = log.getBytes();
            target.write(bytes);
            out.write(bytes);
            target.flush();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
