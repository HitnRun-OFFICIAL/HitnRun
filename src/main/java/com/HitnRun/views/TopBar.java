package com.HitnRun.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

class TopBar extends JPanel {
  private Point compCoord;
  private List<TopBarButton> labels;
  private TopBarButton minimizeLbl;
  private TopBarButton closeLbl;
  private JFrame parent;

  // Constructor
  TopBar(JFrame parent) {
    this.parent = parent;
    initComponents();
  }

  void initComponents() {
    // Set the Top Bar
    compCoord = null;
    labels = new ArrayList<TopBarButton>();

    setBackground(new Color(0, 0, 0));
    setForeground(new Color(255, 255, 255));
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    setMaximumSize(new Dimension(1280, 768));
    setPreferredSize(new Dimension(1280, 40));
    addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseDragged(MouseEvent evt) {
            topBarMouseDragged(evt);
          }
        });
    addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            topBarMousePressed(evt);
          }

          public void mouseReleased(MouseEvent evt) {
            topBarMouseReleased(evt);
          }
        });

    minimizeLbl =
        new TopBarButton(
            "Minimize", FontIcon.of(MaterialDesign.MDI_WINDOW_MINIMIZE, 32, Color.WHITE)) {
          @Override
          void lblMousePressed(MouseEvent evt) {
            parent.setState(JFrame.ICONIFIED);
          }
        };

    closeLbl =
        new TopBarButton("Close", FontIcon.of(MaterialDesign.MDI_WINDOW_CLOSE, 32, Color.WHITE)) {
          @Override
          void lblMousePressed(MouseEvent evt) {
            System.exit(0);
          }

          @Override
          public void lblMouseMoved(MouseEvent evt) {
            this.setBackground(Color.RED);
          }
        };
  }

  public final void setButtons(List<TopBarButton> labels) {
    this.labels = labels;
    GroupLayout topBarLayout = new GroupLayout(this);
    setLayout(topBarLayout);

    GroupLayout.SequentialGroup hGroup = topBarLayout.createSequentialGroup().addContainerGap();
    GroupLayout.ParallelGroup vGroup =
        topBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

    for (JLabel label : labels) {
      hGroup.addComponent(
          label,
          GroupLayout.PREFERRED_SIZE,
          GroupLayout.PREFERRED_SIZE,
          GroupLayout.PREFERRED_SIZE);
      if (label != labels.get(labels.size() - 1)) {
        hGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
      }

      vGroup.addComponent(
          label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
    }

    hGroup.addPreferredGap(
        LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
    hGroup.addComponent(
        minimizeLbl,
        GroupLayout.PREFERRED_SIZE,
        GroupLayout.DEFAULT_SIZE,
        GroupLayout.PREFERRED_SIZE);
    hGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
    hGroup.addComponent(
        closeLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
    topBarLayout.setHorizontalGroup(
        topBarLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(hGroup.addContainerGap()));

    vGroup.addComponent(
        minimizeLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
    vGroup.addComponent(
        closeLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);

    topBarLayout.setVerticalGroup(
        topBarLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                topBarLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(vGroup)
                    .addContainerGap()));
  }

  // Called when the mouse button is released
  private void topBarMouseReleased(MouseEvent evt) {
    compCoord = null;
  }

  // Variable to store the initial coordinates of the mouse click
  private void topBarMousePressed(MouseEvent evt) {
    compCoord = evt.getPoint();
  }

  private void topBarMouseDragged(MouseEvent evt) {
    parent.setLocation(
        evt.getLocationOnScreen().x - compCoord.x, evt.getLocationOnScreen().y - compCoord.y);
  }
}
