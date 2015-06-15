package main.java.com.fpmi.project.database;

import java.util.List;
import   main.java.com.fpmi.project.entity.Record;

public interface IMemoryRecordRepository {
	
	public abstract void write(Record record);

	public abstract List<Record> read();

}
