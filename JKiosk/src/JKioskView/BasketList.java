package JKioskView;

import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

// 장바구니
public class BasketList extends JPanel  
{
	JLabel listNameLabel;
	JList<JPanel> myListItems;
	public BasketList()
	{
		this.setBackground(Color.MAGENTA);
		
		//this.setSize(200, 500);
		
		setLayout(new BorderLayout());
		listNameLabel = new JLabel("장바구니 목록");
		myListItems = new JList<JPanel>(); 
		listNameLabel = new JLabel("장바구니 목록");
		
	}
}
