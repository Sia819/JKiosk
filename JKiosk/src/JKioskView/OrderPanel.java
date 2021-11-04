package JKioskView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import common.*;

// 주문 페이지
public class OrderPanel extends PagePanel
{
	private JButton JButton1;
	private BasketList myList;

	
	public OrderPanel()
	{
		this.setBackground(Color.green);
		this.setLayout(new GridLayout(1, 2));
		
		this.JButton1 = new JButton("test");
		this.myList = new BasketList();
		
		this.add(JButton1);
		this.add(myList);
	}

}
