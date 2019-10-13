package rik.jdatepicker.impl;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import rik.DateModel;
import rik.JDatePanel;
import rik.jdatepicker.graphics.JNextIcon;
import rik.jdatepicker.graphics.JPreviousIcon;
import rik.jdatepicker.util.JDatePickerUtil;

	public class JDatePanelImpl extends JPanel implements JDatePanel {

	private static final long serialVersionUID = -2299249311312882915L;
	
	private HashSet<ActionListener> actionListeners;
	private Properties i18nStrings;
	private boolean showYearButtons;
	private boolean doubleClickAction;
	
	private InternalCalendarModel internalModel;
	private InternalView internalView;
	private InternalController internalController;

	public JDatePanelImpl(DateModel<?> model) {
		showYearButtons = false;
		doubleClickAction = false;
		actionListeners = new HashSet<ActionListener>();
		i18nStrings = new Properties(getDefaultStrings());
		
		internalModel = new InternalCalendarModel((model != null) ? model : createDefaultDateModel());
		internalController = new InternalController();
		internalView = new InternalView();
		
		setLayout(new GridLayout(1, 1));
		add(internalView);
	}
	
	protected DateModel<?> createDefaultDateModel() {
		return new UtilCalendarModel();
	}
	
	private Properties getDefaultStrings() {
		Properties defaults = new Properties();
		defaults.put("messages.today", "Today");
		defaults.put("messages.nextMonth", "Next month");
		defaults.put("messages.previousMonth", "Previous month");
		defaults.put("messages.nextYear", "Next year");
		defaults.put("messages.previousYear", "Previous year");
		defaults.put("messages.clear", "Clear");
		
		return defaults;
	}

	public void addActionListener(ActionListener actionListener) {
		actionListeners.add(actionListener);
	}

	public void removeActionListener(ActionListener actionListener) {
		actionListeners.remove(actionListener);
	}

	private void fireActionPerformed() {
		for (ActionListener actionListener : actionListeners) {
			actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Date selected"));
		}
	}

	public void setI18nStrings(Properties i18nStrings) {
		this.i18nStrings = i18nStrings;
	}
	
	public Properties getI18nStrings() {
		return i18nStrings;
	}

	public void setShowYearButtons(boolean showYearButtons) {
		this.showYearButtons = showYearButtons;
		internalView.updateShowYearButtons();
	}

	public boolean isShowYearButtons() {
		return this.showYearButtons;
	}

	public void setDoubleClickAction(boolean doubleClickAction) {
		this.doubleClickAction = doubleClickAction;
	}

	public boolean isDoubleClickAction() {
		return doubleClickAction;
	}

	public DateModel<?> getModel() {
		return internalModel.getModel();
	}

	private class InternalView extends JPanel {
	
		private static final long serialVersionUID = -6844493839307157682L;
		
		private JPanel centerPanel;
		private JPanel northCenterPanel;
		private JPanel northPanel;
		private JPanel southPanel;
		private JPanel previousButtonPanel;
		private JPanel nextButtonPanel;
		private JTable dayTable;
		private JTableHeader dayTableHeader;
		private InternalTableCellRenderer dayTableCellRenderer;
		private JLabel monthLabel;
		private JLabel todayLabel;
		private JLabel noneLabel;
		private JPopupMenu monthPopupMenu;
		private JMenuItem[] monthPopupMenuItems;
		private JButton nextMonthButton;
		private JButton previousMonthButton;
		private JButton previousYearButton;
		private JButton nextYearButton;
		private JSpinner yearSpinner;

		private void updateShowYearButtons() {
			if (showYearButtons) {
				getNextButtonPanel().add(getNextYearButton());
				getPreviousButtonPanel().removeAll();
				getPreviousButtonPanel().add(getPreviousYearButton());
				getPreviousButtonPanel().add(getPreviousMonthButton());
			} else {
				getNextButtonPanel().remove(getNextYearButton());
				getPreviousButtonPanel().remove(getPreviousYearButton());
			}			
		}
		

		private void updateMonthLabel() {
			DateFormatSymbols df = new DateFormatSymbols();
			monthLabel.setText(df.getMonths()[internalModel.getModel().getMonth()]);
		}
		
		public InternalView() {
			initialise();
		}
		

		private void initialise() {
			this.setLayout(new java.awt.BorderLayout());
			this.setSize(200, 180);
			this.setPreferredSize(new java.awt.Dimension(200, 180));
			this.setBackground(java.awt.SystemColor.activeCaptionText);
			this.setOpaque(false);
			this.add(getNorthPanel(), java.awt.BorderLayout.NORTH);
			this.add(getSouthPanel(), java.awt.BorderLayout.SOUTH);
			this.add(getCenterPanel(), java.awt.BorderLayout.CENTER);
		}
		
  
		private JPanel getNorthPanel() {
			if (northPanel == null) {
				northPanel = new javax.swing.JPanel();
				northPanel.setLayout(new java.awt.BorderLayout());
				northPanel.setName("");
				northPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(3,3,3,3));
				northPanel.setBackground(java.awt.SystemColor.activeCaption);
				northPanel.add(getPreviousButtonPanel(), java.awt.BorderLayout.WEST);
				northPanel.add(getNextButtonPanel(), java.awt.BorderLayout.EAST);
				northPanel.add(getNorthCenterPanel(), java.awt.BorderLayout.CENTER);
			}
			return northPanel;
		}

		private JPanel getNorthCenterPanel() {
			if (northCenterPanel == null) {
				northCenterPanel = new javax.swing.JPanel();
				northCenterPanel.setLayout(new java.awt.BorderLayout());
				northCenterPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,5,0,5));
				northCenterPanel.setOpaque(false);
				northCenterPanel.add(getMonthLabel(), java.awt.BorderLayout.CENTER);
				northCenterPanel.add(getYearSpinner(), java.awt.BorderLayout.EAST);
			}
			return northCenterPanel;
		}
		
		private JLabel getMonthLabel() {
			if (monthLabel == null) {
				monthLabel = new javax.swing.JLabel();
				monthLabel.setForeground(java.awt.SystemColor.activeCaptionText);
				monthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				monthLabel.addMouseListener(internalController);
				updateMonthLabel();
			}
			return monthLabel;
		}

		private JSpinner getYearSpinner() {
			if (yearSpinner == null) {
				yearSpinner = new javax.swing.JSpinner();
				yearSpinner.setModel(internalModel);
			}
			return yearSpinner;
		}
   
		private JPanel getSouthPanel() {
			if (southPanel == null) {
				southPanel = new javax.swing.JPanel();
				southPanel.setLayout(new java.awt.BorderLayout());
				//southPanel.setOpaque(false);
				southPanel.setBackground(Color.WHITE);
				southPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(3,3,3,3));
				southPanel.add(getTodayLabel(), java.awt.BorderLayout.WEST);
				southPanel.add(getNoneLabel(), java.awt.BorderLayout.EAST);
			}
			return southPanel;
		}

		private JLabel getNoneLabel() {
			if (noneLabel == null) {
				noneLabel = new javax.swing.JLabel();
				noneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				noneLabel.addMouseListener(internalController);
				noneLabel.setText(i18nStrings.getProperty("messages.clear"));
				noneLabel.setForeground(Color.BLACK);
			}
			return noneLabel;
		}

		private JLabel getTodayLabel() {
			if (todayLabel == null) {
				todayLabel = new javax.swing.JLabel();
				todayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				todayLabel.addMouseListener(internalController);
				
				DateFormat df1 = JDatePickerUtil.getMediumDateFormat();
				todayLabel.setText(i18nStrings.getProperty("messages.today") + ": " + df1.format(new Date()));
				todayLabel.setForeground(Color.BLACK);
			}
			return todayLabel;
		}
   
		private JPanel getCenterPanel() {
			if (centerPanel == null) {
				centerPanel = new javax.swing.JPanel();
				centerPanel.setLayout(new java.awt.BorderLayout());
				centerPanel.setOpaque(false);
				centerPanel.add(getDayTableHeader(), java.awt.BorderLayout.NORTH);
				centerPanel.add(getDayTable(), java.awt.BorderLayout.CENTER);
			}
			return centerPanel;
		}
  
		private JTable getDayTable() {
			if (dayTable == null) {
				dayTable = new javax.swing.JTable();
				dayTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
				dayTable.setRowHeight(18); 
				//dayTable.setOpaque(false);
				dayTable.setPreferredSize(new java.awt.Dimension(100,80));
				dayTable.setModel(internalModel);
				dayTable.setShowGrid(true);
				dayTable.setGridColor(Color.WHITE);
				dayTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				dayTable.setCellSelectionEnabled(true);
				dayTable.setRowSelectionAllowed(true);
				dayTable.setFocusable(false);
				dayTable.addMouseListener(internalController);
				TableColumn column = null;
				for (int i = 0; i < 7; i++) {
					column = dayTable.getColumnModel().getColumn(i);
					column.setPreferredWidth(15);
					column.setCellRenderer(getDayTableCellRenderer());
				}
			}
			return dayTable;
		}
		
		private InternalTableCellRenderer getDayTableCellRenderer() {
			if (dayTableCellRenderer == null) {
				dayTableCellRenderer = new InternalTableCellRenderer();
			}
			return dayTableCellRenderer;
		}
		
		private JTableHeader getDayTableHeader() {
			if (dayTableHeader == null) {
				dayTableHeader = getDayTable().getTableHeader();
				dayTableHeader.setResizingAllowed(false);
				dayTableHeader.setReorderingAllowed(false);
				dayTableHeader.setDefaultRenderer(getDayTableCellRenderer());
			}
			return dayTableHeader;
		}

		private JPanel getPreviousButtonPanel() {
			if (previousButtonPanel == null) {
				previousButtonPanel = new javax.swing.JPanel();
				java.awt.GridLayout layout = new java.awt.GridLayout(1,2);
				layout.setHgap(3);
				previousButtonPanel.setLayout(layout);
				previousButtonPanel.setName("");
				previousButtonPanel.setBackground(java.awt.SystemColor.activeCaption);
				if (isShowYearButtons()) {
					previousButtonPanel.add(getPreviousYearButton());
				}
				previousButtonPanel.add(getPreviousMonthButton());
			}
			return previousButtonPanel;
		}
		
		private JPanel getNextButtonPanel() {
			if (nextButtonPanel == null) {
				nextButtonPanel = new javax.swing.JPanel();
				java.awt.GridLayout layout = new java.awt.GridLayout(1,2);
				layout.setHgap(3);
				nextButtonPanel.setLayout(layout);
				nextButtonPanel.setName("");
				nextButtonPanel.setBackground(java.awt.SystemColor.activeCaption);
				nextButtonPanel.add(getNextMonthButton());
				if (isShowYearButtons()) {
					nextButtonPanel.add(getNextYearButton());
				}
			}
			return nextButtonPanel;
		}

		private JButton getNextMonthButton() {
			if (nextMonthButton == null) {
				nextMonthButton = new javax.swing.JButton(new JNextIcon(4,7));
				nextMonthButton.setText("");
				nextMonthButton.setPreferredSize(new java.awt.Dimension(20,15));
				nextMonthButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				nextMonthButton.setFocusable(false);
				nextMonthButton.addActionListener(internalController);
				nextMonthButton.setToolTipText(i18nStrings.getProperty("messages.nextMonth"));
			}
			return nextMonthButton;
		}

		private JButton getNextYearButton() {
			if (nextYearButton == null) {
				nextYearButton = new javax.swing.JButton(new JNextIcon(8,7, true));
				nextYearButton.setText("");
				nextYearButton.setPreferredSize(new java.awt.Dimension(20,15));
				nextYearButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				nextYearButton.setFocusable(false);
				nextYearButton.addActionListener(internalController);
				nextYearButton.setToolTipText(i18nStrings.getProperty("messages.nextYear"));
			}
			return nextYearButton;
		}

		private JButton getPreviousMonthButton() {
			if (previousMonthButton == null) {
				previousMonthButton = new javax.swing.JButton(new JPreviousIcon(4,7));
				previousMonthButton.setText("");
				previousMonthButton.setPreferredSize(new java.awt.Dimension(20,15));
				previousMonthButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				previousMonthButton.setFocusable(false);
				previousMonthButton.addActionListener(internalController);
				previousMonthButton.setToolTipText(i18nStrings.getProperty("messages.previousMonth"));
			}
			return previousMonthButton;
		}

		private JButton getPreviousYearButton() {
			if (previousYearButton == null) {
				previousYearButton = new javax.swing.JButton(new JPreviousIcon(8,7, true));
				previousYearButton.setText("");
				previousYearButton.setPreferredSize(new java.awt.Dimension(20,15));
				previousYearButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				previousYearButton.setFocusable(false);
				previousYearButton.addActionListener(internalController);
				previousYearButton.setToolTipText(i18nStrings.getProperty("messages.previousYear"));
			}
			return previousYearButton;
		}

		private JPopupMenu getMonthPopupMenu() {
			if (monthPopupMenu == null) {
				monthPopupMenu = new javax.swing.JPopupMenu();
				JMenuItem[] menuItems = getMonthPopupMenuItems(); 
				for (int i=0; i<menuItems.length; i++) {
					monthPopupMenu.add(menuItems[i]);
				}
			}
			return monthPopupMenu;
		}
		
		private JMenuItem[] getMonthPopupMenuItems(){
			if (monthPopupMenuItems == null) {
				DateFormatSymbols df = new DateFormatSymbols();
				String[] months = df.getMonths();
				monthPopupMenuItems = new JMenuItem[months.length-1];
				for (int i=0; i<months.length-1; i++) {
					JMenuItem mi = new JMenuItem(months[i]);
					mi.addActionListener(internalController);
					monthPopupMenuItems[i] = mi;
				}
			}
			return monthPopupMenuItems;
		}

	}

	private class InternalTableCellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = -2341614459632756921L;

		public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean isSelected, boolean hasFocus, int row, int col) {
			JLabel label = (JLabel) super.getTableCellRendererComponent(arg0, arg1, isSelected, hasFocus, row, col);
			label.setHorizontalAlignment(JLabel.CENTER);

			if (row == -1) {
				label.setForeground(new Color(10, 36, 106));
				label.setBackground(Color.LIGHT_GRAY);
				label.setHorizontalAlignment(JLabel.CENTER);
				return label;
			}

			
			Calendar todayCal = Calendar.getInstance();
			Calendar selectedCal = Calendar.getInstance();
			selectedCal.set(internalModel.getModel().getYear(), internalModel.getModel().getMonth(), internalModel.getModel().getDay());
			
			int cellDayValue = (Integer) arg1;
			int lastDayOfMonth = selectedCal.getActualMaximum(Calendar.DAY_OF_MONTH);

			
			if (cellDayValue < 1 || cellDayValue > lastDayOfMonth) {
				label.setForeground(Color.LIGHT_GRAY);
				label.setBackground(Color.WHITE);
				
				
				if (cellDayValue > lastDayOfMonth) {
					label.setText(Integer.toString(cellDayValue - lastDayOfMonth));
				} 
				
				else {
					Calendar lastMonth = new GregorianCalendar();
					lastMonth.set(selectedCal.get(Calendar.YEAR), selectedCal.get(Calendar.MONTH) - 1, 1);
					int lastDayLastMonth = lastMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
					label.setText(Integer.toString(lastDayLastMonth + cellDayValue));
				}
			}
			
			else { 
				label.setForeground(Color.BLACK);
				label.setBackground(Color.WHITE);
				
				
				if (todayCal.get(Calendar.DATE) == cellDayValue
						&& todayCal.get(Calendar.MONTH) == internalModel.getModel().getMonth()
						&& todayCal.get(Calendar.YEAR) == internalModel.getModel().getYear()) {
					label.setForeground(Color.RED);
				
					if (internalModel.getModel().isSelected() && selectedCal.get(Calendar.DATE) == cellDayValue) {
						label.setBackground(new Color(10, 36, 106));
					}
				}
				
				else {
					
					if (internalModel.getModel().isSelected() && selectedCal.get(Calendar.DATE) == cellDayValue) {
						label.setForeground(Color.WHITE);
						label.setBackground(new Color(10, 36, 106));
					}
				}
			}

			return label;
		}

	}

	private class InternalController implements ActionListener, MouseListener {

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == internalView.getNextMonthButton()) {
				internalModel.getModel().addMonth(1);
			} 
			else if (arg0.getSource() == internalView.getPreviousMonthButton()) {
				internalModel.getModel().addMonth(-1);
			} 
			else if (arg0.getSource() == internalView.getNextYearButton()) {
				internalModel.getModel().addYear(1);
			} 
			else if (arg0.getSource() == internalView.getPreviousYearButton()) {
				internalModel.getModel().addYear(-1);
			} 
			else {
				for (int month = 0; month < internalView.getMonthPopupMenuItems().length; month++) {
					if (arg0.getSource() == internalView.getMonthPopupMenuItems()[month]) {
						internalModel.getModel().setMonth(month);
					}
				}
			}
		}

		public void mousePressed(MouseEvent arg0) {
			if (arg0.getSource() == internalView.getMonthLabel()) {
				internalView.getMonthPopupMenu().setLightWeightPopupEnabled(false);
				internalView.getMonthPopupMenu().show((Component) arg0.getSource(), arg0.getX(), arg0.getY());
			} 
			else if (arg0.getSource() == internalView.getTodayLabel()) {
				Calendar today = Calendar.getInstance();
				internalModel.getModel().setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
			} 
			else if (arg0.getSource() == internalView.getDayTable()) {
				int row = internalView.getDayTable().getSelectedRow();
				int col = internalView.getDayTable().getSelectedColumn();
				if (row >= 0 && row <= 5) {
					Integer date = (Integer) internalModel.getValueAt(row, col);
					internalModel.getModel().setDay(date);
					internalModel.getModel().setSelected(true);
					
					if (doubleClickAction && arg0.getClickCount() == 2) {
						fireActionPerformed();
					}
					if (!doubleClickAction) {
						fireActionPerformed();
					}
				}
			}
			else if (arg0.getSource() == internalView.getNoneLabel()) {
				internalModel.getModel().setSelected(false);
				
				if (doubleClickAction && arg0.getClickCount() == 2) {
					fireActionPerformed();
				}
				if (!doubleClickAction) {
					fireActionPerformed();
				}
			}
		}
		
		public void mouseClicked(MouseEvent arg0) {
		}
	
		public void mouseEntered(MouseEvent arg0) {
		}

		public void mouseExited(MouseEvent arg0) {
		}

		public void mouseReleased(MouseEvent arg0) {
		}

	}

	protected class InternalCalendarModel implements TableModel, SpinnerModel, ChangeListener {

		private DateModel<?> model;
		private HashSet<ChangeListener> spinnerChangeListeners;
		private HashSet<TableModelListener> tableModelListeners;

		public InternalCalendarModel(DateModel<?> model){
			this.spinnerChangeListeners = new HashSet<ChangeListener>();
			this.tableModelListeners = new HashSet<TableModelListener>();
			this.model = model;
			model.addChangeListener(this);
		}
		
		public DateModel<?> getModel() {
			return model;
		}

		public void addChangeListener(ChangeListener arg0) {
			spinnerChangeListeners.add(arg0);
		}

		public void removeChangeListener(ChangeListener arg0) {
			spinnerChangeListeners.remove(arg0);
		}

		public Object getNextValue() {
			return Integer.toString(model.getYear() + 1);
		}

		public Object getPreviousValue() {
			return Integer.toString(model.getYear() - 1);
		}

		public void setValue(Object text) {
			model.setYear(new Integer((String)text));
		}

		public Object getValue() {
			return Integer.toString(model.getYear());
		}

		public void addTableModelListener(TableModelListener arg0) {
			tableModelListeners.add(arg0);
		}

		public void removeTableModelListener(TableModelListener arg0) {
			tableModelListeners.remove(arg0);
		}

		public int getColumnCount() {
			return 7;
		}

		public String getColumnName(int arg0) {
			DateFormatSymbols df = new DateFormatSymbols();
			String[] shortDays = df.getShortWeekdays();
			return shortDays[arg0 + 1];
		}

		
		public Class<?> getColumnClass(int arg0) {
			return Integer.class;
		}

		public int getRowCount() {
			return 6;
		}

		public Object getValueAt(int arg0, int arg1) {
			Calendar firstDayOfMonth = Calendar.getInstance();
			firstDayOfMonth.set(model.getYear(), model.getMonth(), 1);
			int DOW = firstDayOfMonth.get(Calendar.DAY_OF_WEEK);
			int value = arg1 - DOW + arg0*7 + 2;
			return new Integer(value);
		}

		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

		public void setValueAt(Object arg0, int arg1, int arg2) {
		}

		private void fireValueChanged() {
			
			for (ChangeListener cl : spinnerChangeListeners) {
				cl.stateChanged(new ChangeEvent(this));
			}
			
		
			internalView.updateMonthLabel();
			
		
			for (TableModelListener tl : tableModelListeners) {
				tl.tableChanged(new TableModelEvent(this));
			}
		}

		public void stateChanged(ChangeEvent e) {
			fireValueChanged();
		}

	}
	
}
