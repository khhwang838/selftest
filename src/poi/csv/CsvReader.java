package poi.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.supercsv.io.CsvListReader;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListReader;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

/**
 * POI 라이브러리로는 CSV 파일을 읽을 수 없다. 
 * OpenCSV는 EUC-KR 인코딩을 사용해야하며, 이 경우 깨지는 한글이 존재함 (딲, ㅎㅇ, etc.)
 * 테스트 결과 SuperCSV도 마찬가지이며, utf-8 인코딩 사용시 엑셀에서 csv파일을 열면 한글이 깨지고, 메모장에서 열면 정상적으로 출력됨
 * @author Kihyun
 * @created   2018-03-05
 */
public class CsvReader {

	public static void main(String[] args) throws IOException {
//		String filepath = "D:\\kihyun\\z50. projects\\KT_AIBOT\\테스트\\chat (1).csv";
		String filepath = "D:\\kihyun\\z50. projects\\KT_AIBOT\\테스트\\chat_test.csv";
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			File file = new File(filepath);
			try {
				fileOutputStream = new FileOutputStream(filepath);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		ICsvListWriter listWriter = new CsvListWriter(new OutputStreamWriter(fileOutputStream, "utf-8"), CsvPreference.STANDARD_PREFERENCE);
		listWriter.write("딲는법", "(ㅎㅇ|하이)");
		listWriter.close();
		
		ICsvListReader listReader = null;
        try {
        	listReader = new CsvListReader(new InputStreamReader(new FileInputStream(filepath), "utf-8"), CsvPreference.STANDARD_PREFERENCE);
        	List<String> line = null;
        	while ( (line = listReader.read()) != null  ) {
        		System.out.println(line.get(0));
        		System.out.println(line.get(1));
        	}
        }catch( Throwable th) {
        	th.printStackTrace();
        }
	}
}
