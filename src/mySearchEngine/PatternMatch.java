package mySearchEngine;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;

public class PatternMatch {
	
	private static File folder = new File(Settings.TEXT_FILES_DIR);	
	
	public static void main( String args[] ) throws IOException{
		String search_pattern = "(.*)Standards Participate Membership About W3C Site(.*)";
		Pattern p_search = Pattern.compile(search_pattern, Pattern.CASE_INSENSITIVE);
		System.out.println("found in text files are below: ");
		findMatch(p_search);
	}

	public static void findMatch(Pattern search_pattern) {
		File[] listOfF = folder.listFiles();
		for (int i = 0; i < listOfF.length; i++) {
			File file = listOfF[i];
			if (file.isFile() && file.getName().endsWith(".txt")) {
				String file_content;
				try {
					file_content = FileUtils.readFileToString(file);
					String textofFile = Jsoup.parse(file_content.toString()).text();				
					System.out.print("Return Value :" );
					System.out.println(textofFile.matches("(.*)W3C technical report development process(.*)"));

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}