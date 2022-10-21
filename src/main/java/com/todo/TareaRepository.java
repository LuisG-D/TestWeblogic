package com.todo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {

    	
    Optional<Tarea> findByName(String name);
    
}
