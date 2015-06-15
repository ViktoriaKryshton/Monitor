package main.java.com.fpmi.project.business;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.management.OperatingSystemMXBean;

import main.java.com.fpmi.project.entity.Record;
import main.java.com.fpmi.project.database.RAMDataRecord;
import main.java.com.fpmi.project.database.IMemoryRecordRepository;

public class CPUInfoDumper<data> extends MemoryInfoDumper {

	@Override
	public void write(long size) {
		OperatingSystemMXBean osBean = ManagementFactory
				.getPlatformMXBean(OperatingSystemMXBean.class);

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");

		IMemoryRecordRepository dataHandler = (RAMDataRecord) context
				.getBean("RAMDataRecord");
		
		Record record = new Record();
		record.setAvailable(size);
		Calendar today = new GregorianCalendar();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		java.util.Date date = today.getTime();
		record.setDate(date);
		dataHandler.write(record);
		
	}

}
