package main.java.com.fpmi.project.console;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.fpmi.project.business.IMonitor;
public class Main {

	public static void main(String[] args)
	{		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		
		IMonitor ramMonitor = (IMonitor) context.getBean("RAMMonitor");
		ramMonitor.start();
		
		IMonitor cpuMonitor = (IMonitor) context.getBean("CPUMonitor");
		cpuMonitor.start();
		
	//	System.out.println("Input command");
	//	Scanner input = new Scanner(System.in);
    //    String command = input.next();
    //    if("stop".equals(command));
    //    {
    //    	ramMonitor.finish();
    //    	cpuMonitor.finish();
    //    }	
	}
}
