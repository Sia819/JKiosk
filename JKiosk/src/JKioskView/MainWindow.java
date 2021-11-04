package JKioskView;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import common.*;

public class MainWindow extends JFrame 
{
	// private fields
	private Container c;
	private JPanel menuPanel;
	private JPanel pagePanel;

	// 예를들어 다른 클래스에서 객체에 대한 정보를 모르더라도,
	// String문자로 특정 객체를 지칭할 수 있도록 해시맵에 JPanel을 등록시킴.
	public Map<String, JPanel> windowPanels = new HashMap<String, JPanel>();
	public static String CurrentPageName = "";

	private static MainWindow instance;
	
	// 만약, 싱글톤이 아니라면 하위 클래스에서는 MainWindow a = (MainWindow)(SwingUtilities.getRoot(self));
	// 이와 같이 복잡한 식으로 인스턴스를 얻어와야 함.
	private MainWindow()
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
		HomePanel home = new HomePanel();
		home.setDefaultPriviousPagename("");
		home.setDefaultPrecedePagename("order");
		windowPanels.put("home", home);    // 홈화면을 HashMap에 등록시킵니다.
		OrderPanel order = new OrderPanel();
		order.setDefaultPriviousPagename("home");
		order.setDefaultPrecedePagename("");
		windowPanels.put("order", order);  // 주문화면을 HashMap에 등록시킵니다.

		// Initalize Component
		menuPanel = TopMenuPanel.getInstance();
		pagePanel = windowPanels.get("home"); // String문자로 페이지에 대한 객체를 가져옵니다.
		CurrentPageName = "home";

		menuPanel.setSize(200, 200);
		pagePanel.setSize(200, 200);
		// TODO : 레이아웃을 지정했을 때 사이즈 지정하기
		// Component add
		c.add(menuPanel, BorderLayout.NORTH);
		c.add(pagePanel);

		// Show Window
		this.setVisible(true);
	}
	
	public static MainWindow getInstance() 
	{
		if (instance == null)
			instance = new MainWindow();

		return instance;
    }

	// 페이지 이름을 패러미터로 입력하면 해당 페이지로 이동합니다.
	public void NavigatePage(String pageName)
	{
		if (this.windowPanels.containsKey(pageName)) 
		{
			c.remove(pagePanel); // if pagePanel is not c, do nothing
			this.pagePanel = (JPanel) this.windowPanels.get(pageName);
			c.add(pagePanel);
			this.revalidate();
			this.repaint();
			CurrentPageName = pageName;
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "\"" + pageName + "\" 페이지로 이동하려고 하였지만, 해당되는 페이지가 등록되어있지 않습니다.", "Page Move Error!", JOptionPane.ERROR_MESSAGE);
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
