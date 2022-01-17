package com.kenneth.todobackend.todolist.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Service annotation
@Service
public class ToDoListService {

  // Autowire the repository
  @Autowired
  private ToDoListRepository toDoListRepository;

  // method to get the list
  public Optional<ToDoList> getList(Integer id) {
     return toDoListRepository.findById(id);
  }

  // method to add a new list
  public ToDoList addList(ToDoList list) {
    return toDoListRepository.save(list);
  }

  // method to delete a list
  public void deleteList(Integer id) { toDoListRepository.deleteById(id);}

  // method to update a list
  public ToDoList updateList(ToDoList list) {
    return toDoListRepository.save(list);
  }
}
