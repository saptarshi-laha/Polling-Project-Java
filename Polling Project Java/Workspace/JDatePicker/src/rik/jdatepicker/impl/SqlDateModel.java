package rik.jdatepicker.impl;

import java.sql.Date;
import java.util.Calendar;

import rik.AbstractDateModel;

public class SqlDateModel extends AbstractDateModel<java.sql.Date> {

	public SqlDateModel() {
		this(null);
	}
	
	public SqlDateModel(Date value) {
		super();
		setValue(value);
	}

	protected Date fromCalendar(Calendar from) {
		return new Date(from.getTimeInMillis());
	}

	protected Calendar toCalendar(Date from) {
		Calendar to = Calendar.getInstance();
		to.setTime(from);
		return to;
	}

}
