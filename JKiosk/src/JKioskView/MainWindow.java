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
	
	// ������� �ٸ� Ŭ�������� ��ü�� ���� ������ �𸣴���, 
	// String���ڷ� Ư�� ��ü�� ��Ī�� �� �ֵ��� �ؽøʿ� JPanel�� ��Ͻ�Ŵ.
	Map<String, JPanel> windowPanels = new HashMap<String, JPanel>();
	
	public MainWindow()
	{
		// Initialize MainWindow Property
		this.setTitle("JKiosk");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(new BorderLayout());
		//this.setLayout(null);
		
		// MainWindow Container
		c = this.getContentPane();
		
		// Make Pages
		windowPanels.put("home", (JPanel)new HomePanel());    // Ȩȭ���� HashMap�� ��Ͻ�ŵ�ϴ�.
		windowPanels.put("order", (JPanel)new OrderPanel());  // �ֹ�ȭ���� HashMap�� ��Ͻ�ŵ�ϴ�.
		
		// Initalize Component
		menuPanel = new TopMenuPanel();
		pagePanel = windowPanels.get("home"); // String���ڷ� �������� ���� ��ü�� �����ɴϴ�.
		
		menuPanel.setSize(200,200);
		pagePanel.setSize(200,200);
		// TODO : ���̾ƿ��� �������� �� ������ �����ϱ�
		// Component add
		c.add(menuPanel, BorderLayout.NORTH);
		c.add(pagePanel);
		
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
	
	
	
	//  // �ϴ� ������ �г��Դϴ�.
	//  class PagePanel extends JPanel
	//  {
	//  	public PagePanel()
	//  	{
	//  		this.setBackground(Color.magenta);			
	//  	}
	//  }
}
