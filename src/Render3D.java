import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Render3D implements GLEventListener, KeyListener{

	private float tx;

	ArrayList<Object3D> objectList = new ArrayList<>();

	@Override
	public void display(GLAutoDrawable drawable) {		
		update();
		render(drawable);		
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {


	}

	@Override
	public void init(GLAutoDrawable drawable) {	
		GL2 gl = drawable.getGL().getGL2();
		GLU g = new GLU();

		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		

		

		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);		

		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) { 
		GL2 gl = drawable.getGL().getGL2();

		gl.glViewport(x, y, w, h);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();


	}

	public void update(){
		for (int i = 0; i < objectList.size();i++){
			objectList.get(i).update();
		}
	}

	public void render(GLAutoDrawable drawable){
		GL2 gl = drawable.getGL().getGL2();
		GLU g = new GLU();

		gl.glLoadIdentity();					
		/*
		gl.glPushMatrix();						
		// rotation x
		gl.glRotatef(this.tx, 1, 0, 0);			
		gl.glPopMatrix();
		 */


		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);			

		for (int i = 0; i < objectList.size();i++){
			objectList.get(i).render(drawable);			
		}		

		gl.glPushMatrix();
		gl.glRotatef(10, 1, 0, 0);			
		gl.glPopMatrix();
	}

	public void addObj(Object3D obj){
		objectList.add(obj);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int xc = 0;
		int yc = 0;
		int zc = 0;


		int keyPressed = e.getKeyCode();		
		switch (keyPressed){
		case 37://Left
			xc = -1;			
			break;
		case 38://up
			yc = 1;
			break;
		case 39://right
			xc = 1;
			break;
		case 40://down
			yc = -1;
			break;
		default:
			break;					
		}		

		for (int i = 0; i < objectList.size();i++){
			objectList.get(i).change((float) (0.1 * xc), (float) (0.1 * yc), zc);			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {		

	}

}
