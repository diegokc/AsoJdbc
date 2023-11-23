package py.com.ucsa.utilites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.ZoneId;

public class DateUtil {

	public static String getDateAsString(Date fecha) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
	}

	public static Date getDateAsDate(String fecha) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static LocalDate getLocalDate(String fecha) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(fecha, formatter);

	}

	public static LocalDateTime getLocalDateTime(String fecha) {
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy
		// hh:mm:ss a", Locale.US);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(fecha, formatter);

	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static java.sql.Date getDateAsDateSql(LocalDate localDate) {
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return java.sql.Date.valueOf(localDate);
	}

	public static java.sql.Date getDateAsDateSql(LocalDateTime localDateTime) {
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return java.sql.Date.valueOf(localDateTime.toLocalDate());
	}
	
	public static java.sql.Date getDateAsDateSql(String fecha) {

		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return java.sql.Date.valueOf(fecha);

	}

	public static java.sql.Timestamp getTimeAsTimeSql(LocalDateTime localDateTime) {
		return java.sql.Timestamp.valueOf(localDateTime);
	
	}
	
}
