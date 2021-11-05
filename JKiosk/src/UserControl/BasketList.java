package UserControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;

import JKioskView.MainWindow;
import common.*;

// 장바구니
public class BasketList extends JPanel
{
	JLabel listNameLabel;
	//JList<JPanel> myListItems;
	JList<BasketItem> myListItems;
	Vector<BasketItem> v = new Vector<BasketItem>();
	JLabel basketPriceLabel;
	JButton getPayButton;
	public BasketList()
	{
		this.setBackground(Color.MAGENTA);
		//this.setSize(200, 500);
		
		// TODO 
		
		GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        setLayout(gbl);
		
		listNameLabel = new JLabel("장바구니 목록")
		{ public Dimension getPreferredSize() { return new Dimension(80, 80); }; };

		// TODO 실제로 정상적으로 표기되지 않음
		// 이 구조는 추후에
		// JList custom renderer를 통해
		// 정상적인 리스트형식의 패널들이 보여지게 할 계획
		myListItems = new JList<BasketItem>(v);
		v.add(new BasketItem("a"));
		v.add(new BasketItem("b"));
		v.add(new BasketItem("c"));
		
		basketPriceLabel = new JLabel("합계 :       원") { public Dimension getPreferredSize() { return new Dimension(80, 80); }; };
		getPayButton = new JButton("주문하기") { public Dimension getPreferredSize() { return new Dimension(100, 100); }; };
		getPayButton.setSize(0, 200);
		//getPayButton.setMinimumSize((new Dimension(100, 100)));
		getPayButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainWindow.getInstance().NavigatePage("pay");
			}
		});
		
		listNameLabel.setMinimumSize(new Dimension(100, 100));
		basketPriceLabel.setMinimumSize(new Dimension(100, 100));
		getPayButton.setMinimumSize(new Dimension(100, 100));
		
	
		LayoutExtension.addGridBag(this, listNameLabel, gbl, gbc, 
									0, 0, 1, 1, 1, 0);
		LayoutExtension.addGridBag(this, myListItems, gbl, gbc, 
									0, 1, 1, 1, 1, 1);
		LayoutExtension.addGridBag(this, basketPriceLabel, gbl, gbc,
									0, 2, 1, 1, 1, 0);
		LayoutExtension.addGridBag(this, getPayButton, gbl, gbc,
									0, 3, 1, 1, 1, 0);

		this.setVisible(true);
	}
	
	
}
// Size를 무시하는 레이아웃들이기 때문에 GridBagLayout를 사용하기로 결정함.
// https://thebadprogrammer.com/swing-layout-manager-sizing/
// SpringLayout 참고
// https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
//