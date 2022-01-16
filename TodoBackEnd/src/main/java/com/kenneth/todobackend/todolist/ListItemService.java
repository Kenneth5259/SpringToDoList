package com.kenneth.todobackend.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// annotate as a service
@Service
public class ListItemService {

  // autowire the repository
  @Autowired
  private ListItemRepository listItemRepository;

  // method to add item through list item repository
  public ListItem addListItem(ListItem item) {
    return listItemRepository.save(item);
  }
  // method to get item by id through repository, return either item or null
  public Optional<ListItem> getListItem(Integer id) { return listItemRepository.findById(id);}
}
