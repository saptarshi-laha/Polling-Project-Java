package rik;

import javax.swing.JFormattedTextField;

import rik.jdatepicker.impl.JDatePanelImpl;
import rik.jdatepicker.impl.JDatePickerImpl;
import rik.jdatepicker.impl.SqlDateModel;
import rik.jdatepicker.impl.UtilCalendarModel;
import rik.jdatepicker.impl.UtilDateModel;

	public class JDateComponentFactory {

	public static JDatePicker createJDatePicker() {
		return new JDatePickerImpl(new JDatePanelImpl(null), null);
	}
	
	public static JDatePicker createJDatePicker(DateModel<?> model) {
		return new JDatePickerImpl(new JDatePanelImpl(model), null);
	}
	
	public static JDatePicker createJDatePicker(JFormattedTextField.AbstractFormatter dateFormatter) {
		return new JDatePickerImpl(new JDatePanelImpl(null), dateFormatter);
	}
	
	public static JDatePicker createJDatePicker(DateModel<?> model, JFormattedTextField.AbstractFormatter dateFormatter) {
		return new JDatePickerImpl(new JDatePanelImpl(model), dateFormatter);
	}

	public static JDatePanel createJDatePanel() {
		return new JDatePanelImpl(null);
	}
	
	public static JDatePanel createJDatePanel(DateModel<?> model) {
		return new JDatePanelImpl(model);
	}
	
	public static DateModel<?> createDateModel(Object value) {
		Class<?> clazz = value.getClass();
		
		DateModel<?> result = null;
		if (clazz.equals(java.util.Calendar.class)) {
			result = new UtilCalendarModel((java.util.Calendar)value);
		}
		if (clazz.equals(java.util.Date.class)) {
			result = new UtilDateModel((java.util.Date)value);
		}
		if (clazz.equals(java.sql.Date.class)) {
			result = new SqlDateModel((java.sql.Date)value);
		}
		
		return result;
	}
	
	public static DateModel<?> createDateModel(Class<?> clazz) {
		DateModel<?> result = null;
		if (clazz.equals(java.util.Calendar.class)) {
			result = new UtilCalendarModel();
		}
		if (clazz.equals(java.util.Date.class)) {
			result = new UtilDateModel();
		}
		if (clazz.equals(java.sql.Date.class)) {
			result = new SqlDateModel();
		}
		
		return result;
	}
	
}
