package com.HitnRun;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.utils.HSQLDBConnector;
import java.sql.Connection;
import org.junit.jupiter.api.Test;

class HitnRunTest {

  @Test
  public void testMainMethod() {
    try (Connection connection = HSQLDBConnector.getTestConnection()) {
      assertNotNull(connection, "Connection should not be null");
    } catch (Exception e) {
      fail("Exception should not be thrown: " + e.getMessage());
    }
  }
}
