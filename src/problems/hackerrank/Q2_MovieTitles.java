package problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

public class Q2_MovieTitles {

    static String[] getMovieTitles(String substr) {
    	String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
    	int page = 1;
        int totalPages = 0;
        List<String> tmpResult = new ArrayList<>();
        
    	while(true) {
	    	
	    	String param = substr + "&page=" + page;
	    	String response;
			try {
				response = sendGetRequest(param, url);
				Gson gResp = new Gson();
				UIMovies uiMovies = gResp.fromJson(response, UIMovies.class);
                
                if ( page == 1 ){
                    totalPages = uiMovies.getTotal_pages();
                }
                List<Movie> movies = uiMovies.getData();
                for ( Movie m : movies ) {
                	tmpResult.add(m.getTitle());
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
			// response 조건에 따라 break
            if ( totalPages == page ) { 
                break;
            } else {
            	page++;
            }
    	}
    	// TODO : below code gets request timeout error
    	Collections.sort(tmpResult);
    	String[] result = new String[tmpResult.size()];
    	Arrays.sort(result);
    	return tmpResult.toArray(result);
    }
    class UIMovies {
    	String page;
    	int per_page;
    	int total;
    	int total_pages;
    	List<Movie> data;
    	
    	public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public int getPer_page() {
			return per_page;
		}
		public void setPer_page(int per_page) {
			this.per_page = per_page;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getTotal_pages() {
			return total_pages;
		}
		public void setTotal_pages(int total_pages) {
			this.total_pages = total_pages;
		}
		public List<Movie> getData() {
			return data;
		}
		public void setData(List<Movie> data) {
			this.data = data;
		}
    }
    class Movie {
		String Poster;
		String Title;
		String Type;
		String Year;
		String imdbID;
		public String getPoster() {
			return Poster;
		}
		public void setPoster(String poster) {
			Poster = poster;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		public String getYear() {
			return Year;
		}
		public void setYear(String year) {
			Year = year;
		}
		public String getImdbID() {
			return imdbID;
		}
		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}
	}
    private static String sendGetRequest(String params, String destUrl) throws IOException {
		StringBuffer response = new StringBuffer();
		HttpURLConnection conn = null;
		OutputStream wr = null;
		BufferedReader br = null;
		
		try {
			
			URL url = new URL(destUrl+params);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setUseCaches(false);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;

			while ((output = br.readLine()) != null) {
				response.append(output);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
}
