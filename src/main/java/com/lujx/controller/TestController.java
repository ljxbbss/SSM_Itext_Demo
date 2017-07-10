package com.lujx.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月7日
 */
@Controller
@RequestMapping("/tets")
public class TestController {

	@RequestMapping("/parse")
	public void parse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// word内容
		String content = "<html><body><table><tr><td>信息1</td><td>信息2</td><td>t3</td><tr></table></body></html>";
		byte b[] = content.getBytes("utf-8"); // 这里是必须要设置编码的，不然导出中文就会乱码。
		ByteArrayInputStream bais = new ByteArrayInputStream(b);// 将字节数组包装到流中
		/*
		 * 关键地方 生成word格式
		 */
		POIFSFileSystem poifs = new POIFSFileSystem();
		DirectoryEntry directory = poifs.getRoot();
		DocumentEntry documentEntry = directory.createDocument("WordDocument",
				bais);
		// 输出文件
		String fileName = "实习考核鉴定表";
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/msword");// 导出word格式
		response.addHeader("Content-Disposition", "attachment;filename="
				+ new String((fileName + ".doc").getBytes(), "iso-8859-1"));

		OutputStream ostream = response.getOutputStream();
		poifs.writeFilesystem(ostream);
		bais.close();
		ostream.close();

	}
}
