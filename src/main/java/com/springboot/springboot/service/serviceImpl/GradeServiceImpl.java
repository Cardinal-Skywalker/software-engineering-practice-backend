package com.springboot.springboot.service.serviceImpl;

import com.springboot.springboot.domain.Grade;
import com.springboot.springboot.repository.GradeDao;
import com.springboot.springboot.service.GradeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    GradeDao gradeDao;

    @Override
    public Grade displayGradeService(int id){
        return gradeDao.findById(id);
    }
    @Override
    public Grade saveByNjuid(Grade grade){
        Grade newgrade = gradeDao.findByNjuid(grade.getNjuid());
        newgrade.setMiddle(grade.getMiddle());
        newgrade.setFinall(grade.getFinall());
        System.out.println(newgrade);
        gradeDao.save(newgrade);
        return newgrade;
    }
}
