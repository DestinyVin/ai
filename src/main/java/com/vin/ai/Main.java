package com.vin.ai;

import java.io.File;
import java.io.IOException;

import com.vin.ai.utils.FileUtils;

public class Main {

	public static void main(String[] args) throws IOException{

		long start = System.currentTimeMillis();
		System.out.println();
		File mainFile = FileUtils.findFileBy("Main.java", FileUtils.getFile("./"));
		System.out.println("==============================");
		System.out.println("file:" + mainFile.getAbsolutePath());
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));

		start = System.currentTimeMillis();
		System.out.println();
		File testFile = FileUtils.findFileBy("Test.java", FileUtils.getFile("./"));
		System.out.println("==============================");
		System.out.println("file:" + testFile.getAbsolutePath());
		end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));

		// 输出文件内容
		start = System.currentTimeMillis();
		String content = FileUtils.readFileToString(mainFile);
		System.out.println(content);
		end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));

		// 将内容输入到文件
		start = System.currentTimeMillis();
		content = content.replaceAll("Main", "Test");
		FileUtils.writeStringToFile(testFile, content);
		end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
	}

}
