package com.HitnRun.views;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Button extends JLabel {
  private String btnText;
  private Color bg;

  public Button(String btnText) {
    this.btnText = btnText;
    this.bg = new java.awt.Color(115, 138, 219);
    initComponents();
  }

  public Button(String btnText, Color bg) {
    this.btnText = btnText;
    this.bg = bg;
    initComponents();
  }

  void initComponents() {
    setBackground(bg);
    setFont(new java.awt.Font("Cascadia Code", 0, 18));
    setForeground(new java.awt.Color(255, 255, 255));
    setHorizontalAlignment(SwingConstants.CENTER);
    setText(btnText);
    setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    setHorizontalTextPosition(SwingConstants.CENTER);
    setOpaque(true);
    addMouseMotionListener(
        new java.awt.event.MouseMotionAdapter() {
          public void mouseMoved(java.awt.event.MouseEvent evt) {
            btnMouseMoved(evt);
          }
        });
    addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseExited(java.awt.event.MouseEvent evt) {
            btnMouseExited(evt);
          }

          public void mousePressed(java.awt.event.MouseEvent evt) {
            btnMousePressed(evt);
          }
        });
  }

  public void btnMouseMoved(MouseEvent evt) {
    setBackground(
        new Color((bg.getRed() + 10) % 256, (bg.getGreen() + 10) % 256, (bg.getBlue() + 10) % 256));
  }

  public void btnMouseExited(MouseEvent evt) {
    setBackground(bg);
  }

  public void btnMousePressed(MouseEvent evt) {}
}
