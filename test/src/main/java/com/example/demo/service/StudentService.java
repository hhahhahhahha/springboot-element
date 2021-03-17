package com.example.demo.service;


import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StudentService {
    @Resource
    StudentRepository studentRepository;
    public void save(Student student){
        studentRepository.save(student);
    }
    public void add(Student student){ studentRepository.save(student);}
    public void delete(Integer id){
        studentRepository.deleteById(id);
    }
    public Student findById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Page<Student> findPage(Integer pageNum, Integer pageSize) {
        // 构建分页查询条件
        //Sort sort = new Sort(Sort.Direction.DESC, "create_time");
        Pageable pageRequest = PageRequest.of(pageNum - 1, pageSize);
        return studentRepository.findAll(pageRequest);
    }


}
