package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestApplication {

    SalesRegistry salesRegistry;
    SalesReaderCsv salesReaderCsv;

    @Mock
    Helper mockHelper;

    @InjectMocks
    Application fixture;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        salesRegistry = new SalesRegistry();
        salesReaderCsv = new SalesReaderCsv(salesRegistry);
        //TODO: ??
    }

    @Test
    public void start_userInputsCorrectFile_successfulOpenFile() {
        when(mockHelper.getString("Enter CSV.file name")).thenReturn("SalesRecords.csv");
        fixture.start();
        try {
            assertTrue(salesReaderCsv.openFile("SalesRecords.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        verify(mockHelper).getString("Enter CSV.file name");
    }

    @Test (expected=IOException.class)
    public void start_wrongUserInput_exceptionOccurs() {
        when(mockHelper.getString("Enter CSV.file name")).thenReturn(null);
        fixture.start();
    }










}
