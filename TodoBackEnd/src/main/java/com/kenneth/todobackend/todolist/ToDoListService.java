package com.kenneth.todobackend.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoListService {

  @Autowired
  private ToDoListRepository toDoListRepository;

  public Optional<ToDoList> getList(Integer id) {
     Optional<ToDoList> result = toDoListRepository.findById(id);
     return result;
  }

  public ToDoList addList(ToDoList list) {
    return toDoListRepository.save(list);
  }
}
