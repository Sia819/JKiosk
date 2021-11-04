package JKioskView;

import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

// 장바구니
public class BasketList extends JPanel  
{
	JLabel listNameLabel;
	JList<JPanel> myListItems;
	JLabel basketPriceLabel;
	JButton getPayButton;
	public BasketList()
	{
		this.setBackground(Color.MAGENTA);
		//this.setSize(200, 500);
		
		this.setLayout(new BorderLayout());
		
		listNameLabel = new JLabel("장바구니 목록");
		myListItems = new JList<JPanel>(); 
		basketPriceLabel = new JLabel("합계 :       원");
		getPayButton = new JButton("주문하기");
		
		this.add(listNameLabel);
		this.add(myListItems);
		this.add(basketPriceLabel);
		this.add(getPayButton);
		
		this.setVisible(true);
		
	}
}
