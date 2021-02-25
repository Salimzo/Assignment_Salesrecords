package no.dnb.reskill.assignment;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ExampleMockitoTest {
    //@Mock
    //private Interactable userInterface;

    @Mock
    private ReadsAllFiles fileReader;

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
