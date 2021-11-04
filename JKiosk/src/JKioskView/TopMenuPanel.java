package JKioskView;

import java.awt.*;
import javax.swing.*;

//��� �޴� �г��Դϴ�.
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
		Image changeImg = icon.getImage().getScaledInstance(70, 40, Image.SCALE_SMOOTH); // ��ư�� �̹��� ũ������
		icon = new ImageIcon(changeImg);
		back = new JButton(icon);
		back.setBorder(BorderFactory.createEmptyBorder()); // ��ư�� ������ ����
		back.setSize(100,50);
		
		title = new JLabel("�޴��̸�");
		
		this.add(back);
		this.add(title);
	}
}