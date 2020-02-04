package com.scms.learn.file;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

/**
 * @ClassName: AnalysisTxtFile
 * =================================================
 * @Description: 解析TXT的内容
 * BufferedReader是为了提供读的效率而设计的一个包装类，它可以包装字符流。可以从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
 *
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/4 19:40
 * @Version: V1.0
 */
public class AnalysisTxtFile {

    /**
     * 文件路径
     */
    private static String PATH = "F:\\a.txt";

    public static void main(String[] args) {
        readFile(PATH);
    }

    public static void readFile(String url){
        try {
            //读取
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            String s = null;
            int i = 0;
            //1.创建一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.获取sheet页
            HSSFSheet sheet = workbook.createSheet();
            while ((s = br.readLine())!=null){
                String[] split = s.split("\\$");
                //3.将数据写入Excel
                HSSFRow row = sheet.createRow(i);
                for (int j = 0; j < split.length; j++) {
                    row.createCell(j).setCellValue(split[j]);
                }
                i++;
            }
            //4.创建输出文件
            FileOutputStream os = new FileOutputStream("F:\\a.xls");
            workbook.write(os);
            os.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
