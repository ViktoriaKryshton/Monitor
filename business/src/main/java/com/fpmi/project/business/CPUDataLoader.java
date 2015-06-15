package main.java.com.fpmi.project.business;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.fpmi.project.entity.Record;
import main.java.com.fpmi.project.database.CPUDataRecord;
import main.java.com.fpmi.project.database.IMemoryRecordRepository;

public class CPUDataLoader implements IDataLoader {

	public List<Record> read() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");

		IMemoryRecordRepository dataHandler = (CPUDataRecord) context
				.getBean("CPUDataRecord");
		return dataHandler.read();
	}

}
