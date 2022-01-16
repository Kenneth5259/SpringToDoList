package com.kenneth.todobackend.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/list")
public class ToDoListController {

  @Autowired
  private ToDoListService toDoListService;

  @GetMapping(value="/{id}")
  public Optional<ToDoList> getByName(@PathVariable("id") Integer id) {
    return toDoListService.getList(id);
  }

  @PostMapping(value="/add")
  public ToDoList addNewList(@RequestBody ToDoList list)
  {
    return toDoListService.addList(list);
  }

}
