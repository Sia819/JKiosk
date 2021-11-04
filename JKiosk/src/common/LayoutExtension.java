package common;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class LayoutExtension 
{
	public static void addGridBag(Container parentContainer, Component childContainer, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints, 
            int row, int column, int rowSpan, int columnSpan, int columnDefinition, int rowDefinition) 
	{
		gridBagConstraints.gridx = row;
		gridBagConstraints.gridy = column;
		gridBagConstraints.gridwidth = rowSpan;
		gridBagConstraints.gridheight = columnSpan;
		gridBagConstraints.weightx = columnDefinition;
		gridBagConstraints.weighty = rowDefinition;
		gridBagLayout.setConstraints(childContainer, gridBagConstraints);
		// parentContainer 로 JFrame이 오면 JFrame에 있는 add를,
		// JPanel이 오면 JPanel에 있는 add를 호출함.
		parentContainer.add(childContainer);   
	}
}
