package org.infinispan.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {

        private static final long serialVersionUID = -6821956826211035839L;

    private String name;

    @Id
    private String id;

    public Person() {
        
    }
    public Person(String id, String name) {
            this.id = id;
            this.name = name;
    }
    public String getName() {
           return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
