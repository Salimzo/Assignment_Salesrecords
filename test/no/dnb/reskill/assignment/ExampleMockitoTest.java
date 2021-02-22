package no.dnb.reskill.assignment;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ExampleMockitoTest {
    //@Mock
    //private Interactable userInterface;

    @Mock
    private FileReader fileReader;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void openFile_fileExists_shouldReturnTrue() {
        // ARRANGE
        //when(userInterface.askForStringInput("Please type filename, and press ENTER")).thenReturn("SalesRecords.csv");
        //when(fileReader.openFile("SalesRecords.csv")).thenReturn(true);

        // ACT

        // ASSERT

        // VERIFY MOCKS
    }



}
