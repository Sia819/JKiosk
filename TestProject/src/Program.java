import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;


public class Program extends JFrame 
{
	/*
	public Program()
	{
		this.setTitle("JKiosk");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		this.setVisible(true);
	}
	*/
	
	private int tool = 1;
    int currentX, currentY, oldX, oldY;

    public Program() {
        initComponents();
    }

    private void initComponents() {
        // we want a custom Panel2, not a generic JPanel!
        jPanel2 = new Panel2();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });

        // add the component to the frame to see it!
        this.setContentPane(jPanel2);
        // be nice to testers..
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }// </editor-fold>

    private void jPanel2MouseDragged(MouseEvent evt) {
        if (tool == 1) {
            currentX = evt.getX();
            currentY = evt.getY();
            oldX = currentX;
            oldY = currentY;
            System.out.println(currentX + " " + currentY);
            System.out.println("PEN!!!!");
        }
    }

    private void jPanel2MousePressed(MouseEvent evt) {
        oldX = evt.getX();
        oldY = evt.getY();
        System.out.println(oldX + " " + oldY);
    }


    //mouse released//
    private void jPanel2MouseReleased(MouseEvent evt) {
        if (tool == 2) {
            currentX = evt.getX();
            currentY = evt.getY();
            System.out.println("line!!!! from" + oldX + "to" + currentX);
        }
    }

    

    // Variables declaration - do not modify
    private JPanel jPanel2;
    // End of variables declaration

    // This class name is very confusing, since it is also used as the
    // name of an attribute!
    //class jPanel2 extends JPanel {
    class Panel2 extends JPanel {

        Panel2() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(420,420));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawString("BLAH", 20, 20);
            g.drawRect(200, 200, 200, 200);
        }
    }
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Hello");
		Program p =new Program();
		p.setVisible(true);
		
		
	}

}


/*


 * from java.lang import *
from java.io import *
from java.awt import *
from java.awt.geom import *
from java.awt.image import *
from javax.imageio import *

bim = BufferedImage(30, 42, BufferedImage.TYPE_INT_ARGB)
g = bim.createGraphics()
g.fillRect(0, 0, 100, 100)
g.setColor(Color.BLACK)
for i in range(5):
    g.draw(Ellipse2D.Double(2+0.2*i, 2+8.2*i, 5, 5))

g.setRenderingHint( RenderingHints.  KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON)

for i in range(5):
    g.draw(Ellipse2D.Double(12+0.2*i, 2+8.2*i, 5, 5))

g.setRenderingHint( RenderingHints.  KEY_STROKE_CONTROL,
                    RenderingHints.VALUE_STROKE_PURE)

for i in range(5):
    g.draw(Ellipse2D.Double(22+0.2*i, 2+8.2*i, 5, 5))

#You'll probably want this too later on:
#g.setRenderingHint( RenderingHints.  KEY_INTERPOLATION,
#                    RenderingHints.VALUE_INTERPOLATION_BICUBIC)
#g.setRenderingHint( RenderingHints.  KEY_RENDERING, 
#                    RenderingHints.VALUE_RENDER_QUALITY)

ImageIO.write(bim, "PNG", File("test.png"))



*/
 