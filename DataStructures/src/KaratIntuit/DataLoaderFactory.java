package KaratIntuit;



public class DataLoaderFactory {
	
	public static DataLoader getInStance(String type){
		
		switch(type){
		
		case "csv":return new CSVLoader();
		
		case "txt" : return new CSVLoader();
		}
		return null;
		
	}
}
