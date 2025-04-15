package DDTPractice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class DDTByPDF {

	public static void main(String[] args) throws IOException {
	
		File file = new File("./src/test/resources/IntroductionToHTML.pdf") ;
		
		PDDocument doc= PDDocument.load(file);

		
		//Reading number of pages in pdf
		int pages=doc.getNumberOfPages();
		System.out.println(pages);
		
		
//		//Reading complete data present in the pdf
		PDFTextStripper pdf= new PDFTextStripper();
//		String completePdf = pdf.getText(doc);
//		System.out.println(completePdf);
		
		
		//Read particular page
		pdf.setStartPage(2);
		pdf.setEndPage(3);
		String particularPage = pdf.getText(doc);
		System.out.println(particularPage);
	}

}
