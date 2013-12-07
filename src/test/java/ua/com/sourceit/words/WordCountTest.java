package ua.com.sourceit.words;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * User: alexkorotkikh
 * Date: 12/7/13
 * Time: 1:28 AM
 */
public class WordCountTest {
    @Test(expected = FileNotFoundException.class)
    public void testCount_wrongFile() throws Exception {
        final WordCount wordCount = new WordCount();
        wordCount.count(new File("wrong.txt"));
    }

    @Test
    public void testMapOfWords() throws Exception {
        //Given
        final WordCount wordCount = new WordCount();

        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("hello");
        list.add("bye");

        //When
        Map<String, Integer> map = wordCount.mapOfWords(list);

        //Then
        assertEquals(new Integer(2), map.get("hello"));
        assertEquals(new Integer(1), map.get("bye"));
    }
}
