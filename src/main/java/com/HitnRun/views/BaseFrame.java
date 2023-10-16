package com.HitnRun.views;

import com.HitnRun.utils.Authenticator;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
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

  private JLabel accountLbl;
  private JLabel vehicleLbl;
  private JLabel contactLbl;
  private JLabel aboutLbl;
  private JLabel minimizeLbl;
  private JLabel closeLbl;
  private JLabel loginLbl;
  private JLabel registerLbl;

  private JPanel baseContent;
  private JPanel basePanel;

  private JPanel topBar;

  private CardLayout cardLayout;

  public BaseFrame() {
    initComponents();
    prepareIcons();
  }

  private void initComponents() {

    cardLayout = new CardLayout();
    basePanel = new JPanel();
    topBar = new JPanel();
    accountLbl = new JLabel();
    vehicleLbl = new JLabel();
    contactLbl = new JLabel();
    aboutLbl = new JLabel();
    minimizeLbl = new JLabel();
    closeLbl = new JLabel();
    loginLbl = new JLabel();
    registerLbl = new JLabel();

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

    topBar.setBackground(new Color(0, 0, 0));
    topBar.setForeground(new Color(255, 255, 255));
    topBar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    topBar.setMaximumSize(new Dimension(1280, 768));
    topBar.setPreferredSize(new Dimension(1280, 40));
    topBar.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseDragged(MouseEvent evt) {
            topBarMouseDragged(evt);
          }
        });
    topBar.addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            topBarMousePressed(evt);
          }

          public void mouseReleased(MouseEvent evt) {
            topBarMouseReleased(evt);
          }
        });

    loginLbl.setBackground(new Color(0, 0, 0));
    loginLbl.setForeground(new Color(255, 255, 255));
    loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
    loginLbl.setLabelFor(loginLbl);
    loginLbl.setToolTipText("Login");
    loginLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    loginLbl.setMaximumSize(new Dimension(32, 32));
    loginLbl.setMinimumSize(new Dimension(32, 32));
    loginLbl.setOpaque(true);
    loginLbl.setPreferredSize(new Dimension(32, 32));
    loginLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            loginLblMouseMoved(evt);
          }
        });
    loginLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            loginLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            loginLblMousePressed(evt);
          }
        });

    registerLbl.setBackground(new Color(0, 0, 0));
    registerLbl.setForeground(new Color(255, 255, 255));
    registerLbl.setHorizontalAlignment(SwingConstants.CENTER);
    registerLbl.setLabelFor(registerLbl);
    registerLbl.setToolTipText("Register");
    registerLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    registerLbl.setMaximumSize(new Dimension(32, 32));
    registerLbl.setMinimumSize(new Dimension(32, 32));
    registerLbl.setOpaque(true);
    registerLbl.setPreferredSize(new Dimension(32, 32));
    registerLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            registerLblMouseMoved(evt);
          }
        });
    registerLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            registerLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            registerLblMousePressed(evt);
          }
        });

    accountLbl.setBackground(new Color(0, 0, 0));
    accountLbl.setForeground(new Color(255, 255, 255));
    accountLbl.setHorizontalAlignment(SwingConstants.CENTER);
    accountLbl.setLabelFor(accountLbl);
    accountLbl.setToolTipText("Account");
    accountLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    accountLbl.setMaximumSize(new Dimension(32, 32));
    accountLbl.setMinimumSize(new Dimension(32, 32));
    accountLbl.setOpaque(true);
    accountLbl.setPreferredSize(new Dimension(32, 32));
    accountLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            accountLblMouseMoved(evt);
          }
        });
    accountLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            accountLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            accountLblMousePressed(evt);
          }
        });

    vehicleLbl.setBackground(new Color(0, 0, 0));
    vehicleLbl.setForeground(new Color(255, 255, 255));
    vehicleLbl.setHorizontalAlignment(SwingConstants.CENTER);
    vehicleLbl.setToolTipText("Vehicles");
    vehicleLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    vehicleLbl.setHorizontalTextPosition(SwingConstants.CENTER);
    vehicleLbl.setMaximumSize(new Dimension(32, 32));
    vehicleLbl.setMinimumSize(new Dimension(32, 32));
    vehicleLbl.setOpaque(true);
    vehicleLbl.setPreferredSize(new Dimension(32, 32));
    vehicleLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            vehicleLblMouseMoved(evt);
          }
        });
    vehicleLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            vehicleLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            vehicleLblMousePressed(evt);
          }
        });

    contactLbl.setBackground(new Color(0, 0, 0));
    contactLbl.setForeground(new Color(255, 255, 255));
    contactLbl.setHorizontalAlignment(SwingConstants.CENTER);
    contactLbl.setToolTipText("Contact Us");
    contactLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    contactLbl.setHorizontalTextPosition(SwingConstants.CENTER);
    contactLbl.setMaximumSize(new Dimension(32, 32));
    contactLbl.setMinimumSize(new Dimension(32, 32));
    contactLbl.setOpaque(true);
    contactLbl.setPreferredSize(new Dimension(32, 32));
    contactLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            contactLblMouseMoved(evt);
          }
        });
    contactLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            contactLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            contactLblMousePressed(evt);
          }
        });

    aboutLbl.setBackground(new Color(0, 0, 0));
    aboutLbl.setForeground(new Color(255, 255, 255));
    aboutLbl.setHorizontalAlignment(SwingConstants.CENTER);
    aboutLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    aboutLbl.setMaximumSize(new Dimension(32, 32));
    aboutLbl.setMinimumSize(new Dimension(32, 32));
    aboutLbl.setOpaque(true);
    aboutLbl.setPreferredSize(new Dimension(32, 32));
    aboutLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            aboutLblMouseMoved(evt);
          }
        });
    aboutLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            aboutLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            aboutLblMousePressed(evt);
          }
        });

    minimizeLbl.setBackground(new Color(0, 0, 0));
    minimizeLbl.setForeground(new Color(255, 255, 255));
    minimizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
    minimizeLbl.setToolTipText("Minimize");
    minimizeLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    minimizeLbl.setHorizontalTextPosition(SwingConstants.CENTER);
    minimizeLbl.setMaximumSize(new Dimension(32, 32));
    minimizeLbl.setMinimumSize(new Dimension(32, 32));
    minimizeLbl.setOpaque(true);
    minimizeLbl.setPreferredSize(new Dimension(32, 32));
    minimizeLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            minimizeLblMouseMoved(evt);
          }
        });
    minimizeLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            minimizeLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            minimizeLblMousePressed(evt);
          }
        });

    closeLbl.setBackground(new Color(0, 0, 0));
    closeLbl.setForeground(new Color(255, 255, 255));
    closeLbl.setHorizontalAlignment(SwingConstants.CENTER);
    closeLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    closeLbl.setHorizontalTextPosition(SwingConstants.CENTER);
    closeLbl.setMaximumSize(new Dimension(32, 32));
    closeLbl.setMinimumSize(new Dimension(32, 32));
    closeLbl.setOpaque(true);
    closeLbl.setPreferredSize(new Dimension(32, 32));
    closeLbl.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            closeLblMouseMoved(evt);
          }
        });
    closeLbl.addMouseListener(
        new MouseAdapter() {
          public void mouseExited(MouseEvent evt) {
            closeLblMouseExited(evt);
          }

          public void mousePressed(MouseEvent evt) {
            closeLblMousePressed(evt);
          }
        });

    GroupLayout startTopBarLayout = new GroupLayout(topBar);
    topBar.setLayout(startTopBarLayout);
    startTopBarLayout.setHorizontalGroup(
        startTopBarLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                startTopBarLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        loginLbl,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        registerLbl,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(
                        minimizeLbl,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        closeLbl,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()));
    startTopBarLayout.setVerticalGroup(
        startTopBarLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                startTopBarLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        startTopBarLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(
                                closeLbl,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                loginLbl,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                minimizeLbl,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                registerLbl,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()));
    if (Authenticator.AuthenticateCustomer("saman_customer", "customer_password")) {
      GroupLayout topBarLayout = new GroupLayout(topBar);
      topBarLayout.setHorizontalGroup(
          topBarLayout
              .createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(
                  topBarLayout
                      .createSequentialGroup()
                      .addContainerGap()
                      .addComponent(
                          accountLbl,
                          GroupLayout.PREFERRED_SIZE,
                          GroupLayout.DEFAULT_SIZE,
                          GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(
                          vehicleLbl,
                          GroupLayout.PREFERRED_SIZE,
                          GroupLayout.DEFAULT_SIZE,
                          GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(
                          contactLbl,
                          GroupLayout.PREFERRED_SIZE,
                          GroupLayout.DEFAULT_SIZE,
                          GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(
                          aboutLbl,
                          GroupLayout.PREFERRED_SIZE,
                          GroupLayout.DEFAULT_SIZE,
                          GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(
                          LayoutStyle.ComponentPlacement.RELATED,
                          GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE)
                      .addComponent(
                          minimizeLbl,
                          GroupLayout.PREFERRED_SIZE,
                          GroupLayout.DEFAULT_SIZE,
                          GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(
                          closeLbl,
                          GroupLayout.PREFERRED_SIZE,
                          GroupLayout.DEFAULT_SIZE,
                          GroupLayout.PREFERRED_SIZE)
                      .addContainerGap()));
      topBarLayout.setVerticalGroup(
          topBarLayout
              .createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(
                  topBarLayout
                      .createSequentialGroup()
                      .addContainerGap()
                      .addGroup(
                          topBarLayout
                              .createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addComponent(
                                  closeLbl,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.PREFERRED_SIZE)
                              .addComponent(
                                  accountLbl,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.PREFERRED_SIZE)
                              .addComponent(
                                  minimizeLbl,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.DEFAULT_SIZE,
                                  Short.MAX_VALUE)
                              .addComponent(
                                  aboutLbl,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.PREFERRED_SIZE)
                              .addComponent(
                                  contactLbl,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.PREFERRED_SIZE)
                              .addComponent(
                                  vehicleLbl,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.DEFAULT_SIZE,
                                  GroupLayout.PREFERRED_SIZE))
                      .addContainerGap()));
      topBar.setLayout(topBarLayout);
    }

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

  private void loginLblMousePressed(MouseEvent evt) {
    cardLayout.show(baseContent, "login");
  }

  private void loginLblMouseExited(MouseEvent evt) {
    resetLblBg(loginLbl);
  }

  private void loginLblMouseMoved(MouseEvent evt) {
    setLblBg(loginLbl);
  }

  private void registerLblMousePressed(MouseEvent evt) {
    cardLayout.show(baseContent, "register");
  }

  private void registerLblMouseExited(MouseEvent evt) {
    resetLblBg(registerLbl);
  }

  private void registerLblMouseMoved(MouseEvent evt) {
    setLblBg(registerLbl);
  }

  private void contactLblMousePressed(MouseEvent evt) {
    cardLayout.show(baseContent, "contact");
  }

  private void aboutLblMousePressed(MouseEvent evt) {
    cardLayout.show(baseContent, "about");
  }

  private void accountLblMousePressed(MouseEvent evt) {
    cardLayout.show(baseContent, "profile");
  }

  private void vehicleLblMousePressed(MouseEvent evt) {
    cardLayout.show(baseContent, "vehicle");
  }

  private void accountLblMouseExited(MouseEvent evt) {
    resetLblBg(accountLbl);
  }

  private void accountLblMouseMoved(MouseEvent evt) {
    setLblBg(accountLbl);
  }

  private void vehicleLblMouseMoved(MouseEvent evt) {
    setLblBg(vehicleLbl);
  }

  private void vehicleLblMouseExited(MouseEvent evt) {
    resetLblBg(vehicleLbl);
  }

  private void contactLblMouseMoved(MouseEvent evt) {
    setLblBg(contactLbl);
  }

  private void contactLblMouseExited(MouseEvent evt) {
    resetLblBg(contactLbl);
  }

  private void aboutLblMouseMoved(MouseEvent evt) {
    setLblBg(aboutLbl);
  }

  private void aboutLblMouseExited(MouseEvent evt) {
    resetLblBg(aboutLbl);
  }

  private void minimizeLblMouseExited(MouseEvent evt) {
    resetLblBg(minimizeLbl);
  }

  private void minimizeLblMouseMoved(MouseEvent evt) {
    setLblBg(minimizeLbl);
  }

  private void closeLblMouseMoved(MouseEvent evt) {
    setLblBg(closeLbl);
  }

  private void closeLblMouseExited(MouseEvent evt) {
    resetLblBg(closeLbl);
  }

  private void minimizeLblMousePressed(MouseEvent evt) {
    setState(ICONIFIED);
  }

  private void closeLblMousePressed(MouseEvent evt) {
    System.exit(0);
  }

  private Point compCoord = null;

  private void topBarMouseReleased(MouseEvent evt) {
    compCoord = null;
  }

  private void topBarMousePressed(MouseEvent evt) {
    compCoord = evt.getPoint();
  }

  private void topBarMouseDragged(MouseEvent evt) {
    setLocation(
        evt.getLocationOnScreen().x - compCoord.x, evt.getLocationOnScreen().y - compCoord.y);
  }

  private final void setLblBg(JLabel jl) {
    jl.setBackground(Color.GRAY);
  }

  private final void resetLblBg(JLabel jl) {
    jl.setBackground(Color.BLACK);
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

  final void prepareIcons() {
    loginLbl.setIcon(FontIcon.of(MaterialDesign.MDI_LOGIN, 32, Color.WHITE));
    registerLbl.setIcon(FontIcon.of(MaterialDesign.MDI_CLIPBOARD_ACCOUNT, 32, Color.WHITE));
    accountLbl.setIcon(FontIcon.of(MaterialDesign.MDI_ACCOUNT, 32, Color.WHITE));
    vehicleLbl.setIcon(FontIcon.of(MaterialDesign.MDI_CAR, 32, Color.WHITE));
    contactLbl.setIcon(FontIcon.of(MaterialDesign.MDI_PHONE, 32, Color.WHITE));
    aboutLbl.setIcon(FontIcon.of(MaterialDesign.MDI_ALERT_CIRCLE, 32, Color.WHITE));
    minimizeLbl.setIcon(FontIcon.of(MaterialDesign.MDI_WINDOW_MINIMIZE, 32, Color.WHITE));
    closeLbl.setIcon(FontIcon.of(MaterialDesign.MDI_WINDOW_CLOSE, 32, Color.WHITE));
  }
}
