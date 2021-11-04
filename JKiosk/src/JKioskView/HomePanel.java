package JKioskView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import UserControl.*;

public class HomePanel extends JPanel 
{
	private JButton NavigationOrder;
	private HomePanel self;
	private MainWindow parent;
	
	public HomePanel()
	{
		self = this;
		this.setLayout(null);
		this.setBackground(Color.white);
		
		this.NavigationOrder = new RoundButton("주문하기");
		NavigationOrder.setBounds(50,50, 200, 200);
		NavigationOrder.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		NavigationOrder.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainWindow a = (MainWindow)(SwingUtilities.getRoot(self));
				a.NavigatePage("order");
			}
		});
		
		this.add(NavigationOrder);
	}
	
	
}
