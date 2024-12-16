package com.springboot.springboot.controller;

import com.springboot.springboot.domain.Grade;
import com.springboot.springboot.service.GradeService;
import com.springboot.springboot.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class GradeController {
    @Resource
    private GradeService gradeService;

    @GetMapping("/grade")
    public Result<Grade[]> displayController(){
        Grade[] grades = new Grade[50];
        for(int i=0;i<50;i++){
            Grade grade = gradeService.displayGradeService(i);
            if(grade!=null){
                grades[i] = grade;
            }
        }
        return Result.success(grades);
    }

    @PostMapping("/gradeimport")
    public Result<Grade> importController(@RequestParam String njuid, @RequestParam String middle, @RequestParam String finall){
        System.out.println("收到成绩信息");
        Grade newGrade = new Grade(njuid,middle,finall);
        Grade resGrade = gradeService.saveByNjuid(newGrade);
        return Result.success(resGrade);
    }
}
