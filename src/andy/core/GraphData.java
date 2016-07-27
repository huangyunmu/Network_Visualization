package andy.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GraphData {
	private Point[] pointSet;
	// store the point
	private int numOfPoint;
	private String charSet;

	public Point[] getPointSet() {
		return pointSet;
	}

	public void setPointSet(Point[] pointSet) {
		this.pointSet = pointSet;
	}

	public int getNumOfPoint() {
		return numOfPoint;
	}

	public void setNumOfPoint(int numOfPoint) {
		this.numOfPoint = numOfPoint;
	}

	public Link[] getLinkSet() {
		return linkSet;
	}

	public void setLinkSet(Link[] linkSet) {
		this.linkSet = linkSet;
	}

	public int getNumOfLink() {
		return numOfLink;
	}

	public void setNumOfLink(int numOfLink) {
		this.numOfLink = numOfLink;
	}

	public float[] getMaxVarList() {
		return maxVarList;
	}

	public void setMaxVarList(float[] maxVarList) {
		this.maxVarList = maxVarList;
	}

	public float[] getMinVarList() {
		return minVarList;
	}

	public void setMinVarList(float[] minVarList) {
		this.minVarList = minVarList;
	}

	public String getPointID(int index) {
		if (index > 0 && index < numOfPoint) {
			String pointID = this.pointSet[index].getId();
			return pointID;
		} else
			return null;

	}

	// the number of points
	private Link[] linkSet;
	// store the link
	private int numOfLink;
	// the number of links

	private int[] usedPointVarList;
	private int[] usedLinkVarList;

	private boolean hasPointInfo;
	// whether the point info is provided

	private boolean[] linkVarList;
	// which parameters of link are used
	private boolean[] pointVarList;
	// which parameters of point are used

	/*
	 * for normalization recorde the range of var size thickness and length
	 */
	private float[] maxVarList;
	private float[] minVarList;

	/*
	 * some constant
	 */
	private final int MAXNUMVARPOINT = 9;
	private final int MAXNUMVARLINK = 9;
	// the maximum number of varibles that current support
	// so far the set is not supported
	private final int MAXNUMPOINT = 1000001;
	private final int MAXNUMLINK = 6000001;

	// the maximum number of points and links

	public GraphData(int[] usedPointVarList, int[] usedLinkVarList, String charSet) {
		// used to receive data from graphmanager
		/*
		 * the inputs would be obtained from the GUI For link(usedLinkVarList)
		 * 0:pointXid 1:pointYid 2:shape 3:color 4:thickness 5:length 6:linkid
		 * 7:linkName 8:comment 9:tag For point(usedPointVarList) 0:pointid
		 * 1:shape 2:color 3:size 4:name 5:comment 678:xyz 9:tag
		 */
		pointVarList = new boolean[MAXNUMVARPOINT];
		linkVarList = new boolean[MAXNUMVARLINK];
		this.charSet = charSet;

		this.usedLinkVarList = usedLinkVarList;
		this.usedPointVarList = usedPointVarList;
		// which parameter is used
		for (int i = 0; i < pointVarList.length; i++) {
			pointVarList[i] = false;
		}
		for (int i = 0; i < usedPointVarList.length; i++)
			if (usedPointVarList[i] < 10) {
				pointVarList[usedPointVarList[i]] = true;
			}
		for (int i = 0; i < linkVarList.length; i++) {
			linkVarList[i] = false;
		}
		for (int i = 0; i < usedLinkVarList.length; i++)
			if (usedLinkVarList[i] < 10) {
				linkVarList[usedLinkVarList[i]] = true;
			}
		this.pointSet = new Point[MAXNUMPOINT];
		this.linkSet = new Link[MAXNUMLINK];

		this.maxVarList = new float[3];
		this.minVarList = new float[3];
		for (int i = 0; i < this.maxVarList.length; i++) {
			this.maxVarList[i] = 0f;
			this.minVarList[i] = 100000f;
		}

	}

	// data input section

	public void linkDataInput(String filename, boolean isFirstInput) throws IOException {
		/*
		 * For link(usedLinkVarList) 0:pointXid 1:pointYid 2:shape 3:color
		 * 4:thickness 5:length 6:linkid 7:name 8:comment 9:tag
		 */
		// so far the tag are unsupported
		File file;
		InputStreamReader reader;
		BufferedReader br;
		file = new File(filename);
		reader = new InputStreamReader(new FileInputStream(file), charSet);
		br = new BufferedReader(reader);
		String tempdata;
		String pointXid, pointYid, shape, color, linkid, name, comment;
		// default value
		pointXid = "0";
		pointYid = "0";
		shape = "1";
		color = "5";
		name = "";
		comment = "";
		Float thickness, length;
		thickness = 0.5f;
		length = 0.5f;
		String rowData = "";
		rowData = br.readLine();
		if (charSet.equals("UTF-8")) {
			// ignore the first character in utf-8
			rowData = rowData.substring(1, rowData.length());
		}
		int numOfInput = 0;
		while (rowData != null) {
			// divide the rowdata with \t
			// System.out.println(rowData.length());
			String[] splitData = rowData.split("\t");
			// exception here when the spliter is not \t
			int N = splitData.length;
			numOfInput++;
			linkid = String.valueOf(numOfInput);
			name = linkid;
			comment = "";
			// default value of link id
			// exception here when N not equals to the previous input
			for (int i = 0; i < N; i++) {
				tempdata = splitData[i];
				// default values
				switch (this.usedLinkVarList[i]) {
				case 0:
					// 0:pointXid
					pointXid = tempdata;
					break;
				case 1:
					// 1:pointYid
					pointYid = tempdata;
					break;
				case 2:
					// 2:shape
					shape = tempdata;
					break;
				case 3:
					// 3:color
					color = tempdata;
					break;
				case 4:
					// 4:thickness
					thickness = Float.parseFloat(tempdata);
					break;
				case 5:
					// 5:length
					length = Float.parseFloat(tempdata);
					break;
				case 6:
					// 6:link id
					linkid = tempdata;
					break;
				case 7:
					// 7:linkName
					name = tempdata;
					break;
				case 8:
					// 8:comment
					comment = comment + tempdata + " ";
					break;
				case 9:
					// 9:tag
					break;
				}

			}
			if (isFirstInput == true) {
				// if it is the first input create the link
				this.addLink(pointXid, pointYid, shape, color, thickness, length, linkid, name, comment);
			} else {
				this.setLink(pointXid, pointYid, shape, color, thickness, length, linkid, name, comment);
				// if not,modified the existing parameters
			}
			rowData = br.readLine();
		}
		br.close();
	}

	// public void demo() {
	// // set the first point to red
	// this.pointSet[1].setColor("2");
	// }

	public void pointDataInput(String filename, boolean isFirstInput) throws IOException {
		/*
		 * For point(usedPointVarList) 0:pointid1:shape 2:color 3:size 4:name
		 * 5:comment 678:xyz 9:tag
		 */
		File file;
		InputStreamReader reader;
		BufferedReader br;
		file = new File(filename);
		reader = new InputStreamReader(new FileInputStream(file), charSet);
		br = new BufferedReader(reader);

		String tempdata;
		String pointid, shape, color, name, comment;
		Float size, x, y, z;
		// default value
		pointid = "0";
		shape = "1";
		color = "1";
		name = "";
		size = 0.5f;
		x = 0f;
		y = 0f;
		z = 0f;
		String rowData = "";
		rowData = br.readLine();
		if (charSet.equals("UTF-8")) {
			// ignore the first character in utf-8
			rowData = rowData.substring(1, rowData.length());
		}
		int numOfInput = 0;
		while (rowData != null) {
			// divide the rowdata with \t
			String[] splitData = rowData.split("\t");
			// exception here when the spliter is not \t
			int N = splitData.length;
			// exception here when N not equals to the previous input
			numOfInput++;
			pointid = String.valueOf(numOfInput);
			name = pointid;
			comment = "";
			// default value
			for (int i = 0; i < N; i++) {
				tempdata = splitData[i];
				// default values
				switch (this.usedPointVarList[i]) {
				case 0:
					// 0:pointXid
					pointid = tempdata;
					break;
				case 1:
					// 2:shape
					shape = tempdata;
					break;
				case 2:
					// 2:color
					color = tempdata;
					break;
				case 3:
					// 3size
					size = Float.parseFloat(tempdata);
					break;
				case 4:
					// 4:name
					name = tempdata;
					break;
				case 5:
					// 5:comment
					comment = comment + tempdata + " ";
					break;
				case 6:
					// 6:x
					x = Float.parseFloat(tempdata);
					break;
				case 7:
					// 7:y
					y = Float.parseFloat(tempdata);
					break;
				case 8:
					// 8:z
					z = Float.parseFloat(tempdata);
					break;
				case 9:
					// 9:
					break;
				}

			}
			if (comment.equals("") == true) {
				comment = pointid;
			}
			if (isFirstInput == true) {
				// if it is the first input create the point
				this.addPoint(pointid, shape, color, size, name, comment, x, y, z);
			} else {
				// if not,modified the existing parameters
				this.setPoint(pointid, shape, color, size, name, comment, x, y, z);
			}
			rowData = br.readLine();
		}
		br.close();
	}

	public void computeRange() {
		// for the normalization
		// compute the max and the min of float variables

		// so far only three parameter at most need to be normalized
		// size thickness,length
		// 0:size 1:thickness 2:length
		// compute the range of size
		for (int i = 1; i <= this.numOfPoint; i++) {
			float tempSize = this.pointSet[i].getSize();
			if (tempSize > this.maxVarList[0]) {
				this.maxVarList[0] = tempSize;
			}
			if (tempSize < this.minVarList[0]) {
				this.minVarList[0] = tempSize;
			}
		}
		// thickness
		for (int i = 1; i <= this.numOfLink; i++) {
			float tempThickness = this.linkSet[i].getThickness();
			if (tempThickness > this.maxVarList[1]) {
				this.maxVarList[1] = tempThickness;
			}
			if (tempThickness < this.minVarList[1]) {
				this.minVarList[1] = tempThickness;
			}
		}
		// length
		for (int i = 1; i <= this.numOfLink; i++) {
			float tempLength = this.linkSet[i].getLength();
			if (tempLength > this.maxVarList[2]) {
				this.maxVarList[2] = tempLength;
			}
			if (tempLength < this.minVarList[2]) {
				this.minVarList[2] = tempLength;
			}
		}

	}

	public void findPointByLink() {
		// when there is not data about point
		// the point info would be obtained from the link
		// so far for single graph
		int N = this.getNumOfLink();
		String pointXid, pointYid;
		Set<String> tempPointSet = new HashSet<String>();
		for (int i = 1; i <= N; i++) {
			pointXid = this.linkSet[i].getPointXid();
			pointYid = this.linkSet[i].getPointYid();
			System.out.printf("%s,%s\n", pointXid, pointYid);
			tempPointSet.add(pointXid);
			tempPointSet.add(pointYid);
		}
		Iterator<String> iter = tempPointSet.iterator();
		while (iter.hasNext()) {
			String pointid, shape, color, name, comment;
			Float size, x, y, z;
			// default value
			pointid = "0";
			shape = "1";
			color = "1";
			name = "";
			size = 0.5f;
			x = 0f;
			y = 0f;
			z = 0f;
			pointid = iter.next();
			comment = pointid;
			name = pointid;
			this.addPoint(pointid, shape, color, size, name, comment, x, y, z);
		}
	}

	public void addLink(String pointXid, String pointYid, String shape, String color, float thickness, float length,
			String linkid, String name, String comment) {
		this.numOfLink++;
		this.linkSet[this.numOfLink] = new Link(pointXid, pointYid, shape, color, thickness, length, linkid, name,
				comment);
	}

	public void addPoint(String pointid, String shape, String color, float size, String name, String comment, float x,
			float y, float z) {
		this.numOfPoint++;
		this.pointSet[this.numOfPoint] = new Point(pointid, shape, color, size, name, comment, x, y, z);

	}

	public void setLink(String pointXid, String pointYid, String shape, String color, float thickness, float length,
			String linkid, String name, String comment) {
		// find the link by id
		for (int i = 1; i <= this.numOfLink; i++) {
			if (this.linkSet[i].getLinkid().equals(linkid)) {
				this.linkSet[i].setLink(pointXid, pointYid, shape, color, thickness, length, linkid, name, comment);
				break;
			}
		}
	}

	public void setPoint(String pointid, String shape, String color, float size, String name, String comment, float x,
			float y, float z) {
		for (int i = 1; i <= this.numOfPoint; i++) {
			if (this.pointSet[i].getId().equals(pointid)) {
				this.pointSet[i].setPoint(pointid, shape, color, size, name, comment, x, y, z);
				break;
			}
		}

	}

	public String[] getPointInfo(String pointid) {
		// For point(usedPointVarList) 0:pointid1:shape 2:color 3:size 4:name
		// 5:comment 678:xyz 9:tag
		for (int i = 1; i <= this.numOfPoint; i++) {
			if (this.pointSet[i].getId().equals(pointid)) {
				return this.getPointInfo(i);
			}
		}
		return null;
	}

	public String[] getPointInfo(int index) {
		if ((index == 0) || (index > this.numOfPoint))
			return null;
		// exceptiong when i <> range
		String[] pointInfo = new String[9];
		pointInfo[0] = this.pointSet[index].getId();
		pointInfo[1] = this.pointSet[index].getShape();
		pointInfo[2] = this.pointSet[index].getColor();
		pointInfo[3] = String.valueOf(this.pointSet[index].getSize());
		pointInfo[4] = this.pointSet[index].getName();
		pointInfo[5] = this.pointSet[index].getComment();
		pointInfo[6] = String.valueOf(this.pointSet[index].getX());
		pointInfo[7] = String.valueOf(this.pointSet[index].getY());
		pointInfo[8] = String.valueOf(this.pointSet[index].getZ());
		// poinInfo[9] = this.pointSet[i].getId();
		return pointInfo;
	}

	public String[] getLinkInfo(int index) {
		// For link(usedLinkVarList) 0:pointXid 1:pointYid 2:shape 3:color
		// 4:thickness 5:length 6:linkid 7:name 8:comment 9:tag
		if ((index == 0) || (index > this.numOfLink))
			return null;
		// exceptiong when i <> range
		String[] linkInfo = new String[9];
		linkInfo[0] = this.linkSet[index].getPointXid();
		linkInfo[1] = this.linkSet[index].getPointYid();
		linkInfo[2] = this.linkSet[index].getShape();
		linkInfo[3] = this.linkSet[index].getColor();
		linkInfo[4] = String.valueOf(this.linkSet[index].getThickness());
		linkInfo[5] = String.valueOf(this.linkSet[index].getLength());
		linkInfo[6] = this.linkSet[index].getLinkid();
		linkInfo[7] = this.linkSet[index].getName();
		linkInfo[8] = this.linkSet[index].getComment();
		// poinInfo[9] = this.pointSet[i].getId();
		return linkInfo;

	}

	public String[] getLinkInfo(String linkid) {
		for (int i = 1; i <= this.numOfLink; i++) {
			if (this.pointSet[i].getId().equals(linkid)) {
				return this.getLinkInfo(i);
			}
		}
		return null;
	}

	public void showAllPoints() {
		int N = this.numOfPoint;
		System.out.printf("%s %d\n", "Total number of points", N);
		for (int i = 1; i <= N; i++) {
			String[] pointInfo = this.getPointInfo(i);
			for (int j = 0; j < this.MAXNUMVARPOINT; j++) {
				if (this.pointVarList[j] == true)
					System.out.println(pointInfo[j] + " ");
			}
			System.out.println();
		}
	}

	public void showAllLinks() {
		int N = this.numOfLink;
		System.out.printf("%s %d\n", "Total number of links", N);
		for (int i = 1; i <= N; i++) {
			String[] linkInfo = this.getLinkInfo(i);
			for (int j = 0; j < this.MAXNUMVARLINK; j++) {
				if (this.linkVarList[j] == true)
					System.out.println(linkInfo[j] + " ");
			}
			System.out.println();
		}
	}

	public void showRange() {
		for (int i = 0; i < this.maxVarList.length; i++) {
			System.out.print(this.minVarList[i]);
			System.out.print(" ");
			System.out.println(this.maxVarList[i]);
		}
	}

}
