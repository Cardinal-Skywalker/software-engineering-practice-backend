package com.springboot.springboot.utils;

import com.springboot.springboot.domain.Student;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<Student> excelToStudent(MultipartFile file){
        // 新建一个list，用于存放解析结果
        List<Student> list=new ArrayList<>();
        try {
            // 拿到对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            // 一个excel可能有多个sheet,所以遍历sheet
            for (int i = 0; i <workbook.getNumberOfSheets() ; i++) {
                // 拿到sheet对象
                HSSFSheet sheet = workbook.getSheetAt(i);
//                System.out.println("行数"+sheet.getPhysicalNumberOfRows());
                // 遍历每一行
                for (int j = 0; j <sheet.getPhysicalNumberOfRows() ; j++) {
                    //略过首行，即标题行
                    if(j==0){
                        continue;
                    }
                    // 拿到行的对象
                    HSSFRow row = sheet.getRow(j);
                    // 即使你的表格中没有空行，但也可能会被解析出一些空行，所以我们略过空行，否则会报错
                    if (row==null){
                        continue;
                    }
//                    System.out.println("列数"+row.getPhysicalNumberOfCells());
                    // new一个自己的实体类的对象，方便一会儿将解析出来的值存放进去
                    Student Student = new Student();
                    // 注意下面这种方法是最简单但是也最死板的方法，就是固定excel的表头
                    // 每一列只能是对应的字段。一旦excel的某两列相互替换一下位置
                    // 那么写入Student的值就乱了

                    // 遍历一行中的每一个单元格
                    for (int k = 0; k <row.getPhysicalNumberOfCells() ; k++) {
                        // 写固定了，每一列内容不能变
                        if(k==0){
                            //id
                            row.getCell(k).setCellType(CellType.STRING);
                            Student.setId(Long.parseLong(row.getCell(k).getStringCellValue()));
                        }
                        else if(k==1){
                            //njuid
                            row.getCell(k).setCellType(CellType.STRING);
                            Student.setNjuid(row.getCell(k).getStringCellValue());
                        }
                        else if(k==2){
                            // name
                            row.getCell(k).setCellType(CellType.STRING);
                            Student.setSname(row.getCell(k).getStringCellValue());
                        }
                        else if(k==3){
                            // photo
                            row.getCell(k).setCellType(CellType.STRING);
                            Student.setPhoto(row.getCell(k).getStringCellValue());
                        }
                        else ;
                    }
                    // 将Student对象添加到list中
                    list.add(Student);
//                    System.out.println(Student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}


