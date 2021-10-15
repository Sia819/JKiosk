package JKioskView;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MainWindow extends JFrame
{
	// private fields
	private Container c;
	private JPanel menuPanel;
	private JPanel pagePanel;
	
	Map<String, JPanel> windowPanels = new HashMap<String, JPanel>();
	
	public MainWindow()
	{
		// Initialize MainWindow Property
		this.setTitle("JKiosk");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		// MainWindow Container
		this.c = this.getContentPane();
		
		// Make Pages
		windowPanels.put("home", (JPanel)new HomePanel());
		windowPanels.put("order", (JPanel)new OrderPanel());
		
		// Initalize Component
		menuPanel = new MenuPanel();
		pagePanel = windowPanels.get("home"); //������ �����ͺҷ�����
		
		// Component add
		this.c.add(menuPanel, BorderLayout.NORTH);
		this.c.add(pagePanel);
		
		// Show Window
		this.setVisible(true);
	}
	
	// ������ �̸��� �з����ͷ� �Է��ϸ� �ش� �������� �̵��մϴ�.
	public void NavigatePage(String pageName)// throws Exception
	{
		if (this.windowPanels.containsKey(pageName))
		{
			c.remove(pagePanel); // if pagePanel is not c, do nothing
			this.pagePanel = (JPanel)this.windowPanels.get(pageName);
			c.add(pagePanel);
			this.revalidate();
			this.repaint();
		}
		else
		{
			int a = 10;
			//throw new Exception("�ش��ϴ� ������\"" + pageName + "\"�� �������� �ʽ��ϴ�.");
		}
	}
	
	// TODO : ������ �ν��Ͻ� ������ �����ϰ�, �� ������ �ν��Ͻ��� ��Ͻ�ŵ�ϴ�.
	public void ResetPage(String pageName) throws Exception
	{
		if (this.windowPanels.containsKey(pageName))
		{
			JPanel targetPage = this.windowPanels.get(pageName);
			Class<? extends JPanel> temp = targetPage.getClass();
			
			boolean tempResult = (targetPage.getComponent(0) == c);
			if (tempResult)
				c.remove(targetPage); // if pagePanel is not c, do nothing
			targetPage = temp.getDeclaredConstructor().newInstance();
			if (tempResult)
				c.add(targetPage);
		}
	}
	
	// ��� �޴� �г��Դϴ�.
	class MenuPanel extends JPanel
	{
		public MenuPanel()
		{
			this.setBackground(Color.cyan);
		}
	}
	
	//  // �ϴ� ������ �г��Դϴ�.
	//  class PagePanel extends JPanel
	//  {
	//  	public PagePanel()
	//  	{
	//  		this.setBackground(Color.magenta);			
	//  	}
	//  }
}
