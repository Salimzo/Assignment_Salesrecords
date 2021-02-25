package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestApplication {

    SalesRegistry salesRegistry;
    SalesReaderCsv salesReaderCsv;

    @Mock
    UI mockHelper;

    @InjectMocks
    Application fixture;

    @Before
    public void setup() throws IOException, FileNotFoundException{
        MockitoAnnotations.initMocks(this);
        salesRegistry = new SalesRegistry();
        salesReaderCsv = new SalesReaderCsv(salesRegistry, "SalesRecords.csv");
    }

    @Test
    public void getFileNameFromUser_userInputsCorrectFile_successfulOpenFile() {
        when(mockHelper.getString("Enter CSV.file name")).thenReturn("SalesRecords.csv");
        assertEquals(fixture.getFileNameFromUser(), "SalesRecords.csv");
        verify(mockHelper).getString("Enter CSV.file name");
    }



    /*
    @Test (expected = IOException.class)
    public void getFileNameFromUser_wrongUserInput_exceptionOccurs() {
        when(mockHelper.getString("Enter CSV.file name")).thenReturn("Sales.csb");
        fixture.getFileNameFromUser();
    }
     */

    @Test
    public void getAndValidateOptionFromUser_userInputsCorrect_returnInteger() {
        when(mockHelper.getInt("Choose one of the options above: ")).thenReturn(4);
        assertEquals(fixture.getAndValidateOptionFromUser(),4);
        verify(mockHelper).getInt("Choose one of the options above: ");
    }

    @Test (expected = IllegalArgumentException.class)
    public void getAndValidateOptionFromUser_integerOverSeven_throwsException() {
        when(mockHelper.getInt("Choose one of the options above: ")).thenReturn(14);
        fixture.getAndValidateOptionFromUser();
    }

    @Test (expected = InputMismatchException.class)
    public void getAndValidateOptionFromUser_notAnInteger_throwsException() {
        when(mockHelper.getInt("Choose one of the options above: ")).thenReturn(Integer.valueOf("X"));
        fixture.getAndValidateOptionFromUser();
    }














}
