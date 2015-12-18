import javax.media.opengl.GLAutoDrawable;

public abstract class Object3D {

	public abstract void update();

	public abstract void render(GLAutoDrawable drawable); 	

	public abstract void change(float x, float y, float z);
}
