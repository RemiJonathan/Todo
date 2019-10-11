import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    //this stub returns a list of todos when retrieveTodos is called
    //we are hard coding the values and not calling the actual service at all
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }
}
