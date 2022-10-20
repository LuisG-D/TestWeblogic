package com.todo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TareaService {
    
    @Autowired
    private TareaRepository repo;
    
    /**Obtenemos todas las tareas
     * */
    public List<Tarea> getAll(){
	List<Tarea> task = repo.findAll();
	if(task.isEmpty()) {
	    //Si la lista esta vacia nos lanzara un badrequest
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Portatils not found");
	}
	
	return repo.findAll().parallelStream().map(Tarea::list).collect(Collectors.toList());
		
	//return repo.findAll().parallelStream().map(Tarea::create).collect(Collectors.toList());
    }
    
    public ResponseEntity<Tarea> addNewTask(@RequestBody Tarea tarea){
	Tarea task = Tarea.builder().complete(false).name("Test").build();
	
	return ResponseEntity.ok(repo.save(task));
	
	
	
    }

}
