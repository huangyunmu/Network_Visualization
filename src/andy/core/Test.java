package andy.core;

import java.io.IOException;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// tesing parameters
		/*
		 * the inputs would be obtained from the GUI For link(usedLinkVarList)
		 * 0:pointXid 1:pointYid 2:shape 3:color 4:thickness 5:length 6:linkid
		 * 7:linkName 8:comment 10:tag For point(usedPointVarList) 0:pointid
		 * 1:shape 2:color 3:size 4:name 5:comment 678:xyz 9:tag
		 */

		// shape list
		// String[] DEFAULTCOLOR = { "white", "blue", "red", "green", "yellow",
		// "black" };
		// String[] DEFAULTPOINTSHAPE
		// ={"box","circle","rounded-box","diamond","cross"};
		// String[] DEFAULTLINKSHAPE
		// ={"angle","line","cubic-curve","blob","freeplane"};
		// http://graphstream-project.org/doc/Advanced-Concepts/GraphStream-CSS-Reference/
		// for example color=1 will set the node to blue

		// setting
		String title = "test";
		// file location
		String linkDataFilename = "C:\\Users\\EF501b_3\\Desktop\\Link_0.txt";
		// String pointDataFilename = "E:\\FYP_DATA\\GraphData\\Point_0.txt";
		String outputLocation = "C:\\Users\\EF501b_3\\Desktop\\";
		// String queryNodeID = "681B01F1";
		float zoomPercentage = 1F;

		boolean isNormalized = false;
		boolean isMultiple = false;
		boolean isDirected = true;
		boolean isAutoLayout = true;

		int[] usedPointVarList = new int[9];
		for (int i = 0; i < 9; i++) {
			usedPointVarList[i] = 10;
		}
		// usedPointVarList[0] = 0;
		// usedPointVarList[1] = 1;
		// usedPointVarList[2] = 2;
		// usedPointVarList[3] = 3;
		// usedPointVarList[4] = 6;
		// usedPointVarList[5] = 7;
		// usedPointVarList[5] = 7;
		int[] usedLinkVarList = new int[9];
		for (int i = 0; i < 9; i++) {
			usedLinkVarList[i] = 10;
		}
		usedLinkVarList[0] = 1;
		usedLinkVarList[1] = 0;
		usedLinkVarList[2] = 2;
		usedLinkVarList[3] = 3;
		// usedLinkVarList[4] = 4;

		for (int i = 0; i < 9; i++) {
			if (usedPointVarList[i] < 9 && usedPointVarList[i] > 5) {
				// if the point position need to be set it should be set to
				isAutoLayout = false;
				break;
			}
		}
		boolean[] statusVarList = new boolean[4];
		statusVarList[0] = isNormalized;
		statusVarList[1] = isMultiple;
		statusVarList[2] = isDirected;
		statusVarList[3] = isAutoLayout;
		String charSet = "UTF-8";
		GraphManager manager = new GraphManager(usedPointVarList, usedLinkVarList, statusVarList, charSet, title);
		// System.out.println("New manager");
		manager.controlPre(linkDataFilename, outputLocation);
		// manager.controlPre(linkDataFilename, pointDataFilename,
		// outputLocation);
		// manager.focusNode(queryNodeID, zoomPercentage);
		// manager.controlPre(linkDataFilename, pointDataFilename,
		// outputLocation);
		manager.hideComment();
		// manager.showAllPoints();
		// manager.disableAutoLayout();
		// manager.showAllLinks();
		// manager.showRange();

	}

}
