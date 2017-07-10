package com.lujx.itext.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月9日
 */
public class HtmlHello1 {

	public static final String DEST = "/Users/lujx/Documents/parse/index.pdf";
	public static final String HTML = "/Users/lujx/Documents/parse/index.html";

	public static void main(String[] args) throws IOException,
			DocumentException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new HtmlHello1().createPdf(DEST);
	}

	/**
	 * Creates a PDF with the words "Hello World"
	 * 
	 * @param file
	 * @throws IOException
	 * @throws DocumentException
	 */
	public void createPdf(String file) throws IOException, DocumentException {
		// step 1
		Document document = new Document();
		// step 2
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(file));
		// step 3
		document.addAuthor("陆金星");
		document.addTitle("hello title");
		document.addSubject("zhuti");
		document.addKeywords("itext");
		document.open();
		// step 4
		XMLWorkerHelper.getInstance().parseXHtml(writer, document,
				new FileInputStream("index.html"));
		// step 5
		document.close();
		System.out.println("PDF Created!");
	}
}
