package rik;

import java.beans.PropertyChangeListener;

import javax.swing.event.ChangeListener;

	public interface DateModel<T> {

	public void addChangeListener(ChangeListener changeListener);

	public void removeChangeListener(ChangeListener changeListener);

	public int getYear();
	
	public void setYear(int year);
	
	public int getMonth();
	
	public void setMonth(int month);
	
	public int getDay();

	public void setDay(int day);
	
	public void setDate(int year, int month, int day);
	
	public void addYear(int add);
	
	public void addMonth(int add);
	
	public void addDay(int add);

	public T getValue();

	public void setValue(T value);
	
	public boolean isSelected();
	
	public void setSelected(boolean selected);
	
    public void addPropertyChangeListener(PropertyChangeListener listener);

    public void removePropertyChangeListener(PropertyChangeListener listener);

}
