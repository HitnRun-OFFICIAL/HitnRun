package com.HitnRun;

import com.HitnRun.views.BaseFrame;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

public class HitnRun {
  public static void main(String[] args) {
    // Initialize the Flat Dark Flat IntelliJ theme for the user interface.
    FlatDarkFlatIJTheme.setup();
    // Launch the main application window.
    BaseFrame.main(args);
  }
}
