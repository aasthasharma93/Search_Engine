package mySearchEngine;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.*;

public class HtmtTextConvertor {
	public static File inputDir = new File(Settings.HTML_FILES_DIR);
	public static File outputDir = new File(Settings.TEXT_FILES_DIR);

	public static void main(String[] args) throws IOException {
		HtmtTextConvertor convertor = new HtmtTextConvertor();
		convertor.scanFolder(inputDir);
		System.out.println("files converted to text and saved..");
	}

	public void scanFolder(File folder) throws IOException
	{
		for (final File fileName : folder.listFiles()) {	
			if (fileName.isFile()) {
				convertFileToText(fileName.getName());
			}
		}
	}

	private void convertFileToText(String inputfilename) throws IOException {
		String[] fName = inputfilename.split("\\.htm");
		String fileName = fName[0];
		if (!outputDir.exists()) {
			System.out.println("creating directory: " + outputDir);
			boolean result = outputDir.mkdir();
			if (result) {
				System.out.println("DIR created");
			}
		}
		File inputFile = new File(Settings.HTML_FILES_DIR + "/" + inputfilename);
		org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8", "");	
		String outputFileName = Settings.TEXT_FILES_DIR + fileName+ ".txt";
		String text = doc.text();
		PrintWriter out = new PrintWriter(outputFileName);
		out.println(text);
		out.close();
	}
}
