package programcreek;

public class PowerInteger {

	public static void main(String[] args) {
		myPow(34.00515,-3);
	}

	  public static double myPow(double i, int j) {
      	if(j==0)
			return 1;
      	double y= myPow(i,j/2);
		if(j%2==0){
			
			if(j<0){
				return 1/(y*y);
			};
			return y*y;
		}
			
		else{
			if(j>0){
				return  i*y*y;
			}
		
			else
			{
				return  1/(i*y*y);
			}
		
	}
  }

}
