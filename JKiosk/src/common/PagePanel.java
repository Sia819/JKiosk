package common;

import javax.swing.*;

public abstract class PagePanel extends JPanel
{
	private String DefaultPriviousPagename = "";
	private String DefaultPrecedePagename = "";
	
	public String getDefaultPriviousPagename()
	{
		return DefaultPriviousPagename;
	}
	public void setDefaultPriviousPagename(String pageName)
	{
		DefaultPriviousPagename = pageName;
	}
	
	public String getDefaultPrecedePagename()
	{
		return DefaultPrecedePagename;
	}
	public void setDefaultPrecedePagename(String pageName)
	{
		DefaultPrecedePagename = pageName;
	}
}
