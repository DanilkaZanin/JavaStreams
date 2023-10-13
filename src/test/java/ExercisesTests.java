import org.example.streamAPI.Exercises;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExercisesTests {
    List<Integer> listInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    List<String> listString = Arrays.asList("aasda","cacsac","ascas","baba");
    /*@Before
    public void init(){
        listInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
         listString = Arrays.asList("aasda","cacsac","ascas","baba");
    }*/
    /* Посчитать сумму всех четных чисел в списке. */
    @Test
    public void sumTest(){
        assertEquals(Exercises.summa(listInteger),30);
    }

    //Отсортировать список строк в алфавитном порядке.
    @Test
    public void alphabetSortTest(){
        List<String> sortedList = Arrays.asList("aasda","ascas","baba","cacsac");

        listString = Exercises.alphabetSort(listString);

        assertEquals(listString,sortedList);
    }
    //Найти максимальное значение в списке чисел.
    @Test
    public void findMaxTest(){
        assertEquals(Exercises.findMax(listInteger),10);
    }
    //Преобразовать список строк в список их длин.
    @Test
    public void fromListToCountListTest(){
        List<Integer> countList = Arrays.asList(5,6,5,4);
        assertEquals(Exercises.fromListToCountList(listString),countList);
    }

    @Test
    //Проверить, содержит ли список хотя бы один элемент, удовлетворяющий определенному условию.
    public void isInListTest(){

        assertTrue(Exercises.isInList(listInteger, 8));
    }
}
