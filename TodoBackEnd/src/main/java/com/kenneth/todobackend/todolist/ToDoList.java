package com.kenneth.todobackend.todolist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// define an entity
@Entity
// specify the tabel
@Table(name="lists")
public class ToDoList {
  // define the id
  @Id
  // use as generated value
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer list_id;
  private String name;
  // define one to many, mapped by other objects "list" property
  @OneToMany(mappedBy="list")
  // ignore the list to prevent recursion
  @JsonIgnore()
  private Set<ListItem> items = new HashSet<ListItem>() {
  };

  public Integer getList_id() {
    return list_id;
  }

  public void setList_id(Integer list_id) {
    this.list_id = list_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<ListItem> getItems() {
    return items;
  }

  public void setItems(Set<ListItem> items) {
    this.items = items;
  }
}
