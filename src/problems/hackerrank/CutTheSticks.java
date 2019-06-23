package problems.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 190616 - 1
 */
public class CutTheSticks {

	public static void main(String[] args) {
//		int[] arr = {3, 5, 1, 1};
//		List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
//		System.out.println(list);
		int[] arr = { 5, 4, 4, 2, 2, 8 };
		System.out.println(Arrays.toString(cutTheSticks(arr)));

	}

	static int[] cutTheSticks(int[] arr) {

		List<Integer> list = new ArrayList<>();
		for (int a : arr) {
			list.add(a);
		}
		Collections.sort(list);

		List<Integer> result = new ArrayList<>();

		int shortestStickLength = list.get(0); // index 0에 있는 아이템을 가지고 옴.
		int currentStickLength = 0;
		int shortestStickCount = 0;
		result.add(list.size()); // 전체 스틱의 개수 (고정)

		// 2, 2, 4, 4, 5, 8 (6)
		// 2, 2, 3, 6 (4)
		// 1, 5 (2)

		int totalStickCount = list.size();
		for (int index = 0; index < list.size(); index++) {

			currentStickLength = list.get(index);

			if (shortestStickLength != currentStickLength) {
				shortestStickLength = currentStickLength;
				int currentTotalStickCount = totalStickCount - shortestStickCount;
				result.add(currentTotalStickCount);
				totalStickCount = currentTotalStickCount;

			} else {
				shortestStickCount++;
			}
		}

		int[] resultArr = new int[result.size()];
		for (int index = 0; index < result.size(); index++) {
			resultArr[index] = result.get(index);
		}
		return resultArr;
	}

//	static int[] cutTheSticks(int[] arr) {
//		
//		List<Integer> result = new ArrayList<>();
//		
//		List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
//		Iterator<Integer> iter = list.iterator();
//		
//		int shortestStickLength = iter.next();	// index 0에 있는 아이템을 가지고 옴.
//		int currentStickLength = 0;
//		int stickCount = list.size();
//		result.add(stickCount--);
//		
//		while(iter.hasNext()) {
//			currentStickLength = iter.next();
//			
//			if(shortestStickLength != currentStickLength) {
//				shortestStickLength = currentStickLength;
//				result.add(stickCount);
//			}
//			stickCount--;
//		}
//		return result.stream().mapToInt(Integer::intValue).toArray();
//    }
}
