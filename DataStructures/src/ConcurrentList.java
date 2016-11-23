import java.util.HashSet;
import java.util.Set;


public class ConcurrentList {
	String name = "";
	
	public static void main(String[] args) {
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
//        list.add(19);
//        list.add(2);
//        list.add(30);
//        list.add(4);
//        list.add(-1);
//    
//        
//        PriorityQueue<Integer> x = new PriorityQueue<Integer>();
//        for(Integer y : list){
//        	x.add(y);
//        	System.out.println(x);
//        }
//        System.out.println(x);
		ConcurrentList c1 = new ConcurrentList();
		c1.name = "Bhanu";
		ConcurrentList c2= new ConcurrentList();
		c2.name = "Bhanu";
		
		System.out.println(c1==c2);
		Set<ConcurrentList> x = new HashSet<>();
		x.add(c1);
		x.add(c2);
		System.out.println(x.size());
		System.out.println(c1.equals(c2));}
	
	@Override
	public int hashCode(){
		return this.name.length();
	}
    
	@Override
	public boolean equals(Object obj){
		ConcurrentList c3 = (ConcurrentList)obj;
		return this.name.length()== c3.name.length();
	}
	
}
