package com.kenneth.todobackend.todolist.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Define as rest controller
@RestController
// Define route mapping
@RequestMapping("/list")
public class ToDoListController {

  // autowire service
  @Autowired
  private ToDoListService toDoListService;

  // Create
  @PostMapping(value="/")
  public ToDoList addList(@RequestBody ToDoList list)
  {
    return toDoListService.addList(list);
  }

  // Read
  @GetMapping(value="/{list_id}")
  public Optional<ToDoList> getList(@PathVariable("list_id") Integer id) {
    return toDoListService.getList(id);
  }

  // Update
  @PutMapping()
  public ToDoList updateList(@RequestBody ToDoList list) {
    return toDoListService.updateList(list);
  }

  // Delete
  @DeleteMapping(value="/{list_id}")
  public String deleteList(@PathVariable("list_id") Integer id) {
    toDoListService.deleteList(id);
    return "Delete Successful";
  }

}
