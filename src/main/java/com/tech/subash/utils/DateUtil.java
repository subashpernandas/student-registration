package com.tech.subash.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class DateUtil {

    public static final String BASIC_ISO_DATE = "yyyyMMdd";
    public static final String ISO_LOCAL_DATE = "yyyy-MM-dd";
    public static final String ISO_LOCAL_TIME = "HH:mm:ss";
    public static final String ISO_LOCAL_DATE_TIME = "yyyy-MM-ddTHH:mm:ss";
    public static final String LOCAL_DATE_MON_TXT = "yyyy-MMM-dd";
    public static final String LOCAL_DATE_DDMONYYY = "dd-MMM-yyyy";
    public static final String LOCAL_DATE = "ddMMyyyy";
    public static final String LOCAL_DATE_FMT = "ddMM";
    public static final String LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String IST_LOCAL_DATE = "dd-MM-yyyy";
    public static final String IST_LOCAL_DATETIME = "dd-MM-yyyy HH:mm:ss";
    public static final String T24_DATE_FMT = "dd/MM/yy";
    public static final String ICICI_DATE_FMT = "dd/MM/yyyy";
    public static final String DUE_SHEET_DATE_FMT = "yyyy-MM-dd";

    public static final String PAY_NOW_DATE_FMT = "dd/MM/yyyy HH:mm:ss";
    public static final String dd_space_MMM_space_yyyy = "dd MMM yyyy";

    private DateUtil() {
    }

    public static long diffInTwoLocalDateTime(LocalDateTime from, LocalDateTime to){
        return ChronoUnit.MINUTES.between(from, to);
    }

    public static LocalDate addAndGet(int days) {
        return LocalDate.now().plusDays(days);
    }

    public static LocalDateTime parseDateTime(String inputDate, String inputFormat) {
        if (StringUtils.isBlank(inputDate)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat);
        return LocalDateTime.parse(inputDate, formatter);
    }

	public static LocalDate parseDate(String inputDate, String inputFormat) {
		if (StringUtils.isBlank(inputDate)) {
			return null;
		}
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat);
			return LocalDate.parse(inputDate, formatter);
		} catch (Exception e) {
			log.error("Error occured while parsing date {} to format {}", inputDate, inputFormat);
		}
		return null;
	}



    public static LocalDateTime parseAsStartOfDay(String inputDate, String inputFormat) {
        return parseDate(inputDate, inputFormat).atStartOfDay();
    }

    public static LocalDateTime parseAsEndOfDay(String inputDate, String inputFormat) {
        return parseDate(inputDate, inputFormat).atTime(23, 59, 59, 99999999);
    }

    public static LocalDateTime getStartOfDay() {
        return LocalDateTime.now().with(LocalTime.MIDNIGHT);
    }

    public static LocalDateTime getEndOfDay() {
        return LocalDateTime.now().with(LocalTime.MAX);
    }

    public static String format(LocalDateTime dateTime, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return dateTime != null ? dateTime.format(formatter) : null;
        } catch (Exception e) {
            log.error("Error occurred while parsing date {} to format {}", dateTime, format, e);
            return "";
        }
    }

    public static String format(LocalDate date, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return date != null ? date.format(formatter) : null;
        } catch (Exception e) {
            log.error("Error occured while parsing date {} to format {}", date, format);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(format(LocalDateTime.now().plusDays(2), LOCAL_DATE_MON_TXT ));
        System.out.println(format(LocalDate.now(), LOCAL_DATE_MON_TXT ));
        System.out.println(formatDate( "dd-MM-yyyy",LOCAL_DATE_MON_TXT,"20-05-1992"));

    }

    public static String formatDate(SimpleDateFormat inputFormat, SimpleDateFormat outputFormat, String inputDate){
        try {
            Date date = inputFormat.parse(inputDate);
            String outputDate = outputFormat.format(date);
            return outputDate;
        } catch (ParseException e) {
            return null;
        }
    }

	public static String formatDate(String inputFormat, String outputFormat, String inputDate) {
		try {
			DateTimeFormatter from = DateTimeFormatter.ofPattern(inputFormat);
            LocalDate ld = LocalDate.parse(inputDate, from);

            DateTimeFormatter to = DateTimeFormatter.ofPattern(outputFormat);
			return ld.format(to);
		} catch (Exception e) {
			log.error("Error occured while parsing date : input format {},output format {},input date {}", inputFormat,
					outputFormat, inputDate);
		}
		return "";
	}
	
	public static String formatLocalDate(String outputFormat) {
		try {
			DateTimeFormatter from = DateTimeFormatter.ofPattern(outputFormat);
			return LocalDateTime.now().format(from);
		} catch (Exception e) {
			log.error("Error occured while parsing date : output format {}",outputFormat);
		}
        return "";
	}
	

	
	public static String format(String inputFormat, String outputFormat, String inputDate) {
		try {
			DateTimeFormatter from = DateTimeFormatter.ofPattern(inputFormat);
			DateTimeFormatter to = DateTimeFormatter.ofPattern(outputFormat);
			LocalDate ld = LocalDate.parse(inputDate, from);
			return ld.format(to);
		} catch (Exception e) {
			log.error("Error occured while parsing date : input format {},output format {},input date {}", inputFormat,
					outputFormat, inputDate);
		}
		return "";
	}

    public static long daysBetween(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }

}
