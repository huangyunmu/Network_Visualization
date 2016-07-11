package andy.core;

import java.util.Set;

public class Link {
	private String pointXid;
	private String pointYid;
	private String shape; // different shape.
	private String color; // different color (0 for hidden)
	private float thickness; // The thickness of the link
	private float length; // the length of the link
	private String linkid;// the id of the link
	private String name;// The name of this link
	private String comment;// Explanation of this link
	private Set<String> tag;// Set of tag

	public Link(String pointXid, String pointYid, String shape, String color,
			float thickness, float length, String linkid, String name,
			String comment) {
		this.pointXid = pointXid;
		this.pointYid = pointYid;
		this.color = color;
		this.shape = shape;
		this.thickness = thickness;
		this.length = length;
		this.linkid = linkid;
		this.name = name;
		this.comment = comment;
	}

	public void setLink(String pointXid, String pointYid, String shape,
			String color, float thickness, float length, String linkid,
			String name, String comment) {
		this.pointXid = pointXid;
		this.pointYid = pointYid;
		this.color = color;
		this.shape = shape;
		this.thickness = thickness;
		this.length = length;
		this.linkid = linkid;
		this.name = name;
		this.comment = comment;

	}

	public String getPointXid() {
		return pointXid;
	}

	public void setPointXid(String pointXid) {
		this.pointXid = pointXid;
	}

	public String getPointYid() {
		return pointYid;
	}

	public void setPointYid(String pointYid) {
		this.pointYid = pointYid;
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

	public float getThickness() {
		return thickness;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
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
