package dynamicprogramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindowMaximum {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
	
	public static int [] Slidingwindow(int []a,int k){
		
		if(a.length==0){
			return a;
		}
		
		int result[] = new int[a.length-k+1];
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		int km=0;
		for(int i=0;i<a.length;i++){
			
			if(!q.isEmpty() && q.peek()<i-k+1){
				q.poll();
			}
			
			while(!q.isEmpty() && a[i] >= a[q.peekLast()]){
				q.pollLast();
			}
			
			q.offer(i);
			
			if(i-k+1 >=0){
				result[km++] = a[q.peek()];
			}
		}
		  System.out.println(Arrays.toString(result));
		return result;
		
	}
	
	
	private int longestPathLen(String in) {
		String lines[] = in.split("\\r?\\n");
		Map<Integer, String> dirMap = new HashMap<>();
		int max = 0;
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			int level = line.length() - line.replaceAll(" ", "").length();
			if (line.contains(".")) {
				StringBuilder build = new StringBuilder();
				for (int j = 0; j < level; j++) {
					build.append(dirMap.get(j) != null ? dirMap.get(j) + "/" : "");
				}
				int curLen = build.append(line.trim()).length();
				max = curLen > max ? curLen : max;
			} else {
				dirMap.put(level, line.trim());
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		int a[] = {1,3,-1,-3,5,3,6,7};
		Slidingwindow(a,3);
		maxSlidingWindow(a,3);
		
	}
}
