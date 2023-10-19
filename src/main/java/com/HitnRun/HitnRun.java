package com.HitnRun;

import com.HitnRun.views.*;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

public class HitnRun {
  public static void main(String[] args) {
    // try (Connection connection = MSSQLJDBConnector.getConnection()) {
    //   System.out.println("Hello mfs!!");
    FlatDarkFlatIJTheme.setup();
    BaseFrame.main(args);
    // } catch (DatabaseException e) {
    //   System.err.println("Database Exception: " + e.getMessage());
    // } catch (Exception e) {
    //   e.printStackTrace();
    // }
  }
}
