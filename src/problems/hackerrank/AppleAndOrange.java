package problems.hackerrank;

public class AppleAndOrange {

	
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		
		int[] positionApples = getAbsolutePosition(a, apples);
		int[] positionOranges = getAbsolutePosition(b, oranges);
		
		countFruitsBetween(s, t, positionApples);
		countFruitsBetween(s, t, positionOranges);

    }
	
	public static int[] getAbsolutePosition(int center, int[] distances) {
		for(int i = 0; i < distances.length; i++) {
			distances[i] = center + distances[i];
		}
		return distances;
	}
	
	public static void countFruitsBetween(int s, int t, int[] pos) {
		int count = 0;
		for(int p : pos) {
			if(p >= s && p <= t) {
				count++;
			}
		}
		System.out.println(count);
	}
}
