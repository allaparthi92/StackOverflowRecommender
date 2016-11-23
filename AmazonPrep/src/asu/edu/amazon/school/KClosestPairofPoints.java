package asu.edu.amazon.school;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class CoordinatePoint {
	float x;
	float y;
	//double distance;
	CoordinatePoint(float xcoord,float ycoord){
		this.x = xcoord;
		this.y = ycoord;		
//		this.distance = Integer.MAX_VALUE;
	}
	
}
public class KClosestPairofPoints {
	
	public static void main(String[] args) {

		ArrayList<CoordinatePoint> setOfPoints = new ArrayList<CoordinatePoint>();
		CoordinatePoint p1 = new CoordinatePoint(1, 1);
		CoordinatePoint p2 = new CoordinatePoint(1, 11);
		CoordinatePoint p3 = new CoordinatePoint(1, 3);
		CoordinatePoint p4 = new CoordinatePoint(1, -10);
		CoordinatePoint p5 = new CoordinatePoint(1, -1);
		CoordinatePoint p6 = new CoordinatePoint(1, 2);
		CoordinatePoint p7 = new CoordinatePoint(1, 4);
		CoordinatePoint p8 = new CoordinatePoint(1, 91);
		CoordinatePoint p9 = new CoordinatePoint(1, 6);
		setOfPoints.add(p1);
		setOfPoints.add(p2);
		setOfPoints.add(p3);
		setOfPoints.add(p4);
		setOfPoints.add(p5);
		setOfPoints.add(p6);
		setOfPoints.add(p7);
		setOfPoints.add(p8);
		setOfPoints.add(p9);

		CoordinatePoint myPoint = new CoordinatePoint(1, 1);

		PriorityQueue<CoordinatePoint> op = calnearest(setOfPoints, myPoint, 2);

		for (int i = 0; i < 2; i++) {
			CoordinatePoint kk = op.poll();
			System.out.print(kk.x + ", ");
			System.out.print(kk.y + ", ");
			// System.out.println(kk.distance );
			System.out.println("--------");
		}
	}

	private static PriorityQueue<CoordinatePoint> calnearest(ArrayList<CoordinatePoint> setOfPoints,
			CoordinatePoint myPoint, int k) {

		PriorityQueue<CoordinatePoint> queue = new PriorityQueue<CoordinatePoint>(k, new Comparator<CoordinatePoint>() {
			public int compare(CoordinatePoint o1, CoordinatePoint o2) {
				double distance1 = Math.hypot(o1.x - myPoint.x, o1.y - myPoint.y);
				double distance2 = Math.hypot(o2.x - myPoint.x, o2.y - myPoint.y);
				if (distance1 > distance2) {
					return -1;
				} else if (distance1 < distance2) {
					return 1;
				} else {
					return 0;
				}

			}

		});

		for (CoordinatePoint point : setOfPoints) {
			queue.offer(point);
			if (queue.size() > k) {
				// pop
				queue.poll();
			}
		}

		return queue;
	}

}
