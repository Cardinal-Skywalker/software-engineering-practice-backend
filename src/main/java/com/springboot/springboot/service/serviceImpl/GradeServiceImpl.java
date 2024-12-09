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
}
