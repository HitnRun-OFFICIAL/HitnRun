package com.HitnRun.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

abstract class TopBarButton extends JLabel {
  private String toolTipText;
  private Icon icon;

  TopBarButton(String toolTipText, Icon icon) {
    this.toolTipText = toolTipText;
    this.icon = icon;
    initComponents();
  }

  void initComponents() {
    setBackground(new Color(0, 0, 0));
    setForeground(new Color(255, 255, 255));
    setHorizontalAlignment(SwingConstants.CENTER);
    setIcon(icon);
    setLabelFor(this);
    setToolTipText(toolTipText);
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    setMaximumSize(new Dimension(32, 32));
    setMinimumSize(new Dimension(32, 32));
    setOpaque(true);
    setPreferredSize(new Dimension(32, 32));
    addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            lblMouseMoved(evt);
          }
        });
    addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            lblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            lblMousePressed(evt);
          }
        });
  }

  public void lblMouseMoved(MouseEvent evt) {
    this.setBackground(Color.GRAY);
  }

  public void lblMouseExited(MouseEvent evt) {
    this.setBackground(Color.BLACK);
  }

  abstract void lblMousePressed(MouseEvent evt);
}
