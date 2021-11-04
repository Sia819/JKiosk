package JKioskView;

import java.awt.*;
import javax.swing.*;

//상단 메뉴 패널입니다.
public class TopMenuPanel extends JPanel
{
	JButton back;
	JLabel title;
	
	public TopMenuPanel()
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
		
		title = new JLabel("메뉴이름");
		
		this.add(back);
		this.add(title);
	}
}