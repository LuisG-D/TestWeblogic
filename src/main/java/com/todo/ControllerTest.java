package com.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
    @Autowired
    private TareaService service;

    @GetMapping("/dame")
    public List<Tarea> getAll(){
	return service.getAll();
    }
    
    @PostMapping("/add")
    public ResponseEntity<Tarea> addTask(@RequestBody Tarea tarea)
    {
	return this.service.addNewTask(tarea);
    }
    @GetMapping("/test")
    public String agetAll(){
	return "Probando...1..2..3..";
    }

}
