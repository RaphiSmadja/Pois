
import exception.TsvException;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void should_return_exception_if_there_no_file() {
        //Given
        String[] args = new String[0];
        //When
        Exception exception = assertThrows(Exception.class, () -> Main.main(args));
        //Then
        assertEquals("You must pass a file as an args", exception.getMessage());
    }

    @Test
    void should_return_exception_if_format_of_file_isnt_tsv() {
        //Given
        String[] args = {"test.txt"};
        Main main = new Main();
        //When
        TsvException tsvException = assertThrows(TsvException.class, () -> main.openFile(args));
        //Then
        assertEquals("The format of file must be a 'tsv'", tsvException.getMessage());
    }

    @Test
    public void whenReadWithBufferedReader_thenCorrect() throws Exception {
        //Given
        String expected_value = "@id\t@lat\t@lon";
        String file ="test.tsv";
        //When
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();
        //Then
        assertEquals(expected_value, currentLine);
    }

    @Test
    void should_return_2_calculateNbPois() throws Exception {
        //Given
        String[] args = {"test.tsv"};
        Main main = new Main();
        LinkedList<Poi> list = main.openFile(args);
        //When
        int val = main.calculateNbPois(6.5, -7, list);
        //Then
        assertEquals(2, val);
    }

    @Test
    void should_return_0_calculateNbPois_lat_7_lon_35() throws Exception {
        //Given
        String[] args = {"test.tsv"};
        Main main = new Main();
        LinkedList<Poi> list = main.openFile(args);
        //When
        int val = main.calculateNbPois(7, 35, list);
        //Then
        assertEquals(0, val);
    }

}
