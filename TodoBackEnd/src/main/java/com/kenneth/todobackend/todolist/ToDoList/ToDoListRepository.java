package com.kenneth.todobackend.todolist.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;

// define repository interface, handled by spring boot "magic"
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {
}
