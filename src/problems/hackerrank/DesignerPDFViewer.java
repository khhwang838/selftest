package problems.hackerrank;

public class DesignerPDFViewer {

	public static void main(String[] args) {
		
	}
	
	static int designerPdfViewer(int[] h, String word) {
		char[] wordChars = word.toCharArray();
		int maxHeight = 0;
		for(char c : wordChars) {
			int height = h[(int)c - 97];
			if(height > maxHeight) {
				maxHeight = height;
			}
		}
		return maxHeight * word.length();
    }
}
