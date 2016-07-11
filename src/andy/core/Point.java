package andy.core;

import java.util.Set;

public class Point {

	private String id; // The id of this point
	private String shape; // different shape.
	private String color; //  different color (0 for hidden)
	private float size; // The size of the Point
	private String name;// The name of this point
	private String comment;// Explanation of this point
	private float x, y, z; // The location of this Point
	private Set<String> tag;// Set of tag

	// whether the parameters are enabled
	public Point(String id, String shape, String color, float size,
			String name, String comment, float x, float y, float z) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.size = size;
		this.name = name;
		this.comment = comment;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point(String id) {
		this.id = id;
		// when the point info is not given
	}
	public void setPoint(String id, String shape, String color, float size,
			String name, String comment, float x, float y, float z) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.size = size;
		this.name = name;
		this.comment = comment;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/*
	 * public Point(String[] parameterList, int[] shapeOfParList) { //
	 * enablelist[i]=j means the parameter[i] stands for the j th parameter //
	 * in the list // so far total 9 parameter support this.enableList = new
	 * boolean[9]; for (int i = 0; i < 8; i++) { this.enableList[i] = false; }
	 * for (int i = 0; i < shapeOfParList.length; i++) {
	 * this.enableList[shapeOfParList[i]] = true; } for (int j = 0; j <
	 * shapeOfParList.length; j++) { int i = shapeOfParList[j]; switch (i) { case
	 * 0: // point id break; case 1: // shape this.setShape(parameterList[i]);
	 * break; case 2: // color this.setColor(parameterList[i]); break; case 3:
	 * // size this.setSize(Float.parseFloat(parameterList[i])); break; case 4:
	 * this.setName(parameterList[i]); break; case 5:
	 * this.setComment(parameterList[i]); break; case 6:
	 * this.setX(Float.parseFloat(parameterList[i])); break; case 7:
	 * this.setY(Float.parseFloat(parameterList[i])); break; case 8:
	 * this.setZ(Float.parseFloat(parameterList[i])); break; case 9: // tag //
	 * to be completed } }
	 * 
	 * }
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
