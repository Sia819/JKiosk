package JKioskView;

import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

// ��ٱ���
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
		
		listNameLabel = new JLabel("��ٱ��� ���");
		myListItems = new JList<JPanel>(); 
		basketPriceLabel = new JLabel("�հ� :       ��");
		getPayButton = new JButton("�ֹ��ϱ�");
		
		this.add(listNameLabel);
		this.add(myListItems);
		this.add(basketPriceLabel);
		this.add(getPayButton);
		
		this.setVisible(true);
		
	}
}
