package com.kenneth.todobackend.todolist;

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

  @Autowired
  private ListItemService listItemService;

  // define get mapping
  @GetMapping(value="/{id}")
  public Optional<ToDoList> getByName(@PathVariable("id") Integer id) {
    return toDoListService.getList(id);
  }

  // define post mapping
  @PostMapping(value="/add")
  public ToDoList addNewList(@RequestBody ToDoList list)
  {
    return toDoListService.addList(list);
  }

  // define a post mapping and route if not /
  @PostMapping("item/add")
  // return a list item using information from request body (JSON)
  public ListItem addListItem(@RequestBody ListItem item) {

    // grab the id
    Integer listId = item.getList().getList_id();
    // query list from database
    ToDoList list = toDoListService.getList(listId).get();
    // assign the list to item
    item.setList(list);

    return listItemService.addListItem(item);
  }

  // define a get mapping and route if not /
  @GetMapping("item/{id}")
  // return a list item or null based off id query using path variable
  public Optional<ListItem> getListItem(@PathVariable("id") Integer id) {
    return listItemService.getListItem(id);
  }

  @GetMapping("item/all/{list_id}")
  public Iterable<ListItem> getAllItemsInList(@PathVariable("list_id") Integer id) {
    ToDoList list = toDoListService.getList(id).get();
    return list.getItems();
  }

}
