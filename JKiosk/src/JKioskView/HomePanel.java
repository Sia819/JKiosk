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
		
		/*
		this.NavigationOrder = new JButton("�ֹ��ϱ�");
		NavigationOrder.setBounds(50,50, 200, 200);
		NavigationOrder.setContentAreaFilled(false);
		Border b = new RoundedBorder();
				
		NavigationOrder.setBorder(b);
		NavigationOrder.setFont(new Font("����", Font.PLAIN, 14));
		*/
		this.NavigationOrder = new RoundButton("�ֹ��ϱ�");
		NavigationOrder.setBounds(50,50, 200, 200);
		NavigationOrder.setFont(new Font("����", Font.BOLD, 20));
		
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
	
	
	
	/*
	private static class RoundedBorder implements Border {
	    private int radius;
	    
	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }

	    public boolean isBorderOpaque() {
	        return true;
	    }

	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	    //  https://stackoverflow.com/questions/423950/rounded-swing-jbutton-using-java
	}
	*/
}

/*
this.setLayout(null); 
�� �ƴ� ��� ��Ʈ���� ����� �����ؾ��� �� setSize�� ���� �ʴ´�, �׷� ��
NavigationOrder.setPreferredSize(new Dimension(100, 100));
�� �ϸ� �ȴ�.
*/