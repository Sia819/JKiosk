package JKioskView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import UserControl.BasketList;
import common.*;

// 주문 페이지
public class OrderPanel extends PagePanel
{
	private JButton JButton1;
	private BasketList myBasket;

	
	public OrderPanel()
	{
		GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        setLayout(gbl);
		
		this.JButton1 = new JButton("test");
		this.myBasket = new BasketList() { public Dimension getPreferredSize() { return new Dimension(400, 400); }; };
		
		LayoutExtension.addGridBag(this, JButton1, gbl, gbc, 0, 0, 1, 0, 1, 1);
		LayoutExtension.addGridBag(this, myBasket, gbl, gbc, 1, 0, 1, 1, 0, 1);

	}
	
	
	

}
