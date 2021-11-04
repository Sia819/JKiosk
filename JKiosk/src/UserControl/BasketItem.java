package UserControl;

import javax.swing.*;

public class BasketItem extends JPanel 
{
	int Amount = 0;
	
	JLabel itemName;
	
	public BasketItem(String name)
	{
		itemName = new JLabel(name);
		
		this.setVisible(true);
	}
}
