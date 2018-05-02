package problems.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * My solutions for Woowa Brothers Algorithm Test
 * @author Kihyun
 * @created   2018-05-01
 */
public class CareerTest_Woowa {

	/*
	 * #1 정수의 바이너리 표현식을 입력받아 짝수이면 2로 나누고 홀수이면 1을 빼서 0이 되기까지 몇번의 단계를 거쳐야 하는지 리턴
	 */
	public static int solution1(String binRepStr) {
		int steps = 0;
		int firstIndexOfOne = binRepStr.indexOf("1");
		if ( firstIndexOfOne == -1 ) {	// 0 으로만 구성된 스트링
			return 0;
		}
		steps++;
		for ( int index = firstIndexOfOne + 1 ; index < binRepStr.length() ; index++ ) {
			if ( binRepStr.charAt(index) == (char)'0' ) {
				steps++;
			} else {
				steps += 2;
			}
		}
		return steps;
    }
	
	/*
	 * #2 뒤죽박죽 사진 정보를 입력받아 도시별로 정렬, 시간순으로 정렬 후 번호를 매겨서 파일명을 변경하고 리턴하기
	 * time complexity는 신경쓰지 않아도 됨.
	 */
	public static String solution2(String photos) {
        String[] photosArr = photos.split(System.lineSeparator());
        final List<Photo> photosList = new ArrayList<>();
        final Map<String, Integer> cityNum = new HashMap<>();
        final Map<String, Integer> orderLength = new HashMap<>();
        
        int photoCnt = 0;
        for ( int index = 0 ; index < photosArr.length; index++ ) {
        	String photo = photosArr[index];
        	String[] photoInfo = photo.split(", ");
        	Photo p = new Photo(++photoCnt, photoInfo[0], photoInfo[1], photoInfo[2]);
        	photosList.add(p);
        	
        	if ( cityNum.get(p.getCity()) == null ) {
        		cityNum.put(p.getCity(), 1);
        	} else {
        		cityNum.put(p.getCity(), cityNum.get(p.getCity()) + 1);
        	}
        }
        
        printPhotos(photosList);
        
        // 시간 내림차순 정렬
        Collections.sort(photosList, new Comparator<Photo>() {
			@Override
			public int compare(Photo p1, Photo p2) {
				return p2.getDttm().compareTo(p1.getDttm());
			}
		});
        
//        System.out.println("=====================");
//        printPhotos(photosList);
        
        StringBuffer newNameBuffer = new StringBuffer();
        for ( int index = 0 ; index < photosList.size() ; index++ ) {
        	Photo p = photosList.get(index);
        	newNameBuffer.append(p.getCity());	// 도시명 추가
        	
        	if ( orderLength.get(p.getCity()) == null ) {
        		newNameBuffer.append(cityNum.get(p.getCity()));	// 마지막 사진 번호 추가
        		orderLength.put(p.getCity(), getOrderLength(cityNum.get(p.getCity())));
        	} else {
        		int len = orderLength.get(p.getCity());
        		int num = cityNum.get(p.getCity());
        		newNameBuffer.append(getLeadingZeros(num, len)).append(num);	// 번호 추가
        	}
        	newNameBuffer.append(".").append(p.getFileName().split(Pattern.quote("."))[1]);
        	cityNum.put(p.getCity(), cityNum.get(p.getCity()) - 1);
        	p.setNewName(newNameBuffer.toString());
        	newNameBuffer.setLength(0);	// 버퍼 클리어
        }
//        System.out.println("=====================");
//        printPhotos(photosList);
        
        // 결과물을 위한 재정렬
        Collections.sort(photosList, new Comparator<Photo>() {
			@Override
			public int compare(Photo p1, Photo p2) {
				if ( p1.getOrder() < p2.getOrder() ) {
					return -1;
				} else if ( p1.getOrder() == p2.getOrder() ) {
					return 0;
				} else {
					return 1;
				}
			}
        });
        System.out.println("=========== result ============");
        printPhotos(photosList);
        
        StringBuffer resultBuilder = new StringBuffer();
        for ( Photo p : photosList ) {
        	resultBuilder.append(p.getNewName()).append(System.lineSeparator());
        }
        return resultBuilder.toString();
    }
	private static void printPhotos(List<Photo> photosList) {
		for ( Photo p : photosList ) {
			System.out.println(p);
		}
	}

	private static String getLeadingZeros(int cityNum, int orderLength) {
		
		int curLen = getOrderLength(cityNum);
		StringBuffer leadingZeros = new StringBuffer();
		for ( int i = 0 ; i < orderLength - curLen ; i++ ) {
			leadingZeros.append("0");
		}
		return leadingZeros.toString();
	}
	private static Integer getOrderLength(Integer cityNum) {
		int tmp = cityNum / 10;
		if ( tmp == 0 ) {
			return 1;
		} else if ( tmp == 10 ) {
			return 3;	// In case of 100
		} else {
			return 2;
		}
	}

	/*
	 * #3 엘리베이터 앞에 사람들이 줄을 서있음. 큐에 있음. 
	 * 한번에 엘리베이터에 탈 수 있는 무게, 인원수 제한이 있으며 엘리베이터가 몇 번이나 stop을 하는지 리턴하기.
	 * 올라갔다가 다시 1층으로 오는 것도 한번의 stop으로 계산함.
	 */
	public int solution(int[] weights, int[] targetFloors, int M, int maxNumOfPeople, int maxWeight) {
        // A : 몸무게, B : 타겟 층수, M : 건물 최대 층수, X : 1회 운송 최대 인원수, Y : 1회 운송 최대 무게
		int curWeights = 0;
		int curNumOfPeople = 0;
		int stops = 0;
		
		Set<Integer> diffFloorsSet = new HashSet<>();
		for ( int i = 0 ; i < weights.length ; ) {
			curWeights += weights[i];
			curNumOfPeople += 1;
			if ( curWeights <= maxWeight && curNumOfPeople <= maxNumOfPeople ) {
				// 엘리베이터에 1명 추가로 태우기
				diffFloorsSet.add(targetFloors[i]);
				i++;
			} else {
				// 꽉 찬 엘리베이터 올려보내기
				stops += diffFloorsSet.size();
				stops++;	// 1층으로 돌아오기
				
				curWeights = 0;
				curNumOfPeople = 0;
				diffFloorsSet.clear();
			}
		}
		if ( curWeights > 0) {
			// 꽉 차지 않은 엘리베이터 올려보내기
			stops += diffFloorsSet.size();
			stops++;	// 1층으로 돌아오기
		}
		return stops;
    }
	
	/*
	 * #4 버그 고치기. max 3줄만 수정 가능
	 */
	static int solution4(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
//            } else {
//                l = m;
//            }
            } else if ( A[m] == X ) {	// 수정라인 1
        		return m;	// 수정라인 2
        	} else { l = m + 1; }	// 수정라인 3
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		// #1
//		System.out.println(solution1("1001"));
//		System.out.println(solution1("1111011001"));
//		System.out.println(solution1("1111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001111101100111110110011111011001"));
	
		// #2
		String test2 = "photo.jpg, Warsaw, 2013-09-05 14:08:15\r\n" + 
				"john.png, London, 2015-06-20 15:13:22\r\n" + 
				"myFriends.png, Warsaw, 2013-09-05 14:07:13\r\n" + 
				"Eiffel.jpg, Paris, 2015-07-23 08:03:02\r\n" + 
				"pisatower.jpg, Paris, 2015-07-22 23:59:59\r\n" + 
				"BOB.jpg, London, 2015-08-05 00:02:03\r\n" + 
				"notredame.png, Paris, 2015-09-01 12:00:00\r\n" + 
				"me.jpg, Warsaw, 2013-09-06 15:40:22\r\n" + 
				"a.png, Warsaw, 2016-02-13 13:33:50\r\n" + 
				"b.jpg, Warsaw, 2016-01-02 15:12:22\r\n" + 
				"c.jpg, Warsaw, 2016-01-02 14:34:30\r\n" + 
				"d.jpg, Warsaw, 2016-01-02 15:15:01\r\n" + 
				"e.png, Warsaw, 2016-01-02 09:49:09\r\n" + 
				"f.png, Warsaw, 2016-01-02 10:55:32\r\n" + 
				"g.jpg, Warsaw, 2016-02-29 22:13:11";
//		System.out.println(solution2(test2));
		
		// #4
		System.out.println(solution4(new int[] {1, 2, 5, 9, 9}, 5));
	}
	static class Photo {
		private int order;
		private String fileName;
		private String city;
		private String dttm;
		private String newName;
		
		Photo(int order, String fileName, String city, String dttm){
			this.order = order;
			this.fileName = fileName;
			this.city = city;
			this.dttm = dttm;
		}
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public String getNewName() {
			return newName;
		}
		public void setNewName(String newName) {
			this.newName = newName;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDttm() {
			return dttm;
		}
		public void setDttm(String dttm) {
			this.dttm = dttm;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Photo [order=");
			builder.append(order);
			builder.append(", fileName=");
			builder.append(fileName);
			builder.append(", city=");
			builder.append(city);
			builder.append(", dttm=");
			builder.append(dttm);
			builder.append(", newName=");
			builder.append(newName);
			builder.append("]");
			return builder.toString();
		}
	}
}
