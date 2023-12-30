package com.demolist.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;
    @RequestMapping("/todos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @RequestMapping("/todos/{id}")
    public Todo getTodo(@PathVariable Integer id){
        return todoService.getTodo(id);

    }
    @RequestMapping(method= RequestMethod.POST, value="/todos")
    public void createTodo(@RequestBody Todo todo){
        todoService.createTodo(todo);
    }
    @RequestMapping(method= RequestMethod.PUT, value="/todos/{id}")
    public void updateTodo(@PathVariable Integer id, @RequestBody Todo todo){
        todoService.updateTodo(id,todo);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/todos/{id}")
    public void deleteTodo(@PathVariable Integer id){
        todoService.deleteTodo(id);
    }
}
