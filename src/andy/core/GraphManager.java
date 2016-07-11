package andy.core;

import java.io.File;
import java.io.IOException;

public class GraphManager {
	private GraphData graphdata;
	private Drawer drawer;

	private String title;
	private boolean isDirected;
	// whether the link is directed
	private boolean isMultiple;
	// whether need to draw multiple picture
	private boolean isNormalized;
	// whether the input is normalized
	private boolean hasPointInfo;
	// whether the point info is provided
	private boolean isAutoLayout;
	// whether the network should be auto layout
	private int numOfMulGraph = 0;
	private int count = 0;

	private int[] usedPointVarList;
	private int[] usedLinkVarList;

	private final String DEFAULTPOINTFILENAME = "Node_0.txt";
	private final String DEFAULTLINKFILENAME = "Link_0.txt";

	public GraphManager(int[] usedPointVarList, int[] usedLinkVarList,
			boolean[] statusVarList, String charSet, String title) {
		/*
		 * the inputs would be obtained from the GUI For link(usedLinkVarList)
		 * 0:pointXid 1:pointYid 2:shape 3:color 4:thickness 5:length 6:linkid
		 * 7:linkName 8:comment 10:tag For point(usedPointVarList) 0:pointid
		 * 1:shape 2:color 3:size 4:name 5:comment 678:xyz 9:tag
		 */
		// this setting may be changed in the future
		// boolean[] statusVarList= new boolean[4];
		// statusVarList[0]=isNormalized;
		// statusVarList[1]=isMultiple;
		// statusVarList[2]=isDirected;
		// statusVarList[3]=isAutoLayout;
		this.isNormalized = statusVarList[0];
		this.isMultiple = statusVarList[1];
		this.isDirected = statusVarList[2];
		this.isAutoLayout = statusVarList[3];
		this.title = title;
		this.usedLinkVarList = usedLinkVarList;
		this.usedPointVarList = usedPointVarList;
		graphdata = new GraphData(usedPointVarList, usedLinkVarList, charSet);
		drawer = new Drawer();
	}

	public int[] getUsedPointVarList() {
		return usedPointVarList;
	}

	public String getPointID(int index) {
		// get the point ID of the given index
		return this.graphdata.getPointID(index);
	}

	public void demo() {
		// specifal function
		// set the first node to red
		this.graphdata.demo();
		String pointid = this.getPointID(1);
		this.drawer.setPointColor(pointid, "2");
	}

	public void setUsedPointVarList(int[] usedPointVarList) {
		this.usedPointVarList = usedPointVarList;
	}

	public int[] getUsedLinkVarList() {
		return usedLinkVarList;
	}

	public void setUsedLinkVarList(int[] usedLinkVarList) {
		this.usedLinkVarList = usedLinkVarList;
	}

	public boolean isHasPointInfo() {
		return hasPointInfo;
	}

	public void setHasPointInfo(boolean hasPointInfo) {
		this.hasPointInfo = hasPointInfo;
	}

	public int getNumOfMulGraph() {
		return numOfMulGraph;
	}

	public void setNumOfMulGraph(int numOfMulGraph) {
		this.numOfMulGraph = numOfMulGraph;
	}

	public boolean controlPre(String linkDataFilename,
			String pointDataFilename, String outputLocation) throws IOException {
		// before call datainput control
		// for the purpose of polymorphism
		// there are both info for data and link
		this.hasPointInfo = true;
		return control(linkDataFilename, pointDataFilename, outputLocation);
	}

	public boolean controlPre(String linkDataFilename, String outputLocation)
			throws IOException {
		// before call datainput control
		// for the purpose of polymorphism
		// only info of link
		String pointDataFilename = "No data";
		this.hasPointInfo = false;
		return control(linkDataFilename, pointDataFilename, outputLocation);

	}

	public boolean control(String linkDataFilename, String pointDataFilename,
			String outputLocation) throws IOException {

		int result1 = this.checkFilename(linkDataFilename, 0, 1);
		int result2 = this.checkFilename(pointDataFilename, 0, 2);

		if ((result1 == 0) && (result2 == 0)) {
			// this is a single graph
			// the file exist
			this.graphdata.linkDataInput(linkDataFilename, true);
			if (hasPointInfo == true) {
				this.graphdata.pointDataInput(pointDataFilename, true);
			} else {
				// if not point info, the program would find point by the
				// link
				this.graphdata.findPointByLink();
			}
			if (this.isNormalized == false) {
				this.normalizationControl(linkDataFilename, pointDataFilename);
			}
			// if (this.isNormalized == false) {
			// this.graphdata.computeRange();
			// }
			this.drawer.initialize(title, isDirected, isAutoLayout,
					outputLocation);
			this.drawGraph(this.title, this.isDirected, outputLocation, 0);
			// for single graph, the operation is complete
			// for multiple graph, other procedures would be done in multiple
			// control
			return true;
		} else {
			// the input file name is not correct
			System.out.println(result1);
			System.out.println(result2);
			return false;
		}

	}

	public void normalizationControl(String linkDataFilename,
			String pointDataFilename) throws IOException {
		if (isMultiple == false) {
			// single graph
			// for single graph all data is already stored in the graph data
			this.graphdata.computeRange();
		} else {
			// multiple graph
			// all data need to be read
			// meanwhile detect how many graph data file exist
			int result1, result2;
			String pathPoint = "", pathLink = "";
			pathLink = linkDataFilename.substring(0, linkDataFilename.length()
					- this.DEFAULTLINKFILENAME.length());

			if (this.hasPointInfo) {
				pathPoint = pointDataFilename.substring(
						0,
						pointDataFilename.length()
								- this.DEFAULTPOINTFILENAME.length());
			}
			String currentLinkDataName, currentPointDataName;
			int count = 1;
			// read the data file from 1
			currentLinkDataName = pathLink + "Link_" + String.valueOf(count)
					+ ".txt";
			currentPointDataName = pathPoint + "Node_" + String.valueOf(count)
					+ ".txt";
			result1 = this.checkFilename(currentLinkDataName, count, 1);
			result2 = this.checkFilename(currentPointDataName, count, 2);
			while (result1 == 0 && result2 == 0) {
				this.graphdata.linkDataInput(currentLinkDataName, false);
				if (hasPointInfo == true) {
					this.graphdata.pointDataInput(currentPointDataName, false);
				}
				this.graphdata.computeRange();
				// check next file
				count++;
				currentLinkDataName = pathLink + "Link_"
						+ String.valueOf(count) + ".txt";
				currentPointDataName = pathPoint + "Node_"
						+ String.valueOf(count) + ".txt";
				result1 = this.checkFilename(currentLinkDataName, count, 1);
				result2 = this.checkFilename(currentPointDataName, count, 2);
			}
			this.numOfMulGraph = count;
			// after complete the normalization, read the first data again
			currentLinkDataName = pathLink + "Link_" + String.valueOf(0)
					+ ".txt";
			currentPointDataName = pathPoint + "Node_" + String.valueOf(0)
					+ ".txt";
			result1 = this.checkFilename(currentLinkDataName, 0, 1);
			result2 = this.checkFilename(currentPointDataName, 0, 2);
			if(result1 == 0 && result2 == 0){
				this.graphdata.linkDataInput(currentLinkDataName, false);
				if (hasPointInfo == true) {
					this.graphdata.pointDataInput(currentPointDataName, false);
				}
				
			}	
			else{
				System.out.println("error");
			}
		}

	}

	// public void singleControl(String linkDataFilename,
	// String pointDataFilename, String outputLocation) throws IOException {
	// int result1 = this.checkFilename(linkDataFilename, 0, 1);
	// int result2 = this.checkFilename(pointDataFilename, 0, 2);
	//
	// if ((result1 == 0) && (result2 == 0)) {
	// // this is a single graph
	// // the file exist
	// this.graphdata.linkDataInput(linkDataFilename, true);
	// if (hasPointInfo == true) {
	// this.graphdata.pointDataInput(pointDataFilename, true);
	// } else {
	// // if not point info, the program would find point by the
	// // link
	// this.graphdata.findPointByLink();
	// }
	// if (this.isNormalized == false) {
	// this.graphdata.computeRange();
	// }
	// this.drawer.initialize(title, isDirected, isAutoLayout,
	// outputLocation);
	// this.drawGraph(this.title, this.isDirected, outputLocation, 0);
	// } else {
	// // the input file name is not correct
	// System.out.println(result1);
	// System.out.println(result2);
	// }
	// }

	public boolean multipleControl(String linkDataFilename,
			String pointDataFilename, String outputLocation, int N)
			throws IOException {
		if (this.isMultiple == false) {
			return false;
		}
		if (N == 0) {
			this.drawer.saveFile(0);
			return true;
		}
		// this is a multiple graph

		// for multiple graph, the first graph will be allowed to make some
		// change
		// other graphs will follow the setting and change made in first graph

		// prepare the path
		String pathPoint = "", pathLink = "";
		pathLink = linkDataFilename.substring(0, linkDataFilename.length()
				- this.DEFAULTLINKFILENAME.length());

		if (this.hasPointInfo) {
			pathPoint = pointDataFilename.substring(
					0,
					pointDataFilename.length()
							- this.DEFAULTPOINTFILENAME.length());
		}

		// draw picture
		int count = N;
		int result1, result2;
		String currentLinkDataName, currentPointDataName;
		currentLinkDataName = pathLink + "Link_" + String.valueOf(count)
				+ ".txt";
		currentPointDataName = pathPoint + "Node_" + String.valueOf(count)
				+ ".txt";
		result1 = this.checkFilename(currentLinkDataName, count, 1);
		result2 = this.checkFilename(currentPointDataName, count, 2);

		if (result1 == 0 && result2 == 0) {
			this.graphdata.linkDataInput(currentLinkDataName, false);
			if (hasPointInfo == true) {
				this.graphdata.pointDataInput(currentPointDataName, false);
				// } else {
				// this.graphdata.findPointByLink();
			}
			// if (count == 0) {
			// this.drawer.initialize(title, isDirected, isAutoLayout,
			// outputLocation);
			// }
			this.drawGraph(this.title, this.isDirected, outputLocation, count);

		} else {
			return false;
		}
		// if the graph is complete, true will be return and wait for the
		// calling in the GUI
		return true;

	}

	public int checkFilename(String dataFilename, int n, int status) {
		/*
		 * whether this file exist datafile name: name of input file n the n th
		 * input shape 1 for link shape 2 for point return 0 correct 1 invalid
		 * filename 2 file not found
		 */
		String standardFilename;
		if (status == 1) {
			// it is link
			standardFilename = "Link_";
		} else {
			standardFilename = "Node_";
			if (this.hasPointInfo == false) {
				// if it don't have point info
				return 0;
			}
		}
		standardFilename = standardFilename + String.valueOf(n) + ".txt";
		// for testing
		// System.out.println(standardFilename);
		int l1 = standardFilename.length();
		int l2 = dataFilename.length();
		if (dataFilename.substring(l2 - l1, l2).equals(standardFilename) == false) {
			// Invalid name
			return 1;
		}
		File file = new File(dataFilename);
		if (file.exists()) {
			// file exist
			return 0;
		} else {
			// file doesn't exist
			return 2;
		}

	}

	/*
	 * public boolean checkFilename(String linkDataFilename, String
	 * pointDataFilename) { // check whether the input file name is valid String
	 * temp; int l; l = linkDataFilename.length(); int l1 =
	 * this.DEFAULTLINKFILENAME.length(); int l2 =
	 * this.DEFAULTPOINTFILENAME.length(); temp = linkDataFilename.substring(l -
	 * l1, l); // System.out.println(temp); if
	 * (temp.equals(this.DEFAULTLINKFILENAME) == false) { return false; } if
	 * ((pointDataFilename.equals("No data")) && (this.hasPointInfo == false)) {
	 * return true; } l = pointDataFilename.length(); temp =
	 * pointDataFilename.substring(l - l2, l); // System.out.println(temp); if
	 * (temp.equals(this.DEFAULTPOINTFILENAME) == false) { return false; }
	 * return true; }
	 */

	public void showAllPoints() {
		// for testing
		this.graphdata.showAllPoints();
	}

	public void showAllLinks() {
		// for testing
		this.graphdata.showAllLinks();
	}

	public void showRange() {
		this.graphdata.showRange();
	}

	public void drawGraph(String title, boolean isDirected,
			String outputLocation, int nthfigure) {
		/*
		 * the inputs would be obtained from the GUI For link(usedLinkVarList)
		 * 0:pointXid 1:pointYid 2:shape 3:color 4:thickness 5:length 6:linkid
		 * 7:linkName 8:comment 10:tag For point(usedPointVarList) 0:pointid
		 * 1:shape 2:color 3:size 4:name 5:comment 678:xyz 9:tag
		 */
		// for normalization

		float[] maxVar = this.graphdata.getMaxVarList();
		float[] minVar = this.graphdata.getMinVarList();
		float maxSize = maxVar[0];
		float minSize = minVar[0];
		float maxThickness = maxVar[1];
		float minThickness = minVar[1];
		float maxLength = maxVar[2];
		float minLength = minVar[2];
		int N;
		N = this.graphdata.getNumOfPoint();
		// add node
		for (int i = 1; i <= N; i++) {
			// obtained the node information
			String[] pointInfo;
			String pointid, shape, color, name, comment;
			Float size, x, y, z;
			pointInfo = this.graphdata.getPointInfo(i);
			// obtain the basic info;
			pointid = pointInfo[0];
			shape = pointInfo[1];
			color = pointInfo[2];
			size = Float.parseFloat(pointInfo[3]);
			name = pointInfo[4];
			comment = pointInfo[5];
			x = Float.parseFloat(pointInfo[6]);
			y = Float.parseFloat(pointInfo[7]);
			z = Float.parseFloat(pointInfo[8]);
			// System.out.println(x);
			// add point

			if (nthfigure == 0)
				this.drawer.addPoint(pointid);
			this.drawer.setPointShape(pointid, shape);
			this.drawer.setPointColor(pointid, color);
			// set size

			if (maxSize != minSize) {
				float normalizedSize;
				normalizedSize = (size - minSize) / (maxSize - minSize);
				this.drawer.setPointSize(pointid, normalizedSize);
			} else {
				this.drawer.setPointSize(pointid, -1f);
			}
			// testing

			this.drawer.setPointComment(pointid, comment);
			if (this.graphdata.getNumOfPoint() > 200) {
				// if the number of point is too large then default hide the
				// comment information
				this.hideComment();
			}

			this.drawer.setPointPosition(pointid, x, y);
		}
		// this.showAllPoints();
		// this.showAllLinks();
		N = this.graphdata.getNumOfLink();

		for (int i = 1; i <= N; i++) {
			// obtained the point information
			String[] linkInfo;
			String linkid, pointXid, pointYid, shape, color, name, comment;
			Float thickness, length;
			linkInfo = this.graphdata.getLinkInfo(i);
			// obtain the basic info;
			pointXid = linkInfo[0];
			pointYid = linkInfo[1];
			shape = linkInfo[2];
			color = linkInfo[3];
			thickness = Float.parseFloat(linkInfo[4]);
			length = Float.parseFloat(linkInfo[5]);
			linkid = linkInfo[6];
			name = linkInfo[7];
			comment = linkInfo[8];
			if (nthfigure == 0) {
				this.drawer.addLink(pointXid, pointYid, linkid);
			}
			if (minThickness != maxThickness) {
				float normalizedThickness;
				normalizedThickness = (thickness - minThickness)
						/ (maxThickness - minThickness);
				this.drawer.setLinkThickness(linkid, normalizedThickness);
			}
			if (minLength != maxLength) {
				float normalizedLength;
				normalizedLength = (length - minLength)
						/ (maxLength - minLength);
				this.drawer.setLinkLength(linkid, normalizedLength);
			}
			this.drawer.setLinkShape(linkid, shape);
			this.drawer.setLinkColor(linkid, color);
			this.drawer.setLinkComment(linkid, comment);
			// this.drawer.setLinkName(linkid, name);
		}
		// if (nthfigure == 0) {
		//
		// N=this.getNumOfLink();
		// if(N>500)
		// this.drawer.sleep(2000);
		// if(N>100 && N<500)
		// this.drawer.sleep(1000);
		// if(N>20 && N<100)
		// this.drawer.sleep(500);
		// if(N<20)
		// this.drawer.sleep(300);
		// }
		this.drawer.saveFile(nthfigure);
		// add link
	}

	public void hideComment() {
		this.drawer.hideComment();

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public boolean isNormalized() {
		return isNormalized;
	}

	public void setNormalized(boolean isNormalized) {
		this.isNormalized = isNormalized;
	}

	public boolean isAutoLayout() {
		return isAutoLayout;
	}

	public void setAutoLayout(boolean isAutoLayout) {
		this.isAutoLayout = isAutoLayout;
	}

	public void showComment() {
		this.drawer.showComment();
	}

	public void disableAutoLayout() {
		this.drawer.disableAutolayout();
	}

	public void controlNodeComment(String nodeID) {
		this.drawer.controlNodeComment(nodeID);
	}

	public void focusNode(String nodeID, float percentage) {
		// focus on node with the given id
		this.drawer.focusNode(nodeID, percentage);

	}

	public int getNumOfLink() {
		return graphdata.getNumOfLink();
	}

	public int getNumOfPoints() {
		return graphdata.getNumOfPoint();
	}

	public Drawer getDrawer() {
		// for testing
		return this.drawer;
	}

	public void sleep(int t) {
		this.drawer.sleep(t);
	}
}
