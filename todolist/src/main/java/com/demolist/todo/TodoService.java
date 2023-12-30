package com.demolist.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>(
            Arrays.asList(
                    new Todo(1, "name1", "summ1", "desc1"),
                    new Todo(2, "name2", "summ2", "desc2"),
                    new Todo(3, "name3", "summ3", "desc3")
                    )
    );
    public List<Todo> getAllTodos(){
        return todos;
    }

    public Todo getTodo(Integer id){
        return todos.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
    public void createTodo(Todo todo){
        todos.add(todo);

    }
    public void updateTodo(Integer id,Todo todo){
        for(int i=0; i<todos.size(); i++){
            if(todos.get(i).getId().equals(id)){
            /*Todo t=todos.get(i);
            if(t.getId().equals(id)){*/
                // can also use the above code
                todos.set(i, todo);
            }
        }
    }
    public void deleteTodo(Integer id){
       // todos.removeIf(t -> t.getId().equals(id));
        //can also use the above code
        for(int i=0; i<todos.size(); i++){
            Todo t= todos.get(i);
            if(t.getId().equals(id)){
                todos.remove(i);
            }
        }

    }

}
