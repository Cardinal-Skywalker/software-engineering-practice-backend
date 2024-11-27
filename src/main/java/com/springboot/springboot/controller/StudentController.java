package com.springboot.springboot.controller;

import com.springboot.springboot.domain.Attendance;
import com.springboot.springboot.domain.Student;
import com.springboot.springboot.service.StudentService;
import com.springboot.springboot.utils.ExcelUtils;
import com.springboot.springboot.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/attendance")
    public Result<Student[]> displayController(){
        Student[] students = new Student[50];
        for(long i=1;i<51;i++){
            Student stu=studentService.displayStudentService(i);
            if(stu!=null){
                students[(int) (i-1)]=stu;
            }
        }
        return Result.success(students);
    }

    @PostMapping ("/import")
    public Result<String> importExcel(MultipartFile file){
        System.out.println("收到文件");
        List<Student> students = ExcelUtils.excelToStudent(file);
        for(Student stu:students){
            Attendance attendance = new Attendance(stu);
            //System.out.println(stu);
            studentService.save(stu,attendance);
        }
        return Result.success("导入成功");
    }
}
