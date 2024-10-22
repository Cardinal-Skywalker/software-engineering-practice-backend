package com.springboot.springboot.controller;

import com.springboot.springboot.domain.Student;
import com.springboot.springboot.service.StudentService;
import com.springboot.springboot.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/attendance")
    public Result<Student[]> displayController(){
        Student[] students = new Student[10];
        for(long i=1;i<10;i++){
            Student stu=studentService.displayStudentService(i);
            if(stu!=null){
                students[(int) (i-1)]=stu;
            }
        }
        return Result.success(students);
    }
}
