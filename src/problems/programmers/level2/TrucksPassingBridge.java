/**
 * Created on Apr 6, 2019 by Keichee
 */
package problems.programmers.level2;

public class TrucksPassingBridge {

	// [example]
	// bridge_length weight truck_weights return
	// 2 10 [7,4,5,6] 8
	// 100 100 [10] 101
	// 100 100 [10,10,10,10,10,10,10,10,10,10] 110

	public static void main(String[] args) {
		int[] arr = { 7, 4, 5, 6, 1, 2, 7 };
		System.out.println(solution(2, 10, arr));

		// int[] arr2 = {10,10,10,10,10,10,10,10,10,10};
		// System.out.println(solution(100, 100, arr2));
	}

	public static int solution(int bridge_length, int weightLimit, int[] truck_weights) {
		int time_elapsed = 0;
		int curTotalWeights = 0; // 현재 다리위에 있는 모든 트럭의 무게
		int frontTruckIdx = 0;
		int numOfTrucks = 0;

		numOfTrucks += 1;
		time_elapsed += bridge_length + 1;
		curTotalWeights += truck_weights[0];
		System.out.println("time: " + time_elapsed + ", totalWeight: " + curTotalWeights);

		for (int i = 1; i < truck_weights.length; i++) {
			curTotalWeights += truck_weights[i];
			if (numOfTrucks >= bridge_length || curTotalWeights > weightLimit) {
				// 따로 가야하는 케이스
				// curTotalWeights -= truck_weights[frontTruckIdx];
				curTotalWeights = calcWeights(truck_weights, frontTruckIdx, curTotalWeights, weightLimit);
				time_elapsed += bridge_length;
				frontTruckIdx = i;
				numOfTrucks--;
			} else {
				// 연달아 갈 수 있는 케이스
				time_elapsed += 1;
				numOfTrucks++;
			}
			System.out.println("time: " + time_elapsed + ", totalWeight: " + curTotalWeights);
		}
		return time_elapsed;
	}

	private static int calcWeights(int[] truck_weights, int frontTruckIdx, int totalWeight, int limit) {
		int cnt = 0;
		while (totalWeight > limit) {
			totalWeight -= truck_weights[frontTruckIdx + cnt++];
		}
		return totalWeight;
	}
}
