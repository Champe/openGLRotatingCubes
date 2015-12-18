import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Cube extends Object3D{
	private float x;
	private float y;
	private float w;

	private float tx = 0;
	private float ty = 0;
	private float tz = 0;
	
	private float xRotationSpeed;
	private float yRotationSpeed;
	private float zRotationSpeed;
	
	private float transX;
	private float transY;
	private float transZ;
		
	//private float testz = -1f;
	private float testy = 0;
	private float testx = 0;
	
	// translate Orbit	
	private float tOrbX = 0;
	private float tOrbY = 0;	
	private float tOrbZ = 0;	
		

	public Cube(float x, float y, float w, float xRotationSpeed, float yRotationSpeed, float zRotationSpeed, float transX, float transY, float transZ) {		
		this.x = x;
		this.y = y;
		this.w = w;
		this.xRotationSpeed = xRotationSpeed;
		this.yRotationSpeed = yRotationSpeed;
		this.zRotationSpeed = zRotationSpeed;
		this.transX = transX;
		this.transY = transY;
		this.transZ = transZ;
				
	}	


	@Override
	public void render(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();		
		//GLU g = new GLU();
		
		gl.glLoadIdentity();	
		//g.gluLookAt(this.testx,this.testy,-1f,0,0,0,0,0,1);
		
		
		gl.glPushMatrix();
			gl.glTranslatef(this.transX, this.transY, this.transZ);		
		
			// rotation x
			
			gl.glRotatef(this.tx, 1, 0, 0);
			gl.glRotatef(this.ty, 0, 1, 0);
			gl.glRotatef(this.tz, 0, 0, 1);	
						
			gl.glTranslatef(this.tOrbX, this.tOrbY, this.tOrbZ);			
			
			gl.glBegin(GL2.GL_QUADS);
				// Front
				gl.glColor3f(0f, 1f, 1f);
				gl.glVertex3f(+this.x, +this.y, +this.w); 
				gl.glVertex3f(-this.x, +this.y, +this.w);
				gl.glVertex3f(-this.x, -this.y, +this.w);
				gl.glVertex3f(+this.x, -this.y, +this.w);
		
				// Back
				gl.glColor3f(0.5f, 1f, 0.5f);
				gl.glVertex3f(+this.x, +this.y, -this.w);
				gl.glVertex3f(-this.x, +this.y, -this.w);
				gl.glVertex3f(-this.x, -this.y, -this.w);
				gl.glVertex3f(+this.x, -this.y, -this.w);
		
				// Left & Right
				gl.glColor3f(1f, 1f, 0f);
				gl.glVertex3f(+this.x, +this.y, +this.w);
				gl.glVertex3f(+this.x, +this.y, -this.w);
				gl.glVertex3f(+this.x, -this.y, -this.w);
				gl.glVertex3f(+this.x, -this.y, +this.w); 
		
				gl.glColor3f(1f, 0f, 0f);
				gl.glVertex3f(-this.x, +this.y, +this.w);
				gl.glVertex3f(-this.x, +this.y, -this.w);
				gl.glVertex3f(-this.x, -this.y, -this.w);
				gl.glVertex3f(-this.x, -this.y, +this.w); 
		
				// Top & Bottom
				gl.glColor3f(1f, 0f, 1f);
				gl.glVertex3f(-this.x, +this.y, -this.w);
				gl.glVertex3f(+this.x, +this.y, -this.w);
				gl.glVertex3f(+this.x, +this.y, +this.w);
				gl.glVertex3f(-this.x, +this.y, +this.w); 
		
				gl.glColor3f(0f, 0f, 1f);
				gl.glVertex3f(+this.x, -this.y, +this.w);
				gl.glVertex3f(-this.x, -this.y, +this.w);
				gl.glVertex3f(-this.x, -this.y, -this.w);
				gl.glVertex3f(+this.x, -this.y, -this.w);
			gl.glEnd();			
		gl.glPopMatrix();
	}

	@Override
	public void update() {
		this.tx += this.xRotationSpeed;
		this.ty += this.yRotationSpeed;
		this.tz += this.zRotationSpeed;
	}
	
	@Override
	public void change(float x, float y ,float z){		
		this.testx += x;
		this.testy += y;
		//this.testz += 0.1f;		
	}
	
	public void setOrbiting(float tOrbX, float tOrbY, float tOrbZ){
		this.tOrbX = tOrbX;
		this.tOrbY = tOrbY;
		this.tOrbZ = tOrbZ;		
	}
}
