/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.todo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoH2Service;

@RestController
public class TodoController{
    @Autowired
    TodoH2Service todoH2Service;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return todoH2Service.getTodos();
    }
    @GetMapping("/todos/{Id}")
    public Todo getTodoById(@PathVariable("Id") int id){
        return todoH2Service.getTodoById(id);
    }
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){
        return todoH2Service.addTodo(todo);
    }
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo){
        return todoH2Service.updateTodo(id, todo);
    }
    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id){
        todoH2Service.deleteTodo(id);
    }
}

