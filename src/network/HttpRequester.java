package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Http 요청을 위한 컴포넌트
 * @author dev
 *
 */
public class HttpRequester {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 특정 URL로 HTTP POST 요청하기
	 * @param jsonMsg
	 * @param destUrl
	 * @return
	 * @throws IOException
	 */
	public String sendGetRequest(String params, String destUrl) throws IOException {
		StringBuffer response = new StringBuffer();
		HttpURLConnection conn = null;
		OutputStream wr = null;
		BufferedReader br = null;
		
		try {
			
			// TODO : destUrl + params
			
			URL url = new URL(destUrl+params);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			conn.setUseCaches(false);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "euc-kr"));

			String output;

			while ((output = br.readLine()) != null) {
				response.append(output);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if ( conn != null )
				conn.disconnect();
			if ( wr != null )
				wr.close();
			if ( br != null )
				br.close();
		}
		return response.toString();
	}
	
	/**
	 * 특정 URL로 HTTP POST 요청하기
	 * @param jsonMsg
	 * @param destUrl
	 * @return
	 * @throws IOException
	 */
	public String sendPostRequest(String jsonMsg, String destUrl) throws IOException {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection conn = null;
		OutputStream wr = null;
		BufferedReader br = null;
		
		try {

			URL url = new URL(destUrl);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			conn.setUseCaches(false);
			
			// Send post request
			conn.setDoOutput(true);
			wr = conn.getOutputStream();

			wr.write(jsonMsg.getBytes());
			wr.flush();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;

			while ((output = br.readLine()) != null) {
				sb.append(output);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if ( conn != null )
				conn.disconnect();
			if ( wr != null )
				wr.close();
			if ( br != null )
				br.close();
		}
		return sb.toString();
	}
	
	
}
