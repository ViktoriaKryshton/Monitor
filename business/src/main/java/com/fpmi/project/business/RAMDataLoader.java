package main.java.com.fpmi.project.business;

import java.util.List;

import   main.java.com.fpmi.project.entity.Record;

import main.java.com.fpmi.project.database.RAMDataRecord;
import main.java.com.fpmi.project.database.IMemoryRecordRepository;
import main.java.com.fpmi.project.database.IDataLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RAMDataLoader implements IDataLoader{
		
		public List<Record> read()
		{

			ApplicationContext context = new ClassPathXmlApplicationContext(
					"spring-config.xml");
			
			IMemoryRecordRepository dataRecord = (RAMDataRecord) context
					.getBean("RAMDataRecord");
			return dataRecord.read();
		}
}
