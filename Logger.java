import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Logger extends JFrame implements ActionListener,Runnable {

  JButton b1,b2;
  JPanel p1;
  Thread th1;
  int i=0;
  
  public Logger()
  {
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(100,100);
    b1 = new JButton("Start");
    b2 = new JButton("Stop");
    p1 = new JPanel();
    p1.add(b1);
    p1.add(b2);
    this.add(p1);
    b1.addActionListener(this);
    b2.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
    {
      th1 = new Thread(this);
      th1.start();
    }else
    {
      th1.stop();
    }
  }
  
  public void run()
  {
    for(;;)
    {
      try {
      Robot r = new Robot();
      BufferedImage img = 
      r.createScreenCapture(
          new Rectangle(
              getToolkit().getScreenSize()));
      ImageIO.write(img,"jpg" , new File("d:\\rec\\"+i+".jpg"));
      i++;
      th1.sleep(300);
      
      }
      catch(Exception e)
      {
        
      }
    }
  }
  
  
  public static void main(String args[])
  {
    new Logger();
  }
}