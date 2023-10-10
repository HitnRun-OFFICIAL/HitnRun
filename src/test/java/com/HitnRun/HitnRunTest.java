package com.HitnRun;

import com.HitnRun.utils.MSSQLJDBConnector;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class HitnRunTest {

    @Test
    public void testMainMethod() {
        try (Connection connection = MSSQLJDBConnector.getConnection()) {
            assertNotNull(connection, "Connection should not be null");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}