package com.HitnRun;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    public void testMainMethod() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        Main.main(new String[]{});

        // Restore System.out
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "Hello world!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}