import java.awt.*; 
import java.applet.*; 
// These classes are for Url's. 
import java.net.*;

public class demo extends Applet 
{ 
 // Your image name; 
     Image my_gif;

 // The applet base URL 
     URL base;

 // This object will allow you to control loading 
     MediaTracker mt;

     public void init()  
     {

  // initialize the MediaTracker 
          mt = new MediaTracker(this);

  // The try-catch is necassary when the URL isn't valid 
  // Ofcourse this one is valid, since it is generated by 
  // Java itself.

         try { 
   // getDocumentbase gets the applet path. 
               base = getDocumentBase(); 
         } 
         catch (Exception e) {}

  // Here we load the image. 
  // Only Gif and JPG are allowed. Transparant gif also. 
          my_gif = getImage(base,"background.JPG");

  // tell the MediaTracker to kep an eye on this image, and give it ID 1; 
          mt.addImage(my_gif,1);

  // now tell the mediaTracker to stop the applet execution 
  // (in this example don't paint) until the images are fully loaded. 
  // must be in a try catch block.

         try { 
               mt.waitForAll(); 
          } 
          catch (InterruptedException  e) {}

  // when the applet gets here then the images is loaded.

     }

     public void paint(Graphics g)  
     { 
  // now we are going to draw the gif on the screen 
  // (image name,x,y,observer);

          //g.drawImage(my_gif,20,20,this);

  // you can resize the image easily

          g.drawImage(my_gif,0,0,1200,1000,this); 
 

     }

}