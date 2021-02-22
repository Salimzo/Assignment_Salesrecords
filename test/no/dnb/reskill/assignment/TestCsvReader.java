package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

public class TestCsvReader { //make test for UI too? Rename class?

    @Mock
    CsvReader mockCsvReader;

    @InjectMocks
    SalesRegistry fixture; //where is the method readFile() used? Should inject mock to object of that class?

    @Before
    public void setup() {

    }


    @Test
    public void readFile_xxx() {

    }

    @Test (expected = IOException.class)
    public void readFile_xxx_throwsException() {


    }






}
