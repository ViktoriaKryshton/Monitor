package main.java.com.fpmi.project.business;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.sun.management.OperatingSystemMXBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.fpmi.project.entity.Record;
public class RAMMemoryMonitor extends Thread implements IMonitor {

	private volatile boolean stop = false;
	 
	public void finish()
    {
		stop = true;
    }
	
	public void run()
	{
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");			
		IMonitor ramMonitor = (IMonitor) context.getBean("RAMMonitor");
		
		MemoryInfoDumper infoDumper = (MemoryInfoDumper) context.getBean("RAMInfoDumper");
		
		List<Record> records = new ArrayList<Record>();

		while(!stop)
		{
			infoDumper.write(osBean.getFreePhysicalMemorySize());

			Record record = new Record();
			
			record.setAvailable(osBean.getFreePhysicalMemorySize());
			Calendar today = new GregorianCalendar();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			java.util.Date date = today.getTime();
			record.setDate(date);
			records.add(record);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}