package rik.jdatepicker.impl;

import java.util.Calendar;

import rik.AbstractDateModel;

public class UtilCalendarModel extends AbstractDateModel<java.util.Calendar> {
	
	public UtilCalendarModel() {
		this(null);
	}
	
	public UtilCalendarModel(Calendar value) {
		super();
		setValue(value);
	}

	protected Calendar fromCalendar(Calendar from) {
		return (Calendar)from.clone();
	}

	protected Calendar toCalendar(Calendar from) {
		return (Calendar)from.clone();
	}
	
}

