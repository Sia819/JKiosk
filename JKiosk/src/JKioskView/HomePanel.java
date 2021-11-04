package JKioskView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import UserControl.*;
import common.*;

public class HomePanel extends PagePanel
{
	private JButton NavigationOrder;
	private HomePanel self;
	private MainWindow parent;
	
	public HomePanel()
	{
		self = this;
		//this.setLayout(null);
		this.setBackground(Color.white);
		
		this.NavigationOrder = new RoundButton("주문하기")
		{
			// setLayout(new BorderLayout()); 으로할 때 사이즈가 fixed되는 문제를 수정
			public Dimension getPreferredSize() { return new Dimension(200, 200); };
		};
		NavigationOrder.setBounds(50, 50, 200, 200);
		NavigationOrder.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		NavigationOrder.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainWindow.getInstance().NavigatePage("order");
			}
		});
		
		this.add(NavigationOrder, BorderLayout.CENTER);
	}


}
