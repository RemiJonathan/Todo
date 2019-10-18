import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    public void testMockListGetMethod_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        listMock.get(0);
        assertThrows(RuntimeException.class, () -> {
            listMock.get(0);
        });
        //assertEquals("In Winter", listMock.get(0));

        //assertEquals("In Winter", listMock.get(1));
        // assertEquals(0, listMock.size());
        //assertEquals(null, listMock.get(1));
    }

    @Test
    public void testMockListsubListMethod_mixingItUp() {
        List listMock = mock(List.class);
        //Argument Matcher
        when(listMock.subList(anyInt(), eq(5))).thenThrow(new
                RuntimeException("Something"));
        //testing for an exception
        assertThrows(RuntimeException.class, () -> {
            listMock.subList(anyInt(), 5);
        });
    }


    @Test
    public void testMockListGetMethod() {
        List listMock = mock(List.class);
        //when(listMock.size()).thenReturn(2).thenReturn(3);
        //when(listMock.get(0)).thenReturn("In Winter");


        assertEquals(0, listMock.size());
        assertEquals(0, listMock.size());
        assertEquals(null, listMock.get(0));
        assertEquals(null, listMock.get(1));
    }
}