import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class LogisticRegression {

	static ArrayList<ArrayList<Double>> weights = new ArrayList<ArrayList<Double>>();

	public static double ProbabilityWeight(ArrayList<Integer> subInput,
			ArrayList<Double> localweight) {

		double result = 0;
		double sum = 0;
		for (int i = 0; i < subInput.size(); i++) {
			sum = sum + localweight.get(i + 1) * subInput.get(i);
		}
		sum = sum + localweight.get(0);
		result = Math.exp(sum) / (1 + Math.exp(sum));

		return result;

	}

	public static void CalculateMainWeight(double growthRate,
			ArrayList<ArrayList<Integer>> input) {
		
		for (int p = 0; p < 9; p++) {
		ArrayList<Double> subweight = new ArrayList<Double>();
		for (int k = 0; k < weights.get(0).size(); k++) {
			double finalsum = 0;
			for (int i = 0; i < input.size(); i++) {
				
				ArrayList<Integer> subInput = new ArrayList<Integer>(input.get(i));
				double y = subInput.get(subInput.size() - 1);
				subInput.remove(subInput.size() - 1);
				subInput.remove(0);

				double subResult = ProbabilityWeight(subInput,
						weights.get(weights.size() - 1));
				int xi = 0;
				if(k-1 < 0){
					xi = 1;
				}
				else{
					xi = subInput.get(k-1);
				}
				finalsum = finalsum + (y - subResult) * xi;

			}
			finalsum = (growthRate * finalsum) + weights.get(weights.size()-1).get(k);
			subweight.add(finalsum);
		}
		weights.add(subweight);
		}

	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		try (BufferedReader br = new BufferedReader(new FileReader(
				"F:\\Algorithms\\DataStructures\\src\\file"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {

				ArrayList<Integer> result = new ArrayList<Integer>();
				String inp[] = line.split(",");
				for (int i = 0; i < inp.length; i++) {
					if (inp[i].equals("?"))
						inp[i] = "0";
					if (i == inp.length - 1 && inp[i].equals("2"))
						inp[i] = "1";
					if (i == inp.length - 1 && inp[i].equals("4"))
						inp[i] = "-1";
					result.add(Integer.parseInt(inp[i]));
				}
				input.add(result);
				line = br.readLine();
			}

		}
		ArrayList<Double> subweight = new ArrayList<Double>();

		for (int i = 0; i < input.get(0).size()-1; i++) {
			subweight.add(0.0);
		}
		weights.add(subweight);
		
		CalculateMainWeight(0.001 ,input);
		System.out.println(weights);
	}
}