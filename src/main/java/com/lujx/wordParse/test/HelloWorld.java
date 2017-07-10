package com.lujx.wordParse.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月7日
 */
public class HelloWorld {
	public static void main(String[] args) throws Exception {
		String path = "/Users/lujx/Documents/";
		ByteArrayInputStream bais = null;
		FileOutputStream fos = null;
		try {
			if (!"".equals(path)) {
				File fileDir = new File(path);
				if (fileDir.exists()) {
					String content = readFile(path + "/qyer.html");
					byte b[] = content.getBytes();
					bais = new ByteArrayInputStream(b);
					POIFSFileSystem poifs = new POIFSFileSystem();
					DirectoryEntry directory = poifs.getRoot();
					DocumentEntry documentEntry = directory.createDocument(
							"WordDocument", bais);
					fos = new FileOutputStream(path + "大数据2.doc");
					poifs.writeFilesystem(fos);
					bais.close();
					fos.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				fos.close();
			if (bais != null)
				bais.close();
		}
	}

	public static String readFile(String filename) throws Exception {
		StringBuffer buffer = new StringBuffer("");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			buffer = new StringBuffer();
			while (br.ready())
				buffer.append((char) br.read());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		return buffer.toString();
	}
}
