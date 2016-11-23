package asu.edu.amazon.school;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class CoOrPoint {

	int x;
	int y;

	public CoOrPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class ClosestPairs {

	public PriorityQueue<CoOrPoint> ClosestPairofPoints(
			ArrayList<CoOrPoint> list, int k, CoOrPoint Point) {

		PriorityQueue<CoOrPoint> result = new PriorityQueue<CoOrPoint>(k,
				new Comparator<CoOrPoint>() {

					@Override
					public int compare(CoOrPoint o1, CoOrPoint o2) {
						double distance1 = Math.hypot(o1.x - Point.x, o1.y
								- Point.y);
						double distance2 = Math.hypot(o2.x - Point.x, o2.y
								- Point.y);

						if (distance1 > distance2) {
							return -1;
						} else if (distance1 < distance2) {
							return 1;
						} else {
							return 0;
						}
					}

				});

		for (CoOrPoint p : list) {
			result.offer(p);
			if (result.size() > k) {
				result.poll();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
