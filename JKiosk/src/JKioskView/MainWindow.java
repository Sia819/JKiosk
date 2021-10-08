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
		c = this.getContentPane();
		
		// Make Pages
		windowPanels.put("home", (JPanel)new HomePanel());
		windowPanels.put("order", (JPanel)new OrderPanel());
		
		// Initalize Component
		menuPanel = new MenuPanel();
		pagePanel = windowPanels.get("home"); //가져올 데이터불러오기
		
		// Component add
		c.add(menuPanel, BorderLayout.NORTH);
		c.add(pagePanel);
		
		// Show Window
		this.setVisible(true);
	}
	
	// 페이지 이름을 패러미터로 입력하면 해당 페이지로 이동합니다.
	public void NavigatePage(String pageName)// throws Exception
	{
		if (this.windowPanels.containsKey(pageName))
		{
			c.remove(pagePanel);
			this.pagePanel = (JPanel)this.windowPanels.get(pageName);
			c.add(pagePanel);
			this.revalidate();
			this.repaint();
		}
		else
		{
			int a = 10;
			//throw new Exception("해당하는 페이지\"" + pageName + "\"가 존재하지 않습니다.");
		}
	}
	
	// TODO : 페이지 인스턴스 연결을 해제하고, 새 페이지 인스턴스를 등록시킵니다.
	public void ResetPage(String pageName) throws Exception
	{
		if (this.windowPanels.containsKey(pageName))
		{
			JPanel targetPage = this.windowPanels.get(pageName);
			
			Class<? extends JPanel> temp = targetPage.getClass();
			throw new Exception("Not Implemented!");
		}
	}
	
	// 상단 메뉴 패널입니다.
	class MenuPanel extends JPanel
	{
		public MenuPanel()
		{
			this.setBackground(Color.cyan);
		}
	}
	
	// 하단 페지지 패널입니다. 
	class PagePanel extends JPanel
	{
		public PagePanel()
		{
			this.setBackground(Color.magenta);			
		}
	}
}
