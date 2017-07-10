package com.lujx.itext.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月9日
 */
public class ITextRendererTest {
	public static void main(String[] args) throws Exception {
		String inputFile = "/Users/lujx/Documents/parse/qyer.html";
		String url = new File(inputFile).toURI().toURL().toString();
		String outputFile = "/Users/lujx/Documents/parse/render.pdf";
		OutputStream os = new FileOutputStream(outputFile);
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocument(url);

		// 解决中文支持问题
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("simsun.ttc", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);

		// // 解决图片的相对路径问题
		// renderer.getSharedContext()
		// .setBaseURL(
		// "file:/D:/Work/Demo2do/Yoda/branch/Yoda%20-%20All/conf/template/");

		renderer.layout();
		renderer.createPDF(os);

		os.close();
	}

}
