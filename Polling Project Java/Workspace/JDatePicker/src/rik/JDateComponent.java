package rik;

import java.awt.event.ActionListener;
import java.util.Properties;

	public interface JDateComponent {
	
	public DateModel<?> getModel();

	public void addActionListener(ActionListener actionListener);

	public void removeActionListener(ActionListener actionListener);

	public Properties getI18nStrings();
	
	public void setI18nStrings(Properties i18nStrings);

}
