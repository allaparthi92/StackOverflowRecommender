package arraysAndStrings;

class Person{
	public int number;
}
public class Test {

	public void dot(int i,Person P){
		i=5;
		P.number =8;
	}
	public static void main(String[] args) {
		
		int x=0;
		Person p = new Person();
		new Test().dot(x, p);
		System.out.println(x+" "+p.number);
		

	}

}
