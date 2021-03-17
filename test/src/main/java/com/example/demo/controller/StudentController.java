package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.data.domain.Page;
import com.example.demo.common.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
        @Resource
    private StudentService studentService;

    @GetMapping("/page")
    public Result<Page<Student>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(studentService.findPage(pageNum,pageSize));
    }
    @GetMapping("/{id}")
    private Result<Student> findById(@RequestBody Integer id) {
        studentService.findById(id);
        return Result.success();
    }
    @GetMapping
    public Result<List<Student>> findAll() {
        return Result.success(studentService.findAll());
    }

    @PostMapping
    public Result personAdd(@RequestBody Student student) {
        studentService.save(student);
        return  Result.success();
    }
    @DeleteMapping("/{id}")
    public Result persondel(@PathVariable Integer id) {
        studentService.delete(id);
        return  Result.success();
    }
    @PutMapping
    public Result personUpdate(@RequestBody Student student) {
        studentService.save(student);
        return Result.success();
    }
}
