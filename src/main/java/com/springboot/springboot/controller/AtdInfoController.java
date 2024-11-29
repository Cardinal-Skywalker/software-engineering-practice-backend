package com.springboot.springboot.controller;

import com.springboot.springboot.domain.AtdInfo;
import com.springboot.springboot.service.AtdInfoService;
import com.springboot.springboot.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class AtdInfoController {
    @Resource
    private AtdInfoService atdInfoService;

    @GetMapping("/attendanceInfo")
    public Result<AtdInfo[]> displayController(){
        AtdInfo[] atdInfos = new AtdInfo[50];
        for(Integer i = 1;i<51;i++){
            AtdInfo atdInfo = atdInfoService.displayAtdInfoService(i);
            if(atdInfo!=null){
                atdInfos[(int) i-1] = atdInfo;
            }
        }
        return Result.success(atdInfos);
    }
}
