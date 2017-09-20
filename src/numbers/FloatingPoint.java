package numbers;



public class FloatingPoint{
	public static void main(String[] args) {
		System.out.println(String.format("%.2f", (float)53));
		System.out.println(		String.format("%.2f", Double.parseDouble(String.format("%.3f", (float)53))/5*100));	
		
		System.out.println(Float.parseFloat(String.format("%.2f", (float)6/(float)7*100f)));
	}
	
}