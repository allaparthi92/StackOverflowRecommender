package designPatterns;

public class Singleton {


	    private static Singleton instance = new Singleton();
	    
	    private Singleton(){
	    	
	    }
	    
	    public static Singleton  getInstance(){
	       
	        return instance;
	    }
	    
	    public void Calculate(int a ,int b){
	    	System.out.println(a+b);
	    }
	    
	}
class StaticSingleton{
	 private static StaticSingleton instance ;
	 
	 private StaticSingleton(){
	    	
	    }
	 static {
		 try{
			 instance = new StaticSingleton();
		 }
		 catch(Exception e){
	            throw new RuntimeException("Exception occured in creating singleton instance");
	 }
	 }
	 public static StaticSingleton  getInstance(){
	       
	        return instance;
	    }
	 public void Calculate(int a ,int b){
	    	System.out.println(a+b);
	    }
	    
	 
}

 class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
}
 
 
  class BillPughSingleton {

	    private BillPughSingleton(){}
	    
	    private static class SingletonHelper{
	        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	    }
	    
	    public static BillPughSingleton getInstance(){
	        return SingletonHelper.INSTANCE;
	    }
	}
	



