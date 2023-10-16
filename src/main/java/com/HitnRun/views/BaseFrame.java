package com.HitnRun.views;

import com.HitnRun.utils.Authenticator;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

/** @author 5H4D0W */
public class BaseFrame extends JFrame {

  private JPanel loginnPanel;
  private JPanel profilePanel;
  private JPanel vehiclePanel;
  private JPanel contactPanel;
  private JPanel aboutPanel;

  private TopBarButton accountLbl;
  private TopBarButton vehicleLbl;
  private TopBarButton contactLbl;
  private TopBarButton aboutLbl;
  private TopBarButton loginLbl;
  private TopBarButton registerLbl;

  private JPanel baseContent;
  private JPanel basePanel;

  private TopBar topBar;

  private CardLayout cardLayout;

  public BaseFrame() {
    initComponents();
    login();
  }

  private void initComponents() {

    cardLayout = new CardLayout();
    basePanel = new JPanel();

    loginLbl =
        new TopBarButton("login", FontIcon.of(MaterialDesign.MDI_LOGIN, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            cardLayout.show(baseContent, this.getToolTipText());
          }
        };
    registerLbl =
        new TopBarButton(
            "register", FontIcon.of(MaterialDesign.MDI_CLIPBOARD_ACCOUNT, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            cardLayout.show(baseContent, this.getToolTipText());
          }
        };
    accountLbl =
        new TopBarButton("profile", FontIcon.of(MaterialDesign.MDI_ACCOUNT, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            cardLayout.show(baseContent, this.getToolTipText());
          }
        };
    vehicleLbl =
        new TopBarButton("vehicle", FontIcon.of(MaterialDesign.MDI_CAR, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            cardLayout.show(baseContent, this.getToolTipText());
          }
        };
    contactLbl =
        new TopBarButton("contact", FontIcon.of(MaterialDesign.MDI_PHONE, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            cardLayout.show(baseContent, this.getToolTipText());
          }
        };
    aboutLbl =
        new TopBarButton("about", FontIcon.of(MaterialDesign.MDI_ALERT_CIRCLE, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            cardLayout.show(baseContent, this.getToolTipText());
          }
        };

    topBar = new TopBar(this);
    baseContent = new JPanel();

    loginnPanel = new LoginPanel();

    profilePanel = new ProfilePanel();

    vehiclePanel = new VehiclePanel();

    contactPanel = new ContactPanel();

    aboutPanel = new AboutPanel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBackground(new Color(40, 43, 48));
    setForeground(Color.black);
    setLocationByPlatform(true);
    setMinimumSize(new Dimension(1280, 768));
    setName("base"); // NOI18N
    setUndecorated(true);
    setResizable(false);

    basePanel.setBackground(new Color(40, 43, 48));
    basePanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    basePanel.setMaximumSize(new Dimension(1280, 768));
    basePanel.setPreferredSize(new Dimension(1280, 768));

    baseContent.setBackground(new Color(40, 43, 48));
    baseContent.setPreferredSize(new Dimension(1280, 728));
    baseContent.setLayout(cardLayout);

    baseContent.add(loginnPanel, "login");

    baseContent.add(profilePanel, "profile");

    baseContent.add(vehiclePanel, "vehicle");

    baseContent.add(contactPanel, "contact");

    baseContent.add(aboutPanel, "about");

    GroupLayout basePanelLayout = new GroupLayout(basePanel);
    basePanel.setLayout(basePanelLayout);
    basePanelLayout.setHorizontalGroup(
        basePanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                basePanelLayout
                    .createSequentialGroup()
                    .addGroup(
                        basePanelLayout
                            .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(
                                baseContent,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                topBar,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))));
    basePanelLayout.setVerticalGroup(
        basePanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                basePanelLayout
                    .createSequentialGroup()
                    .addComponent(
                        topBar,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(
                        baseContent,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)));

    getContentPane().add(basePanel, BorderLayout.CENTER);

    pack();
  }

  public static void main(String args[]) {
    FlatDarkLaf.setup();
    EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new BaseFrame().setVisible(true);
          }
        });
  }

  private final void login() {
    if (Authenticator.getProfile() == null) {
      topBar.setButtons(
          new ArrayList<TopBarButton>(Arrays.asList(accountLbl, vehicleLbl, contactLbl, aboutLbl)));
      cardLayout.show(baseContent, "profile");
    } else {
      topBar.setButtons(new ArrayList<TopBarButton>(Arrays.asList(loginLbl, registerLbl)));
      cardLayout.show(baseContent, "login");
    }
  }
}
