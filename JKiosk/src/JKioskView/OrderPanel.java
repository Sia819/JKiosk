package JKioskView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class OrderPanel extends JPanel 
{
	private JButton JButton1;
	
	public OrderPanel()
	{
		this.setBackground(Color.green);
		
		this.JButton1 = new JButton("�ȳ��ϼ���");
		
		this.add(JButton1);
	}
}
