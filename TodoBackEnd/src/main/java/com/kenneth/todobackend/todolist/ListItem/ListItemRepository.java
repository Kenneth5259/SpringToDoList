package com.kenneth.todobackend.todolist.ListItem;

import org.springframework.data.jpa.repository.JpaRepository;

// define a list item repository, handled by spring boot "magic"
public interface ListItemRepository extends JpaRepository<ListItem, Integer> {
}
