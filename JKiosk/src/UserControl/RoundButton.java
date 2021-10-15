package UserControl;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

// https://www.javacodex.com/More-Examples/2/14
public class RoundButton extends JButton {
 
  public RoundButton(String label) {
    super(label);
 
    setBackground(Color.lightGray);
    setFocusable(false);
 
    /*
     These statements enlarge the button so that it 
     becomes a circle rather than an oval.
    */
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, size.height);
    setPreferredSize(size);
 
    /*
     This call causes the JButton not to paint the background.
     This allows us to paint a round background.
    */
    setContentAreaFilled(false);
  }
 
  protected void paintComponent(Graphics2D graphics) {
	  
	//graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	//graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    
    if (getModel().isArmed()) {
    	graphics.setColor(Color.gray);
    } else {
    	graphics.setColor(getBackground());
    }
    Ellipse2D.Double hole = new Ellipse2D.Double();
    hole.x = 0;
    hole.y = 0;
    hole.width = getSize().width - 1;
    hole.height = getSize().height - 1;
    graphics.draw(hole);
    // graphics.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
 
    super.paintComponent(graphics);
  }
 
  protected void paintBorder(Graphics g) {
    g.setColor(Color.darkGray);
    g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
  }
 
  // Hit detection.
  Shape shape;
 
  public boolean contains(int x, int y) {
    // If the button has changed size,  make a new shape object.
    if (shape == null || !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
 

}
