import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.media.j3d.Alpha;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Font3D;
import javax.media.j3d.FontExtrusion;
import javax.media.j3d.Material;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Text3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;

/*
 * Text3DApp renders a single, rotating Text3D Object. The Text3D object has
 * material properties specified along with lights so that the Text3D object is
 * shaded.
 */

public class Text3DApp extends Applet {
	SimpleUniverse simpleU ;
  public BranchGroup createSceneGraph() {
    // Create the root of the branch graph
    BranchGroup objRoot = new BranchGroup();
      Cone cn=new Cone(0.1f,0.5f);

      Transform3D t3D = new Transform3D();
    t3D.setTranslation(new Vector3f(0.0f, 0.0f, -3.0f));
    TransformGroup objMove = new TransformGroup(t3D);
    objRoot.addChild(cn);
    objRoot.addChild(objMove);
    Text2D text2d = new Text2D("2D text in Java 3D", new Color3f(0.9f,
            1.0f, 1.0f), "Helvetica", 24, Font.ITALIC);
  objRoot.addChild(text2d);
    // Create the transform group node and initialize it to the
    // identity. Add it to the root of the subgraph.
//    TransformGroup objSpin = new TransformGroup();
  //  objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    //objMove.addChild(objSpin);

    Appearance textAppear = new Appearance();
    ColoringAttributes textColor = new ColoringAttributes();
    textColor.setColor(1.0f, 0.0f, 0.0f);
    textAppear.setColoringAttributes(textColor);
    textAppear.setMaterial(new Material());

    // Create a simple shape leaf node, add it to the scene graph.
    Font3D font3D = new Font3D(new Font("Helvetica", Font.PLAIN, 1),
        new FontExtrusion());
    Text3D textGeom = new Text3D(font3D, new String("3DText"));
    textGeom.setAlignment(Text3D.ALIGN_CENTER);
    Shape3D textShape = new Shape3D();
    textShape.setGeometry(textGeom);
    textShape.setAppearance(textAppear);
    objMove.addChild(textShape);

    // Create a new Behavior object that will perform the desired
    // operation on the specified transform object and add it into
    // the scene graph.
   // Alpha rotationAlpha = new Alpha(-1, 10000);

    //RotationInterpolator rotator = new RotationInterpolator(rotationAlpha,
      //  objSpin);

    // a bounding sphere specifies a region a behavior is active
    // create a sphere centered at the origin with radius of 100
    BoundingSphere bounds = new BoundingSphere();
    //rotator.setSchedulingBounds(bounds);
    //objSpin.addChild(rotator);

    DirectionalLight lightD = new DirectionalLight();
    lightD.setInfluencingBounds(bounds);
    lightD.setDirection(new Vector3f(0.0f, 0.0f, -1.0f));
    lightD.setColor(new Color3f(1.0f, 0.0f, 1.0f));
    objMove.addChild(lightD);

    AmbientLight lightA = new AmbientLight();
    lightA.setInfluencingBounds(bounds);
    objMove.addChild(lightA);

    return objRoot;
  } // end of CreateSceneGraph method

  public Text3DApp() {
    setLayout(new BorderLayout());
    
    Canvas3D canvas3D = new Canvas3D(simpleU.getPreferredConfiguration());
    canvas3D.setStereoEnable(false);
    add("Center", canvas3D);

    BranchGroup scene = createSceneGraph();

    // SimpleUniverse is a Convenience Utility class
    
    simpleU= new SimpleUniverse(canvas3D);

    // This will move the ViewPlatform back a bit so the
    // objects in the scene can be viewed.
    simpleU.getViewingPlatform().setNominalViewingTransform();

    simpleU.addBranchGraph(scene);
  } // end of Text3DApp (constructor)

  //  The following allows this to be run as an application
  //  as well as an applet

  public static void main(String[] args) {
    System.out
        .println("Text3DApp.java - a demonstration of Text3D in Java 3D");
    System.out.println("The scene is of a rotating Text3D object.");
    System.out.println("The Java 3D Tutorial is available on the web at:");
    System.out.println("http://www.sun.com/desktop/java3d/collateral");
    Frame frame = new MainFrame(new Text3DApp(), 256, 256);
  } // end of main (method of Text3DApp)

} // end of class Text3DApp
