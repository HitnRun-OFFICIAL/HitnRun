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

class BasePanel extends JPanel {
  private JFrame parent;
  private JPanel baseContent;
  private TopBarButton accountLbl;
  private TopBarButton vehicleLbl;
  private TopBarButton contactLbl;
  private TopBarButton aboutLbl;
  private TopBarButton logoutLbl;
  private TopBar topBar;
  private CardLayout basePanelCardLayout;

  BasePanel(JFrame parent) {
    this.parent = parent;
    initComponents();
    checkAuth();
  }

  void initComponents() {
    topBar = new TopBar(parent);
    baseContent = new JPanel();

    basePanelCardLayout = new CardLayout();

    logoutLbl =
        new TopBarButton("logout", FontIcon.of(MaterialDesign.MDI_LOGIN, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            Authenticator.logout();
            basePanelCardLayout.show(baseContent, "login");
            topBar.removeAll();
            topBar.setButtons(new ArrayList<TopBarButton>());
          }
        };
    accountLbl =
        new TopBarButton("profile", FontIcon.of(MaterialDesign.MDI_ACCOUNT, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            basePanelCardLayout.show(baseContent, this.getToolTipText());
          }
        };
    vehicleLbl =
        new TopBarButton("vehicle", FontIcon.of(MaterialDesign.MDI_CAR, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            basePanelCardLayout.show(baseContent, this.getToolTipText());
          }
        };
    contactLbl =
        new TopBarButton("contact", FontIcon.of(MaterialDesign.MDI_PHONE, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            basePanelCardLayout.show(baseContent, this.getToolTipText());
          }
        };
    aboutLbl =
        new TopBarButton("about", FontIcon.of(MaterialDesign.MDI_ALERT_CIRCLE, 32, Color.WHITE)) {
          void lblMousePressed(MouseEvent evt) {
            basePanelCardLayout.show(baseContent, this.getToolTipText());
          }
        };

    setBackground(new Color(40, 43, 48));
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    setMaximumSize(new Dimension(1280, 768));
    setPreferredSize(new Dimension(1280, 768));

    baseContent.setBackground(new Color(40, 43, 48));
    baseContent.setPreferredSize(new Dimension(1280, 728));
    baseContent.setLayout(basePanelCardLayout);

    topBar.setButtons(new ArrayList<TopBarButton>());
    baseContent.add(new LoginPanel(this), "login");

    GroupLayout basePanelLayout = new GroupLayout(this);
    setLayout(basePanelLayout);
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
  }

  public final void checkAuth() {
    if (Authenticator.getProfile().getUsername() == null) {
      topBar.setButtons(new ArrayList<TopBarButton>());
      basePanelCardLayout.show(baseContent, "login");
    } else {
      baseContent.add(
          new ProfilePanel(parent) {
            public void changeView() {
              basePanelCardLayout.show(baseContent, "login");
            }
          },
          "profile");
      baseContent.add(new VehiclePanel(), "vehicle");
      baseContent.add(new ContactPanel(), "contact");
      baseContent.add(new AboutPanel(), "about");
      topBar.setButtons(
          new ArrayList<TopBarButton>(
              Arrays.asList(accountLbl, vehicleLbl, contactLbl, aboutLbl, logoutLbl)));
      topBar.revalidate();
      basePanelCardLayout.show(baseContent, "profile");
    }
  }
}
/** @author 5H4D0W */
public class BaseFrame extends JFrame {

  private JPanel basePanel;

  public BaseFrame() {
    initComponents();
  }

  private void initComponents() {

    basePanel = new BasePanel(this);

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBackground(new Color(40, 43, 48));
    setForeground(Color.black);
    setLocationByPlatform(true);
    setMinimumSize(new Dimension(1280, 768));
    setName("base"); // NOI18N
    setUndecorated(true);
    setResizable(false);
    // setIconImage(new ImageIcon(getClass().getResource("img/logo.jpg")).getImage());

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
}
