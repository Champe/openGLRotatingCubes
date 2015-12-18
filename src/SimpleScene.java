import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.print.CancelablePrintJob;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;

public class SimpleScene {
	public static void main(String[] args) {
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);
		GLCanvas canvas = new GLCanvas(caps);
		
		Render3D render3D = new Render3D();

		Frame frame = new Frame("AWT Window Test");
		frame.setSize(500, 500);
		frame.add(canvas);
		frame.setVisible(true);
		
		//canvas.addKeyListener(render3D);
		

		// by default, an AWT Frame doesn't do anything when you click
		// the close button; this bit of code will terminate the program when
		// the window is asked to close
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		
		Cube cube1 = new Cube(.1f, .1f ,.1f, 5f, 0, 0, 0, 0, 0);
		Cube cube2 = new Cube(.1f, .1f ,.1f, 3, 0, 0, 0, 0, 0);
		Cube cube3 = new Cube(.1f, .1f ,.1f, 0, 5, 0, 0, 0, 0);
		Cube cube4 = new Cube(.1f, .1f ,.1f, 3, 3, 3, 0, 0, 0);
		Cube cube5 = new Cube(.07f, .07f ,.07f, 1, 1, 0, 0, 0, 0);
		Cube cube6 = new Cube(.07f, .07f ,.07f, -5, -3, 0, 0, 0, 0);
				
		cube2.setOrbiting(0, .6f, 0);
		cube3.setOrbiting(.5f, 0, 0);
		cube4.setOrbiting(.8f, .8f, 0);
		cube5.setOrbiting(-.7f, -.7f, 0);
		cube6.setOrbiting(-.6f, -.3f, 0);
		
		render3D.addObj(cube1);		
		render3D.addObj(cube2);
		render3D.addObj(cube3);
		render3D.addObj(cube4);	
		render3D.addObj(cube5);	
		

		canvas.addGLEventListener(render3D);

		FPSAnimator animator = new FPSAnimator(canvas, 60);
		animator.start();

	}
}