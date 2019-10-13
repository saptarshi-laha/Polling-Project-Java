package rik;

	public interface JDatePanel extends JDateComponent {

	public abstract void setShowYearButtons(boolean showYearButtons);

	public abstract boolean isShowYearButtons();

	public abstract void setDoubleClickAction(boolean doubleClickAction);

	public abstract boolean isDoubleClickAction();

}