package com.kenneth.todobackend.todolist.ListItem;

import com.kenneth.todobackend.todolist.ToDoList.ToDoList;
import com.kenneth.todobackend.todolist.ToDoList.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ListItemController {

  @Autowired
  private ListItemService listItemService;

  @Autowired
  private ToDoListService toDoListService;

  // Create
  @PostMapping("")
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

  // Read
  @GetMapping("/{item_id}")
  // return a list item or null based off id query using path variable
  public Optional<ListItem> getListItem(@PathVariable("item_id") Integer id) {
    return listItemService.getListItem(id);
  }
  // return all items
  @GetMapping("/all/{list_id}")
  public Iterable<ListItem> getAllItemsInList(@PathVariable("list_id") Integer id) {
    ToDoList list = toDoListService.getList(id).get();
    return list.getItems();
  }

  // Update
  @PutMapping("/")
  public ListItem updateListItem(@RequestBody ListItem listItem) {
    return listItemService.updateListItem(listItem);
  }

  // Delete
  @DeleteMapping("/{list_id}")
  public void deleteListItem(@PathVariable("list_id") Integer id){
    listItemService.deleteListItem(id);
  }


}
