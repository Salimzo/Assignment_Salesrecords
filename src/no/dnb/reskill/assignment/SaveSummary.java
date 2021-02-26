package no.dnb.reskill.assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class SaveSummary {

    public static String saveToFile(String data) throws IOException  {
        String filename = createFileWithTimestamp();
        readToFile(filename, data);
        return filename;
    }

    private static boolean readToFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
        return true;
    }

    private static String createFileWithTimestamp() throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmm");
        String postfix = LocalTime.now().format(dtf);
        String filename = String.format("Summary_%s.txt", postfix);

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file.getName();
    }

}
