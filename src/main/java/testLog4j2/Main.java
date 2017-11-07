package testLog4j2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Main {
	private final static Logger myLog1 = LogManager.getLogger(Main.class);
	private final static Logger demsLogger = LogManager.getLogger("demsLog");
	private final static String path = getDateDir();
	
	public static void main(String[] args) {
		ThreadContext.put("threadName", "Main");
		ThreadContext.put("demsDirectory", path);
		//myLog1.info(ThreadContext.get("demsDirectory"));
		int cont = 0;
		while(cont <= 100000){
		demsLogger.info("Dems " + cont);
		cont++;
		}
	}
	
	private static String getDateDir(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		
		return dateFormat.format(date).toString();
	}

}
