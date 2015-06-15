package main.java.com.fpmi.project.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import main.java.com.fpmi.project.entity.Record;

public class RAMDataRecord implements IMemoryRecordRepository {

	   private Connection connection;
	   private final static String READ_CPU_INFO = "SELECT * FROM `cpu` ORDER BY `cpu`.`date` DESC LIMIT 0 , 20"
	   private final static String SUBMIT_RAM_INFO = "INSERT INTO 'cpu' (available, date) value (?,?)";

	    public RAMDataRecord(Connection connection) {
	        this.connection = connection;
	    }

	    public void close(Statement st) {
	        try {
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException ex) {
	        }
	    }
	
	@Override
	public void write(Record record) {
		public void write(Record record) {
			 PreparedStatement statement = null;
			 try {
				 statement = connection.prepareStatement(SUBMIT_CPU_INFO);
				 statement.setLong(1, size);
				 Calendar today = new GregorianCalendar();
				 DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
				 java.util.Date date = today.getTime();
				 String reportDate = df.format(date);
				 statement.setDate(2, Date.valueOf(reportDate));
				 statement.executeUpdate();
			 } catch (SQLException ex) {
			 }
		}
	}

	public List<Record> read() {
		 PreparedStatement statement = null;
	        try {
	            statement = connection.prepareStatement(SUBMIT_RAM_INFO);
	            ResultSet resultSet = statement.executeQuery();
	            List<Record> records = new ArrayList<Record>();
	            Record record;
	            while (resultSet.next()) {
	                record = new Record();
	                record.setId(resultSet.getInt(id));
	                record.setDate(resultSet.getDate("date"));
	                record.setAvailable(resultSet.getLong("available"));
	                records.record(book);
	            }
	            return records;
	        } catch (SQLException ex) {
	            throw new DAOTechnicalException(ex);
	        } finally {
	            close(statement);
	        }
	}

}
