package JKioskView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class HomePanel extends JPanel 
{
	private JButton JButton1;
	private HomePanel self;
	private MainWindow parent;
	
	public HomePanel()
	{
		self = this;
		this.setBackground(Color.white);
		
		this.JButton1 = new JButton();
		
		JButton1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainWindow a = (MainWindow)(SwingUtilities.getRoot(self));
				a.NavigatePage("order");
			}
		});
		
		
		
		
		
		this.add(JButton1);
	}
}
