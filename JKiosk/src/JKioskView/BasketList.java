package JKioskView;

import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

// ��ٱ���
public class BasketList extends JPanel  
{
	JLabel listNameLabel;
	JList<JPanel> myListItems;
	public BasketList()
	{
		this.setBackground(Color.MAGENTA);
		
		//this.setSize(200, 500);
		
		setLayout(new BorderLayout());
		listNameLabel = new JLabel("��ٱ��� ���");
		myListItems = new JList<JPanel>(); 
		listNameLabel = new JLabel("��ٱ��� ���");
		
	}
}
