import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.MediaTracker; 
import java.awt.Toolkit; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 

public class JFrameExample extends JFrame 
{     
    JFrameExample() 
    {         
        setContentPane(new ContentPanel("background.jpg")); 
        setTitle("JR example : JFrame with background image."); 
        setSize(500,300); 
    } 
         
    public static void main(String[] args) 
    { 
        JFrameExample jrframe = new JFrameExample();         
        jrframe.setVisible(true); 
    } 
     
     
    class ContentPanel extends JPanel 
    {         
        Image bgimage = null; 
         
        ContentPanel(String imagename) 
        {             
            if(imagename != null) 
            {             
                MediaTracker mt = new MediaTracker(this);                 
                bgimage = Toolkit.getDefaultToolkit().getImage(imagename); 
                mt.addImage(bgimage, 0); 
                try 
                { 
                    mt.waitForAll(); 
                } 
                catch (InterruptedException e) 
                { 
                    e.printStackTrace(); 
                }                 
            } 
        }         
         
        protected void paintComponent(Graphics g) 
        { 
            super.paintComponent(g); 
         
            if(bgimage != null) 
            { 
                int imwidth = bgimage.getWidth(null); 
                int imheight = bgimage.getHeight(null); 
                 
                if((imwidth > 0) && (imheight > 0)) 
                {                 
                    for(int y = 0; y<getHeight(); y+=imheight) 
                    { 
                        for(int x = 0; x<getWidth(); x+=imwidth) 
                        {                     
                            g.drawImage(bgimage, x, y, null); 
                        } 
                    } 
                } 
            }             
        } 

    }         
}