import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.BDDMockito.*;

class TodoBusinessImplMockTest {

    @Test
    void retrieveTodosRelatedToSpring_usingAMock() {
        //get a mock of the TodoService class
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //if there are no results, Mockito will return and empty list
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    void retrieveTodosRelatedToSpring_usingBDD() {
        //get a mock of the TodoService class
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> listMock = mock(List.class);
        String actualResult;

        given(listMock.get(anyInt())).willReturn("Spring");

        //When
        actualResult = listMock.get(0);

        //Then
        assertEquals(actualResult, "Spring");
    }
}