package asu.edu.amazon.school;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Point {
	int xcordinate;
	int ycordinate;

	public Point(int x, int y) {
		xcordinate = x;
		ycordinate = y;
	}
}

public class ClosesetPairOfPoints {

	public static PriorityQueue<Point> ClosestSet(ArrayList<Point> pointsSet,
			int k, Point startPoint) {

		PriorityQueue<Point> result = new PriorityQueue<Point>(k,
				new Comparator<Point>() {

					@Override
					public int compare(Point o1, Point o2) {
						double distance1 = Math.hypot(
								(o1.xcordinate - startPoint.xcordinate),
								(o1.ycordinate - startPoint.ycordinate));
						double distance2 = Math.hypot(
								(o2.xcordinate - startPoint.xcordinate),
								(o2.ycordinate - startPoint.ycordinate));
						if (distance1 > distance2) {
							return -1;
						} else if (distance1 < distance2) {
							return 1;
						} else {
							return 0;
						}
					}
				});

		for (Point p : pointsSet) {

			result.offer(p);

			if (result.size() > k) {
				result.poll();
			}
		}
		return result;

	}

	public static void main(String[] args) {

		ArrayList<Point> setOfPoints = new ArrayList<Point>();
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 11);
		Point p3 = new Point(1, 3);
		Point p11 = new Point(-1, -1);
		Point p4 = new Point(1, -10);
		Point p5 = new Point(1, -1);
		Point p6 = new Point(1, 2);
		Point p7 = new Point(1, 4);
		Point p8 = new Point(1, 91);
		Point p9 = new Point(1, 6);
		setOfPoints.add(p1);
		setOfPoints.add(p2);
		setOfPoints.add(p3);
		setOfPoints.add(p4);
		setOfPoints.add(p5);
		setOfPoints.add(p6);
		setOfPoints.add(p7);
		setOfPoints.add(p8);
		setOfPoints.add(p9);
		setOfPoints.add(p11);

		Point myPoint = new Point(0, 0);

		PriorityQueue<Point> op = ClosestSet(setOfPoints, 2, myPoint);

		for (int i = 0; i < 2; i++) {
			Point kk = op.poll();
			System.out.print(kk.xcordinate + ", ");
			System.out.print(kk.ycordinate + ", ");
			System.out.println("--------");
		}
	}

}
