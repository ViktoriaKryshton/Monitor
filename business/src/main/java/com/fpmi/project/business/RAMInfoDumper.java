package main.java.com.fpmi.project.business;

import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.management.OperatingSystemMXBean;

import main.java.com.fpmi.project.database.RAMDataRecord;
import main.java.com.fpmi.project.entity.Record;
import main.java.com.fpmi.project.database.IMemoryRecordRepository;


public class RAMInfoDumper extends MemoryInfoDumper {

	private List<Record> data;

	public RAMInfoDumper() {
		data = new ArrayList<Record>();
	}

	@Override
	public void write(long size) {
		OperatingSystemMXBean osBean = ManagementFactory
				.getPlatformMXBean(OperatingSystemMXBean.class);

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");

		IMemoryRecordRepository dataRecord = (RAMDataRecord) context
				.getBean("RAMDataRecord");
		
		Record record = new Record();
		record.setAvailable(size);
		Calendar today = new GregorianCalendar();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = today.getTime();
		record.setDate(date);
		
		dataRecord.write(record);
	}
}
