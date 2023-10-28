package com.HitnRun;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.utils.HSQLDBConnector;
import java.sql.Connection;
import org.junit.jupiter.api.Test;

class HitnRunTest {

  @Test
   // This annotation indicates that this method is a JUnit test case.
  public void testMainMethod() {
     // Attempt to open a database connection using HSQLDBConnector.getTestConnection().
    try (Connection connection = HSQLDBConnector.getTestConnection()) {
      // Check if the connection is not null. If it's null, the test will fail.
      assertNotNull(connection, "Connection should not be null");
    } catch (Exception e) {
      // If an exception is thrown outside of the try-with-resources block, fail the test with an error message.
      fail("Exception should not be thrown: " + e.getMessage());
    }
  }
}
