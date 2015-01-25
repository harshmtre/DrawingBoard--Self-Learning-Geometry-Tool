import javax.swing.*;
import java.awt.event.*;

public class swingdemo{
  JFrame frame;
  public static void main(String[] args){
  swingdemo db = new swingdemo();
  }

  public swingdemo(){
  frame = new JFrame("Show Message Dialog");
  JButton button = new JButton("Click Me");
  button.addActionListener(new MyAction());
  frame.add(button);
  frame.setSize(400, 400);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public class MyAction implements ActionListener{
  public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog(frame,"Roseindia.net");
  }
  }
}