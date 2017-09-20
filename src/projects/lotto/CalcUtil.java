package projects.lotto;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CalcUtil {

	static int min = Integer.MAX_VALUE;
	static int max = 0;
	final static int NUM = 10; // TOP, BOT, MID 리스트에 넣을 숫자의 개수 ( 리스트마다 개수는 조금씩 차이를 두었음 )
	final static int MIN_MATCH_CNT = 3;
	final static int MAX_MATCH_CNT = 4;
	final static int numOfLottos = 5; // 생성할 로또 조합의 개

	static char[] data = new char[70000];
	
	public static int[] getWinNumber(int thNum) throws Exception {
		System.out.println("getting win number of " + thNum);
		String url = Constants.url + String.valueOf(thNum);
		return getLottoNum(url);
	}

	private static int[] getLottoNum(String url) throws Exception {

		URL urlObj;
		InputStream is = null;
		InputStreamReader isr = null;
		String dataStr = null;
		try {
			urlObj = new URL(url);

			is = urlObj.openStream();
			isr = new InputStreamReader(is, "euc-kr");

			Thread.sleep(100);
			while(isr.ready()){
				isr.read(data);
				dataStr += String.valueOf(data);
			}

			isr.close();
			is.close();

			int beginIndex = dataStr.indexOf("당첨번호 start");
			int endIndex = dataStr.indexOf("당첨번호 end");

			dataStr = dataStr.substring(beginIndex, endIndex);

			int[] number = new int[6];
			for (int i = 0; i < 6; i++) {
				String num = dataStr.split(Pattern.quote("ball_"))[i + 1]
						.split(Pattern.quote(".png"))[0];

				number[i] = Integer.valueOf(num);

			}
			
			return number;
		}catch(Exception e){
			throw new Exception(e);
		}
	}
	
	// 가장 최근 1등 당첨 번호 조회 
	public static int[] getRecentWinNumber() throws Exception {
		
		int[] winNum = CalcUtil.getWinNumber(getRecentThNum());
		for(Integer i : winNum)System.out.print(i + " ");
		System.out.println();
		
		return winNum;
	}
	
	// 가장 최근 당첨 회차 계산 
	public static int getRecentThNum(){
		
		Date firstDate = Date.valueOf("2002-12-07");
		Date currentDate = new Date(System.currentTimeMillis());
		
		int thNum = Integer.valueOf(String.valueOf((currentDate.getTime() -  firstDate.getTime()) / (86400000 * 7) + 1));
		
		return thNum;
	}
	public static int[] calcNextLottoNum(Data data) {

		// 각 숫자 별 출현 빈도
		// for(int i = 0; i < data.getData1().length ; i++){
		// System.out.print(String.format("[%2d] : %2d  ", i+1,
		// data.getData1()[i]) );
		// if( (i+1) % 5 == 0 )
		// System.out.println();
		// }

		// 보너스 숫자 출현 빈도
		// for(int i = 0; i < data.getBonusData1().length ; i++){
		// System.out.print(String.format("[%2d] : %2d  ", i+1,
		// data.getBonusData1()[i]) );
		// if( (i+1) % 5 == 0 )
		// System.out.println();
		// }

		ArrayList<Integer> topList = new ArrayList<Integer>();
		ArrayList<Integer> bottomList = new ArrayList<Integer>();
		ArrayList<Integer> midList = new ArrayList<Integer>();

		for (int i = 0; i < NUM; i++) {
			makeRatedNumberLists(topList, bottomList, midList, data.getData2());
		}

		// 뜨거운 숫자들
		System.out.println("TOP " + topList.size() + ": \t" + topList);
		// 미지근 숫자들
		for (int i = 0; i < 45; i++) {
			if (!topList.contains(i + 1) && !bottomList.contains(i + 1))
				midList.add(i + 1);
		}
		System.out.println("MID " + midList.size() + ": \t" + midList);
		// 차가운 숫자들
		System.out.println("BOT " + bottomList.size() + ": \t" + bottomList);


		int[] out;

		int matchedCnt = 0;
		int countSum = 0;
		int count = 1;
		System.out.println("=======================");
		while (true) {
			out = generateLottoNumber(topList, midList, bottomList);
			MatchInfo mi = getMatchInfo(out, ExcelReader.data, 1);
			
			if (mi.getMaxMatchCnt() >= MIN_MATCH_CNT && mi.getMaxMatchCnt() < MAX_MATCH_CNT && sum(out) > 100 && sum(out) < 200) {
				++matchedCnt;
				countSum += count;
				{
					Arrays.sort(out);
					System.out.print(sum(out) + "\t" + Arrays.toString(out)
							+ "      \t" + mi.getMaxMatchCnt());
				}
				System.out.println("   \tCount : " + count + "    \tAvg. Count : "
						+ (int)Math.round((double)countSum / matchedCnt) + "    \tMatch Count : " + mi.getMatchCnt().size());
				
//				생성된 숫자와 유사한 기존 1등 당첨 숫자들 리스트 출력
//				for(int index = 0; index < mi.getMatchNumList().size() ; index++){
//					System.out.println("\t" + mi.getMatchThNum().get(index) + "\t" + Arrays.toString(mi.getMatchNumList().get(index)));
//				}
				count = 0;
			}
			if (matchedCnt == numOfLottos ) {
				break;
			}
			count++;
		}
		return out;
	}

	private final static int sum(int[] data){
		int sum = 0;
		for (int i : data)
			sum += i;
		return sum;
	}
	/**
	 * 
	 * @param generatedNumber
	 * @param pastData
	 * @param option : 0:보너스 번호 미포함 6자리 숫자 비교, 1:보너스 번호 포함 7자리 숫자 비교
	 * @return
	 */
	private static MatchInfo getMatchInfo(int[] generatedNumber, int[][] pastData,
			int option) {

		int maxMatchCnt = 0;
		int matchCnt = 0;
		int[] rowData;

		final MatchInfo mi = new MatchInfo();
		
		for (int i = 0; i < pastData.length; i++) {
			rowData = pastData[i];
			matchCnt = compareData(generatedNumber, rowData);

			// if(matchCnt >= 5) System.out.print(" " + i + "\t회차 당첨번호");

			if (option == 1 && matchCnt >= MIN_MATCH_CNT){
				if(maxMatchCnt < matchCnt)
					mi.setMaxMatchCnt(matchCnt);
				mi.getMatchCnt().add(matchCnt);
				mi.getMatchNumList().add(rowData);
				mi.getMatchThNum().add(i + 1);
				
			}
			else if (option == 0 && matchCnt > maxMatchCnt){
				maxMatchCnt = matchCnt;
			
				
			}
		}
		
		
		return mi;
	}

	private static int compareData(int[] generatedNumber, int[] rowData) {

		int matchCnt = 0;
		for (int i = 0; i < rowData.length; i++) {
			for (int j = 0; j < generatedNumber.length; j++) {
				if (generatedNumber[j] == rowData[i])
					matchCnt++;
			}
		}
		return matchCnt;
	}

	private static int[] generateLottoNumber(ArrayList<Integer> topList,
			ArrayList<Integer> midList, ArrayList<Integer> bottomList) {

		int[] out = new int[6];
		ArrayList<Integer> chosenIndexList = new ArrayList<Integer>();

		int i = 0;
		while (chosenIndexList.size() < 3) {
			int index = (int) (Math.random() * topList.size());
			if (!isExist(topList.get(index), chosenIndexList)) {
				chosenIndexList.add(topList.get(index));
				out[i++] = topList.get(index);
			}
		}
		while (chosenIndexList.size() < 5) {
			int index = (int) (Math.random() * midList.size());
			if (!isExist(midList.get(index), chosenIndexList)) {
				chosenIndexList.add(midList.get(index));
				out[i++] = midList.get(index);
			}
		}
		while (chosenIndexList.size() < 6) {
			int index = (int) (Math.random() * bottomList.size());
			if (!isExist(bottomList.get(index), chosenIndexList)) {
				chosenIndexList.add(bottomList.get(index));
				out[i++] = bottomList.get(index);
			}
		}

		return out;
	}

	private static void makeRatedNumberLists(ArrayList<Integer> topList,
			ArrayList<Integer> bottomList, ArrayList<Integer> midList,
			ArrayList<Integer> data) {

		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < data.size(); i++) {
			if ((maxValue < data.get(i)) && !isExist(i + 1, topList)
					&& !isExist(i + 1, bottomList)) {
				maxValue = data.get(i);
			} else if ((minValue > data.get(i)) && !isExist(i + 1, bottomList)
					&& !isExist(i + 1, topList)) {
				minValue = data.get(i);
			}
		}

		for (int i = 0; i < data.size(); i++) {
			if (topList.size() < (NUM * 4 / 3) && data.get(i) == maxValue) {
				topList.add(i + 1);
			} else if (bottomList.size() < NUM && data.get(i) == minValue) {
				bottomList.add(i + 1);
			} else
				;
		}
	}

	private static boolean isExist(Integer num, ArrayList<Integer> list) {

		for (Integer i : list) {
			if (num.equals(i)) {
				return true;
			}
		}
		return false;
	}
}
