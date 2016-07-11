package andy.core;

import java.io.File;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.ui.swingViewer.DefaultView;
import org.graphstream.ui.swingViewer.Viewer;


public class Drawer {
	// this drawer is implements by graph stream

	private String title;
	private boolean isDirected;
	private String outputLocation;
	private Graph graph;
	private Viewer viewer;
	private DefaultView view;

	/*
	 * some constants
	 */
	// normalized level
	final private int DIFFSIZE = 10;
	final private int BASICSIZE = 10;
	final private int BASICTHICKNESS = 1;
	final private int DIFFTHICKNESS = 5;
	String[] DEFAULTCOLOR = { "white", "blue", "red", "green", "yellow",
			"black" };
	String[] DEFAULTPOINTSHAPE = { "box", "circle", "rounded-box", "diamond",
			"cross" };
	String[] DEFAULTLINKSHAPE = { "angle", "line", "cubic-curve", "blob",
			"freeplane" };
	String DEFAULTPOINTSIZE = "10px";
	String DEFAULTNODESTYLE = "node {size-mode: dyn-size; fill-mode:dyn-plain;text-offset: 10px,-10px; text-size:12px;}";
	String DEFAULTNODECLICK = "node:clicked{fill-color:red; text-mode:normal;text-offset:10px,-10px; text-size:18px;}";

	String DEFAULTLINKSTYLE = "edge {size-mode: dyn-size;text-size:12px;}";

	public void addPoint(String pointid) {
		// TODO Auto-generated method stub
		// System.out.println(pointid);
		graph.addNode(pointid);
	}

	public void setPointColor(String pointid, String color) {
		// TODO Auto-generated method stub

		// System.out.println(color);
		int index = Integer.parseInt(color);
		Node node = graph.getNode(pointid);
		if (index == 0) {
			// the link is set to invisible
			String command = "visibility-mode:" + "hidden" + ";";
			node.addAttribute("ui.style", command);
		} else {
			String command = "visibility-mode:" + "normal" + ";";
			node.addAttribute("ui.style", command);
		}
		String command = "fill-color:" + this.DEFAULTCOLOR[index] + ";";
		node.addAttribute("ui.style", command);
		// node.addAttribute("ui.color", color[index]);
		// node.addAttribute("ui.color", 0);

	}

	public void setPointSize(String pointid, float normalizedSize) {
		// TODO Auto-generated method stub
		Node node = graph.getNode(pointid);
		if (normalizedSize < 0) {
			node.addAttribute("ui.size", this.DEFAULTPOINTSIZE);
		} else {
			int realSize = this.BASICSIZE
					+ (int) ((normalizedSize) * this.DIFFSIZE);
			node.addAttribute("ui.size", realSize);
		}
	}

	public void setPointSize(String pointid, String size) {
		// TODO Auto-generated method stub
		Node node = graph.getNode(pointid);
		node.addAttribute("ui.size", size);
	}

	public void setPointPosition(String pointid, float x, float y) {
		// TODO Auto-generated method stub
		if ((x == 0f) && (y == 0f)) {
			// System.out.println("Error");
			return;
		}
		Node node = graph.getNode(pointid);
		node.setAttribute("x", x);
		node.setAttribute("y", y);
	}

	public void setPointPosition(String pointid, float x, float y, float z) {
		// TODO Auto-generated method stub
		Node node = graph.getNode(pointid);
		node.setAttribute("x", x);
		node.setAttribute("y", y);
		node.setAttribute("z", z);
	}

	public void setPointComment(String pointid, String comment) {
		// TODO Auto-generated method stub
		Node node = graph.getNode(pointid);
		node.setAttribute("ui.label", comment);
	}

	public void setPointName(String pointid, String name) {
		// TODO Auto-generated method stub
		Node node = graph.getNode(pointid);
		node.setAttribute("ui.label", name);

	}

	public void addLink(String pointXid, String pointYid, String linkid) {
		// TODO Auto-generated method stub
		// System.out.printf("%s %s\n", pointXid, pointYid);
		graph.addEdge(linkid, pointXid, pointYid, this.isDirected);
	}

	public void setLinkShape(String linkid, String shape) {
		// TODO Auto-generated method stub
		Edge edge = graph.getEdge(linkid);
		int index = Integer.parseInt(shape);
		String command = "shape:" + this.DEFAULTLINKSHAPE[index] + ";";
		edge.setAttribute("ui.style", command);
	}

	public void setLinkColor(String linkid, String color) {
		// TODO Auto-generated method stub
		int index = Integer.parseInt(color);
		Edge edge = graph.getEdge(linkid);
		String command;
		command = "fill-color:" + this.DEFAULTCOLOR[index] + ";";
		// edge.addAttribute("ui.style", command);
		if (index == 0) {
			// the link is set to invisible
			command = command + "visibility-mode:" + "hidden" + ";";
		} else {
			command = command + "visibility-mode:" + "normal" + ";";
		}
		edge.addAttribute("ui.style", command);
		// for testing
		// System.out.println(edge.getAttribute("ui.style").toString());
	}

	public void setLinkLength(String linkid, float normalizedLength) {
		// TODO Auto-generated method stub
		Edge edge = graph.getEdge(linkid);
		// int realLength = this.BASICTHICKNESS
		// + (int) ((normalizedLength) * this.DIFFTHICKNESS);
		edge.addAttribute("layout.weight", normalizedLength + 0.2);
	}

	public void setLinkThickness(String linkid, float normalizedThickness) {
		// TODO Auto-generated method stub
		Edge edge = graph.getEdge(linkid);
		int realThickness = this.BASICTHICKNESS
				+ (int) ((normalizedThickness) * this.DIFFTHICKNESS);
		edge.addAttribute("ui.size", realThickness);

	}

	public void setLinkName(String linkid, String name) {
		// TODO Auto-generated method stub
		Edge edge = graph.getEdge(linkid);
		edge.setAttribute("ui.label", name);
	}

	public void setLinkComment(String linkid, String comment) {
		// TODO Auto-generated method stub
		Edge edge = graph.getEdge(linkid);
		edge.setAttribute("ui.label", comment);
	}

	public void initialize(String title, boolean isDirected,
			boolean isAutoLayout, String outputLocation) {
		// TODO Auto-generated method stub
		// System.setProperty("gs.ui.renderer",
		// "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		// System.setProperty("org.graphstream.ui.renderer",
		// "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		this.title = title;
		this.isDirected = isDirected;
		this.outputLocation = outputLocation;
		this.graph = new DefaultGraph(title);
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");
		String nodeStyle = this.DEFAULTNODESTYLE + this.DEFAULTNODECLICK;
		String linkStyle = this.DEFAULTLINKSTYLE;
		graph.addAttribute("ui.stylesheet", nodeStyle + linkStyle);
		// change for testing
	}

	public void setView(DefaultView view) {
		this.view = view;
	}

	public DefaultView getView() {
		return view;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setPointShape(String pointid, String shape) {
		// TODO Auto-generated method stub

		Node node = graph.getNode(pointid);
		int index = Integer.parseInt(shape);
		String command = "shape:" + this.DEFAULTPOINTSHAPE[index] + ";";
		node.addAttribute("ui.style", command);
	}

	public void saveFile(int n) {
		// TODO Auto-generated method stub
		// the n th figure
		String filename = "";
		filename = this.outputLocation + this.title + "_" + String.valueOf(n)
				+ ".png";
		System.out.println(filename);
		boolean success = (new File(filename)).delete();
		graph.setAttribute("ui.screenshot", filename);
		// this.sleep(1200);

	}

	public void sleep(int t) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(t);
		} catch (Exception e) {
		}

	}

	public void focusNode(String nodeID, float percentage) {
		Node node = graph.getNode(nodeID);
		if (node == null) {
			return;
		}
		// double pos[] = nodePosition(node);
		// view.getCamera().setAutoFitView(true);
		// view.getCamera().setViewCenter(pos[0], pos[1], pos[2]);
		// System.out.printf("%f %f %f", pos[0], pos[1], pos[2]);
		view.getCamera().setViewPercent(percentage);
		// System.out.println(pos.length);
		this.setPointSize(nodeID, "10px");
		this.setPointColor(nodeID, "2");
		// view.getCamera().setViewPercent(0.25);
	}

	public double[] getNodePosition(String nodeID) {
		Node node = graph.getNode(nodeID);
		if (node == null) {
			return null;
		}
		double pos[] = null;
		// nodePosition(node);
		return pos;
	}

	public void hideComment() {
		String command = "node {text-mode:hidden;}";
		graph.addAttribute("ui.stylesheet", command);
	}

	public boolean isCommentVisible(String nodeID) {

		return false;
	}

	public void controlNodeComment(String nodeID) {
		Node node = graph.getNode(nodeID);
		if (node == null) {
			return;
		} else {
			// System.out.println(graph.getNode(nodeID).getAttribute("ui.style"));
			String temp = graph.getNode(nodeID).getAttribute("ui.style");
			if (temp.contains("text-mode:normal;")) {
				graph.getNode(nodeID).addAttribute("ui.style",
						"text-mode:hidden;");
			} else {
				graph.getNode(nodeID).addAttribute("ui.style",
						"text-mode:normal;");
			}
		}
	}

	public void showComment() {
		String command = "node {text-mode:normal;}";
		graph.addAttribute("ui.stylesheet", command);
	}

	public void disableAutolayout() {
		viewer.disableAutoLayout();
	}

	public void enableAutolayout() {
		viewer.enableAutoLayout();
	}
}
