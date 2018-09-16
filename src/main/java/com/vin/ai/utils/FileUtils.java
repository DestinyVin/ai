package com.vin.ai.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

public class FileUtils extends org.apache.commons.io.FileUtils {

	private static String pre = "\t";

	/***
	 * 在指定目录下搜索指定文件
	 *
	 * @param fileName
	 *            指定文件
	 * @param startFilePath
	 *            指定目录
	 * @return 若找到，则返回指定文件；否则返回指定目录
	 */
	public static File findFileBy(String fileName, File startFilePath) {

		File file = startFilePath;

		String pre2 = pre;
		pre += "\t";
		if (StringUtils.isNotEmpty(fileName)) {

			File[] files = file.listFiles();
			System.out.println();
			System.out
					.println(pre + "------------------" + "开始搜索File:" + file.getAbsolutePath() + "------------------");
			System.out.println(pre + "[");
			for (int i = 0; i < files.length; i++) {
				System.out.println(pre + "File[" + i + "]:" + files[i].getAbsolutePath());
				if (files[i].isDirectory()) {
					System.out
							.println(pre + "开始在File[" + i + "]:" + files[i].getAbsolutePath() + "中搜索File:" + fileName);
					file = findFileBy(fileName, files[i]);
				}
				if (fileName.equals(file.getName())) {
					System.out.println("找到File：" + fileName + ",位置：" + files[i].getAbsolutePath() + ";结束搜索。");
					return file;
				}

				if (fileName.equals(files[i].getName())) {
					System.out.println("找到File：" + fileName + ",位置：" + files[i].getAbsolutePath() + ";结束搜索。");
					return files[i];
				}

			}
			System.out.println(pre + "]");
			System.out
					.println(pre + "------------------" + "结束搜索File:" + file.getAbsolutePath() + "------------------");
			pre = pre2;
		} else {
			System.out.println(pre + "无指定文件");

		}
		if (startFilePath == file) {
			System.out.println(pre + "无指定文件");
		}
		return file;
	}

	/***
	 * 输出文件内容
	 ***/
	public static String printFileContent(File file) throws IOException {

		FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String fileContent = null;
		String str = null;

		while ((str = bufferedReader.readLine()) != null) {
			fileContent = str;
		}

		// close
		inputStream.close();
		bufferedReader.close();

		return fileContent;
	}

}
