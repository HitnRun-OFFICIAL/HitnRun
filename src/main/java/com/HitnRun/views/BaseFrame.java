package com.HitnRun.views;

import com.HitnRun.utils.Authenticator;
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
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

/** @author 5H4D0W */
public class BaseFrame extends JFrame {

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
    login();
    baseContent = new JPanel();
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
                                Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE)));
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
                    .addPreferredGap(
                        LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(
                        baseContent,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)));

    getContentPane().add(basePanel, BorderLayout.CENTER);

    pack();
  }

  public static void main(String args[]) {

    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(BaseFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(BaseFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(BaseFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(BaseFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new BaseFrame().setVisible(true);
          }
        });
  }

  private final void login() {
    if (Authenticator.AuthenticateCustomer("saman_customer", "customer_password")) {
      topBar.setButtons(
          new ArrayList<TopBarButton>(Arrays.asList(accountLbl, vehicleLbl, contactLbl, aboutLbl)));
    } else {
      topBar.setButtons(new ArrayList<TopBarButton>(Arrays.asList(loginLbl, registerLbl)));
    }
  }
}
