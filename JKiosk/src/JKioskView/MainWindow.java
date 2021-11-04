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

	// 예를들어 다른 클래스에서 객체에 대한 정보를 모르더라도,
	// String문자로 특정 객체를 지칭할 수 있도록 해시맵에 JPanel을 등록시킴.
	Map<String, JPanel> windowPanels = new HashMap<String, JPanel>();

	public MainWindow() 
	{
		// Initialize MainWindow Property
		this.setTitle("JKiosk");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//this.setLayout(null);
		

		// MainWindow Container
		c = this.getContentPane();

		// Make Pages
		windowPanels.put("home", (JPanel) new HomePanel());    // 홈화면을 HashMap에 등록시킵니다.
		windowPanels.put("order", (JPanel) new OrderPanel());  // 주문화면을 HashMap에 등록시킵니다.

		// Initalize Component
		menuPanel = new TopMenuPanel();
		pagePanel = windowPanels.get("home"); // String문자로 페이지에 대한 객체를 가져옵니다.

		menuPanel.setSize(200, 200);
		pagePanel.setSize(200, 200);
		// TODO : 레이아웃을 지정했을 때 사이즈 지정하기
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
			c.remove(pagePanel); // if pagePanel is not c, do nothing
			this.pagePanel = (JPanel) this.windowPanels.get(pageName);
			c.add(pagePanel);
			this.revalidate();
			this.repaint();
		} else 
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

			boolean tempResult = (targetPage.getComponent(0) == c);
			if (tempResult)
				c.remove(targetPage); // if pagePanel is not c, do nothing
			targetPage = temp.getDeclaredConstructor().newInstance();
			if (tempResult)
				c.add(targetPage);
		}
	}
}
