import org.example.streamAPI.Exercises;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExercisesTests {

    /* Посчитать сумму всех четных чисел в списке. */
    @Test
    public void sumTest(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        assertEquals(Exercises.summa(list),30);
    }

    //Отсортировать список строк в алфавитном порядке.
    @Test
    public void alphabetSortTest(){
        List<String> list = Arrays.asList("aasda","cacsac","ascas","baba");
        List<String> sortedList = Arrays.asList("aasda","ascas","baba","cacsac");

        list = Exercises.alphabetSort(list);

        assertEquals(list,sortedList);
    }
    //Найти максимальное значение в списке чисел.
    @Test
    public void findMaxTest(){
        List<Integer> list = Arrays.asList(1,2,3,85,20,57,70,9);

        assertEquals(Exercises.findMax(list),85);
    }
}
