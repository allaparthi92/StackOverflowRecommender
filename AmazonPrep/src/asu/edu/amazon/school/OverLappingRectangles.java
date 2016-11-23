package asu.edu.amazon.school;

class Rectangle {

	CoOrPoint lefttop;
	CoOrPoint bottomRight;
}

public class OverLappingRectangles {

	public static boolean IntersectRectangles(Rectangle rect1, Rectangle rect2) {

		if (rect1.lefttop.x >= rect2.bottomRight.x
				|| rect2.lefttop.x >= rect1.bottomRight.x
				|| rect1.lefttop.y <= rect2.bottomRight.y
				|| rect2.lefttop.y <= rect1.bottomRight.y){
			return false;
		}
			return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
