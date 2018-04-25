package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (최대 약수 구하기)
 * 
 * A시에서는 0으로 된 도로에 숫자 블록을 설치하기로 하였습니다. 숫자 블록의 규칙은 다음과 같습니다.
 * 
 * 블록의 번호가 n일 때, 가장 처음 블록은 n*2 번 째 위치에 설치합니다. 그 다음은 n*3, 그 다음은 n*4, ... 로 진행합니다. 만약 기존에 블록이 깔려있는 자리라면 그 블록을 빼고 새로운 블록으로 집어넣습니다.
 * 
 * 예를들어
 * 
 * 1번 블록은 2,3,4,5,...인 위치에 우선 설치합니다.
 * 2번 블록은 4,6,8,10,...인 위치에 설치합니다.
 * 3번 블록은 6,9,...인 위치에 설치합니다.
 * 이렇게 3번 블록까지 설치하고 나면 첫 10개의 블록은 0, 1, 1, 2, 1, 3, 1, 2, 3, 2이 됩니다.
 * 
 * A시는 길이가 100조나 되는 도로에 1번 블록부터 시작하여 1000만 번 블록까지 위의 규칙으로 모두 놓았습니다. 이 때, 두 수 a와 b를 입력받아 a와 b번 사이에 어떠한 블록이 깔렸는지 블록의 숫자를 배열로 반환하는 numberBlock 함수를 완성하세요.
 * 
 * 예를 들어 99999999999990과 100000000000000가 입력된다면
 * [376830,9999997,7973704,9052401,5422,6414455,9999998,839,14,9999999,10000000]을 반환해 주면 됩니다.
 */

public class NumberBlock {
	// TODO  : 속도 향상 필요
	public int[] numberBlock(long begin, long end) {
		int[] answer = {};
		int size = (int)(end - begin + 1);
		answer = new int[size];
		long[] num = new long[size];
		List<Integer> idxlist = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			num[i] = begin++;
			idxlist.add(i);
		}
		
		long maxAliquot = (int) Math.sqrt(end);
		
		for ( long aliquot = maxAliquot ; aliquot > 0 ; aliquot-- ) {
			for ( int i = 0 ; i < idxlist.size() ; i++) {
				
				int index = idxlist.get(i);
				long number = num[index];
				
				if ( number % aliquot ==  0 ) {
					int quotient = (int)(number / aliquot);
					if ( number / aliquot > aliquot ) {
						answer[index] = (int) aliquot;
					}else {
						answer[index] = quotient;
					}
					idxlist.remove(i);
					i--;
				}
			}
			if ( idxlist.size() == 0 ) break;
		}
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		NumberBlock nb = new NumberBlock();
//		System.out.println(Arrays.toString(nb.numberBlock(99999999999990L, 100000000000000L)));
		System.out.println(Arrays.toString(nb.numberBlock(99999999999990L, 100000000000000L)));
	}
}
