import javax.swing.*;
public class Viewer extends JFrame implements Runnable{
JLabel L1;
int i=0;
Thread th1;
  public Viewer()
  {
    this.setVisible(true);
    this.setSize(400,400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    L1 = new JLabel();
    th1 = new Thread(this);
    th1.start();
    this.add(L1);
  }
  public void run()
  {
    for(;;)
    {
      try
      {
        ImageIcon ico = new ImageIcon ("d:\\rec\\"+i+".jpg");
        L1.setIcon(ico);
        i++;
        th1.sleep(300);
      }
      catch(Exception ex)
      {
        
      }
    }
  }
  public static void main(String args[])
  {
    new Viewer();
  }
}