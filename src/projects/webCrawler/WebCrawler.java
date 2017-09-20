package projects.webCrawler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.regex.Pattern;

public class WebCrawler {

	static char[] data = new char[70000];
	
	public static void main(String[] args) throws Exception {

		int thNum = 611;
		String url = "http://www.nlotto.co.kr/lotto645Confirm.do?method=byWin&drwNo="
				+ String.valueOf(thNum);
		getLottoNum(url, thNum);
	}
	
	public static void getLottoNum(String url, int thNum) throws Exception{
		
		URL urlObj;
		InputStream is = null;
		InputStreamReader isr = null;
		
		try {
			urlObj = new URL(url);

			is = urlObj.openStream();
			isr = new InputStreamReader( is, "euc-kr");

			Thread.sleep(10);
			isr.read(data);

			String dataStr = String.valueOf(data);
			
			isr.close();
			is.close();
			
			int beginIndex = dataStr.indexOf("당첨번호 start");
			int endIndex = dataStr.indexOf("당첨번호 end");

			dataStr = dataStr.substring(beginIndex, endIndex);

			System.out.println(dataStr);

			int[] number = new int[6];
			for (int i = 0; i < 6; i++) {
				String num = dataStr.split(Pattern.quote("ball_"))[i + 1]
						.split(Pattern.quote(".png"))[0];

				number[i] = Integer.valueOf(num);

			}
			System.out.println(" Lotto Number for " + thNum + " : ");
			for(int i : number) System.out.print( String.valueOf(i) + " ");

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			if(isr != null)
				isr.close();
			if(is != null)
				is.close();
			Thread.sleep(1000);
			System.out.println(" sleeping...");
			getLottoNum(url, thNum);
			System.exit(0);
		}
	}
}
