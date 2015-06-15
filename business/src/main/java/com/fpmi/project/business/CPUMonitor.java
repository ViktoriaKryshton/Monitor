package main.java.com.fpmi.project.business;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CPUMonitor extends Thread implements IMonitor {

	private volatile boolean stop = false;
	 
	public void finish()
    {
		stop = true;
    }
	
	public void run()
	{
		while(!stop)
		{
			OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
	                OperatingSystemMXBean.class);
			

			ApplicationContext context = new ClassPathXmlApplicationContext(
					"spring-config.xml");
			
			MemoryInfoDumper infoDumper = (MemoryInfoDumper) context.getBean("CPUInfoDumper");
			infoDumper.write(osBean.getProcessCpuTime());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
