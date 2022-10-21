package com.todo;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name="task",schema = "SYSTEM")
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seqgen")
    @SequenceGenerator(name="seqgen", sequenceName="DB_AUTOINC_SEQ")
    private Long id;
    private String name;
 
    private boolean complete;
    
   public Tarea list() {
       return new Tarea(id,name,complete);
   }
  
    
    
   
    
     
}


