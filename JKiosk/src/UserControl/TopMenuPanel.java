package UserControl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import JKioskView.*;
import common.*;

//상단 메뉴 패널입니다.
public class TopMenuPanel extends JPanel
{
	JButton back;
	JLabel title;
	
	// 아무 이상이없다면 MainWidnow에서 생성자 부분이 실행될 때, getInstance를 호출하며 초기화됨
	private static TopMenuPanel instance;
	
	// 이 패널은 프로그램 전체 실행중 변경되지않고, 하나만 존재 하여야하고,
	// 현재 페이지에 대한 정보를 MainWindow인스턴스의 TopPanel 멤버에 접근하지 않고도
	// 다른 클래스에서 쉽게 현재 클래스 인스턴스에 쉽게 접근하도록 하기 위해 싱글톤을 사용.
	// 이 클래스 인스턴스에 접근하기 위한 의존을 줄이기 위함.
	private TopMenuPanel()
	{
		this.setBackground(Color.cyan);
		this.setMaximumSize( new Dimension(Integer.MAX_VALUE, 100 ));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		ImageIcon icon = new ImageIcon("src/image/backArrow.png");
		Image changeImg = icon.getImage().getScaledInstance(70, 40, Image.SCALE_SMOOTH); // 버튼의 이미지 크기조정
		icon = new ImageIcon(changeImg);
		back = new JButton(icon);
		back.setBorder(BorderFactory.createEmptyBorder()); // 버튼의 보더를 제거
		back.setSize(100,50);
		
		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				movePreviousPage();
			}
		});
		
		title = new JLabel("메뉴이름");
		
		this.add(back);
		this.add(title);
	}
	
	public void movePreviousPage()
	{
		// MainWindow의 windowPanels들중 현재 보여지는 PagePanel 클래스를 가져옴.
		PagePanel current = (PagePanel)MainWindow.getInstance().windowPanels.get(MainWindow.CurrentPageName);
		String previousPageName = current.getDefaultPriviousPagename();
		
		if (previousPageName != "")
			MainWindow.getInstance().NavigatePage(previousPageName);
		else
			JOptionPane.showMessageDialog(null, "이전 페이지가 설정되지 않았습니다.", "Error!", JOptionPane.ERROR_MESSAGE);
	}
	
	public static TopMenuPanel getInstance() 
	{
		if (instance == null)
			instance = new TopMenuPanel();
		
			return instance;
    }
}