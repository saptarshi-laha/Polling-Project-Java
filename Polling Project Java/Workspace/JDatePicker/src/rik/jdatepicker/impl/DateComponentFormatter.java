package rik.jdatepicker.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFormattedTextField;

import rik.jdatepicker.util.JDatePickerUtil;

	public class DateComponentFormatter extends JFormattedTextField.AbstractFormatter {
	
	private static final long serialVersionUID = 5997312768041129127L;
	
	DateFormat format;
	
	public DateComponentFormatter(){
		format = JDatePickerUtil.getMediumDateFormat();
	}
	
	@Override
	public String valueToString(Object value) throws ParseException {
		Calendar cal = (Calendar)value;
		if (cal == null) {
			return "";
		}
		return format.format(cal.getTime());
	}
	
	@Override
	public Object stringToValue(String text) throws ParseException {
		if (text == null || text.equals("")) {
			return null;
		}
		Date date = format.parse(text);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
}
