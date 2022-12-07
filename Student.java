import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Good Code:
~Algorithm can handle edge case(Maybe more than one most common items) and NULL case(List is NULL -> throw new IllegalArgumentException())
~Extensible to other data types: Use Java Generics Student<T> List<T>
*/

public class Student<T> {    
    List<T> todos;
    public Student(List<T> todos) {
        this.todos = todos;
    }
    public T mostCommonTodoItem() {
        if(this.todos.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Map<T, Integer> counts = new HashMap<>();
        for(T s : this.todos) {
            if(!counts.containsKey(s)) counts.put(s, 1);
            else counts.put(s, counts.get(s) + 1);
        }
        T mostCommonItem = null;
        int howCommon = 0;
        for(T s : counts.keySet()) {
            if(counts.get(s) > howCommon) {
                mostCommonItem = s;
                howCommon = counts.get(s);
            }
        }
        return mostCommonItem;
    }
}

public static void main(String[] args){
    Student<String> tim = new Student<>(List.of("lecture notes", "email", "email", "family", "email"));
    Student<Integer> nim = new Student<>(List.of(1, 17, 3, 43, 1, 2, 5));
}