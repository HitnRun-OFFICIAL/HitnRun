package com.HitnRun.views;

import com.HitnRun.controllers.ProfilePanelController;
import com.HitnRun.handlers.CustomerNotFoundException;
import com.HitnRun.handlers.DatabaseException;
import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.InvalidInputException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.utils.Authenticator;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

class LoginForm extends JPanel {
  private JLabel jLabel1;
  private JLabel jLabel4;
  private JLabel jLogin1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private Button loginBtn;
  private JPanel jPanel1;
  private BasePanel parent;
  private JTextField loginUsername;
  private JPasswordField loginPassword;

  LoginForm(BasePanel parent) {
    this.parent = parent;
    initComponents();
  }

  void initComponents() {
    jLabel1 = new JLabel();
    jLabel4 = new JLabel();
    jLogin1 = new JLabel();
    jLabel2 = new JLabel();
    loginUsername = new JTextField();
    jLabel3 = new JLabel();
    loginPassword = new JPasswordField();
    jPanel1 = new JPanel();
    jLabel1.setFont(new java.awt.Font("Cascadia Code", 1, 36));
    jLabel1.setForeground(new java.awt.Color(115, 138, 219));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("LOGIN");
    jLabel1.setPreferredSize(new java.awt.Dimension(120, 50));

    setBackground(new java.awt.Color(40, 43, 48));
    setPreferredSize(new java.awt.Dimension(640, 728));

    jPanel1.setBackground(new java.awt.Color(40, 43, 48));
    jPanel1.setPreferredSize(new java.awt.Dimension(500, 432));

    jLabel2.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel2.setForeground(new java.awt.Color(115, 138, 219));
    jLabel2.setText("Username");

    loginUsername.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    loginUsername.setMaximumSize(new java.awt.Dimension(60, 30));
    loginUsername.setMinimumSize(new java.awt.Dimension(60, 30));
    loginUsername.setPreferredSize(new java.awt.Dimension(60, 30));

    jLabel3.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel3.setForeground(new java.awt.Color(115, 138, 219));
    jLabel3.setText("Password");

    loginPassword.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    loginPassword.setMaximumSize(new java.awt.Dimension(60, 30));
    loginPassword.setMinimumSize(new java.awt.Dimension(60, 30));
    loginPassword.setPreferredSize(new java.awt.Dimension(60, 30));

    loginBtn =
        new Button("Login") {
          public void btnMousePressed(MouseEvent evt) {
            try {
              if (Authenticator.AuthenticateCustomer(
                  loginUsername.getText(), new String(loginPassword.getPassword()))) {
                parent.checkAuth();
              }
            } catch (DatabaseException e) {
              JOptionPane.showMessageDialog(parent, e.getMessage());
            } catch (CustomerNotFoundException e) {
              JOptionPane.showMessageDialog(parent, e.getMessage());
            } catch (DatabaseOperationException e) {
              e.printStackTrace();
            }
          }
        };

    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLabel4.setText("I don't have an account");

    jLogin1.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLogin1.setForeground(new java.awt.Color(115, 138, 219));
    jLogin1.setText("Register");
    jLogin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLogin1.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            login1MousePressed(evt);
          }
        });

    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        jLogin1,
                                        GroupLayout.PREFERRED_SIZE,
                                        140,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                loginBtn,
                                                GroupLayout.PREFERRED_SIZE,
                                                140,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(
                                                loginUsername,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                loginPassword,
                                                GroupLayout.PREFERRED_SIZE,
                                                500,
                                                GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        jLabel1,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(190, 190, 190)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(
                        jLabel1,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addComponent(jLabel2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        loginUsername, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        loginPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(
                        loginBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLogin1)
                            .addComponent(jLabel4))
                    .addGap(0, 0, 0)));

    GroupLayout jPanel4Layout = new GroupLayout(this);
    setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel4Layout
                    .createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(
                        jPanel1,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)));
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel4Layout
                    .createSequentialGroup()
                    .addContainerGap(148, Short.MAX_VALUE)
                    .addComponent(
                        jPanel1,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(148, 148, 148)));
  }

  public void login1MousePressed(java.awt.event.MouseEvent evt) {}
}

/** @author 5H4D0W */
public class LoginPanel extends JPanel {

  private JLabel jLabel10;
  private JLabel jLabel11;
  private JLabel jLabel12;
  private JLabel jLabel13;
  private JLabel jLabel14;
  private JLabel jLabel15;
  private JLabel jLabel16;
  private JLabel jLabel17;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JLabel jLabel9;
  private JLabel jLogin3;
  private JLabel jLogin5;
  private JLabel registerBtn;
  private JLabel jLogin7;
  private Button backBtn;
  private Button backBtn1;
  private Button nextBtn;
  private Button nextBtn1;
  private JPanel jPanel10;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JPanel jPanel6;
  private JPanel jPanel7;
  private JPanel jPanel8;
  private JPanel jPanel9;
  private BasePanel parent;
  private JTextField lastname;
  private JTextField email;
  private JPasswordField registerPassword;
  private JTextField firstname;
  private JTextField phone;
  private JTextField registerUsername;
  private ProfilePanelController profilePanelController;
  private CardLayout cardLayout;

  public LoginPanel(BasePanel parent) {
    this.parent = parent;
    initComponents();
  }

  private void initComponents() {

    jPanel2 = new JPanel();
    jLabel5 = new JLabel();
    jPanel3 = new JPanel();
    jPanel4 =
        new LoginForm(parent) {
          public void login1MousePressed(MouseEvent evt) {
            cardLayout.show(jPanel3, "card3");
          }
        };
    jPanel5 = new JPanel();
    jPanel6 = new JPanel();
    jLabel6 = new JLabel();
    firstname = new JTextField();
    jLabel7 = new JLabel();
    lastname = new JTextField();
    jLabel8 = new JLabel();
    jLabel9 = new JLabel();
    jLogin3 = new JLabel();
    jPanel7 = new JPanel();
    jPanel8 = new JPanel();
    jLabel10 = new JLabel();
    phone = new JTextField();
    jLabel11 = new JLabel();
    email = new JTextField();
    jLabel12 = new JLabel();
    jLabel13 = new JLabel();
    jLogin5 = new JLabel();
    jPanel9 = new JPanel();
    jPanel10 = new JPanel();
    jLabel14 = new JLabel();
    registerUsername = new JTextField();
    jLabel15 = new JLabel();
    registerPassword = new JPasswordField();
    registerBtn = new JLabel();
    jLabel16 = new JLabel();
    jLabel17 = new JLabel();
    jLogin7 = new JLabel();
    profilePanelController = new ProfilePanelController();

    setBackground(new java.awt.Color(40, 43, 48));
    setMaximumSize(new java.awt.Dimension(1280, 728));
    setMinimumSize(new java.awt.Dimension(1280, 728));

    jPanel2.setBackground(new java.awt.Color(0, 0, 0));
    jPanel2.setPreferredSize(new java.awt.Dimension(640, 728));

    jLabel5.setIcon(new ImageIcon(getClass().getResource("/img/Logo.jpg")));

    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(0, 70, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 70, Short.MAX_VALUE)));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(0, 114, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 114, Short.MAX_VALUE)));

    cardLayout = new java.awt.CardLayout();
    jPanel3.setLayout(cardLayout);

    jPanel3.add(jPanel4, "card2");

    jPanel5.setBackground(new java.awt.Color(40, 43, 48));

    jPanel6.setBackground(new java.awt.Color(40, 43, 48));
    jPanel6.setPreferredSize(new java.awt.Dimension(500, 432));

    jLabel6.setBackground(new java.awt.Color(102, 102, 102));
    jLabel6.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel6.setForeground(new java.awt.Color(115, 138, 219));
    jLabel6.setText("Firstname");

    firstname.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    firstname.setMaximumSize(new java.awt.Dimension(60, 30));
    firstname.setMinimumSize(new java.awt.Dimension(60, 30));
    firstname.setPreferredSize(new java.awt.Dimension(60, 30));

    jLabel7.setBackground(new java.awt.Color(102, 102, 102));
    jLabel7.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel7.setForeground(new java.awt.Color(115, 138, 219));
    jLabel7.setText("Lastname");

    lastname.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    lastname.setMaximumSize(new java.awt.Dimension(60, 30));
    lastname.setMinimumSize(new java.awt.Dimension(60, 30));
    lastname.setPreferredSize(new java.awt.Dimension(60, 30));

    nextBtn =
        new Button("Next") {
          public void btnMousePressed(MouseEvent evt) {
            cardLayout.next(jPanel3);
          }
        };

    backBtn =
        new Button("Back", new java.awt.Color(18, 18, 20)) {
          public void btnMousePressed(MouseEvent evt) {
            cardLayout.previous(jPanel3);
          }
        };

    nextBtn1 =
        new Button("Next") {
          public void btnMousePressed(MouseEvent evt) {
            cardLayout.next(jPanel3);
          }
        };

    backBtn1 =
        new Button("Back", new java.awt.Color(18, 18, 20)) {
          public void btnMousePressed(MouseEvent evt) {
            cardLayout.previous(jPanel3);
          }
        };

    jLabel8.setFont(new java.awt.Font("Cascadia Code", 1, 36));
    jLabel8.setForeground(new java.awt.Color(115, 138, 219));
    jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel8.setText("REGISTER");
    jLabel8.setPreferredSize(new java.awt.Dimension(120, 50));

    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLabel9.setText("I Already have an account");

    jLogin3.setBackground(new java.awt.Color(255, 255, 255));
    jLogin3.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLogin3.setForeground(new java.awt.Color(115, 138, 219));
    jLogin3.setText("Login");
    jLogin3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLogin3.addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            cardLayout.show(jPanel3, "card2");
          }
        });

    GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel6Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(
                                firstname,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addGroup(
                                GroupLayout.Alignment.LEADING,
                                jPanel6Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        jLogin3,
                                        GroupLayout.PREFERRED_SIZE,
                                        54,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                GroupLayout.Alignment.LEADING,
                                jPanel6Layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        nextBtn,
                                        GroupLayout.PREFERRED_SIZE,
                                        140,
                                        GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, GroupLayout.Alignment.LEADING)
                            .addComponent(lastname, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(
                jPanel6Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(
                                jPanel6Layout
                                    .createSequentialGroup()
                                    .addGap(134, 134, 134)
                                    .addComponent(
                                        jLabel8,
                                        GroupLayout.PREFERRED_SIZE,
                                        220,
                                        GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel6Layout
                    .createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(
                        jLabel8,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addComponent(jLabel6)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        firstname, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel7)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        lastname, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                nextBtn,
                                GroupLayout.PREFERRED_SIZE,
                                37,
                                GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLogin3)
                            .addComponent(jLabel9))
                    .addGap(0, 0, 0)));

    GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel5Layout
                    .createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(
                        jPanel6,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)));
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel5Layout
                    .createSequentialGroup()
                    .addGap(148, 148, 148)
                    .addComponent(
                        jPanel6,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE)));

    jPanel3.add(jPanel5, "card3");

    jPanel7.setBackground(new java.awt.Color(40, 43, 48));

    jPanel8.setBackground(new java.awt.Color(40, 43, 48));
    jPanel8.setPreferredSize(new java.awt.Dimension(500, 432));

    jLabel10.setBackground(new java.awt.Color(102, 102, 102));
    jLabel10.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel10.setForeground(new java.awt.Color(115, 138, 219));
    jLabel10.setText("Mobile");

    phone.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    phone.setMaximumSize(new java.awt.Dimension(60, 30));
    phone.setMinimumSize(new java.awt.Dimension(60, 30));
    phone.setPreferredSize(new java.awt.Dimension(60, 30));

    jLabel11.setBackground(new java.awt.Color(102, 102, 102));
    jLabel11.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel11.setForeground(new java.awt.Color(115, 138, 219));
    jLabel11.setText("Email");

    email.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    email.setMaximumSize(new java.awt.Dimension(60, 30));
    email.setMinimumSize(new java.awt.Dimension(60, 30));
    email.setPreferredSize(new java.awt.Dimension(60, 30));

    jLabel12.setFont(new java.awt.Font("Cascadia Code", 1, 36));
    jLabel12.setForeground(new java.awt.Color(115, 138, 219));
    jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel12.setText("REGISTER");
    jLabel12.setPreferredSize(new java.awt.Dimension(120, 50));

    jLabel13.setForeground(new java.awt.Color(255, 255, 255));
    jLabel13.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLabel13.setText("I Already have an account");

    jLogin5.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLogin5.setForeground(new java.awt.Color(115, 138, 219));
    jLogin5.setText("Login");
    jLogin5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLogin5.addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            cardLayout.show(jPanel3, "card2");
          }
        });

    GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel8Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(
                                phone,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addGroup(
                                GroupLayout.Alignment.LEADING,
                                jPanel8Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        jLogin5,
                                        GroupLayout.PREFERRED_SIZE,
                                        54,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                GroupLayout.Alignment.LEADING,
                                jPanel8Layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        nextBtn1,
                                        GroupLayout.PREFERRED_SIZE,
                                        140,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        backBtn,
                                        GroupLayout.PREFERRED_SIZE,
                                        140,
                                        GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, GroupLayout.Alignment.LEADING)
                            .addComponent(email, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(
                jPanel8Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(
                                jPanel8Layout
                                    .createSequentialGroup()
                                    .addGap(134, 134, 134)
                                    .addComponent(
                                        jLabel12,
                                        GroupLayout.PREFERRED_SIZE,
                                        220,
                                        GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel8Layout
                    .createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(
                        jLabel12,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addComponent(jLabel10)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(phone, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel11)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(email, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup()
                            .addComponent(
                                backBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                nextBtn1,
                                GroupLayout.PREFERRED_SIZE,
                                37,
                                GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLogin5)
                            .addComponent(jLabel13))
                    .addGap(0, 0, 0)));

    GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel7Layout
                    .createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(
                        jPanel8,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)));
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel7Layout
                    .createSequentialGroup()
                    .addGap(148, 148, 148)
                    .addComponent(
                        jPanel8,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE)));

    jPanel3.add(jPanel7, "card4");

    jPanel9.setBackground(new java.awt.Color(40, 43, 48));

    jPanel10.setBackground(new java.awt.Color(40, 43, 48));
    jPanel10.setPreferredSize(new java.awt.Dimension(500, 432));

    jLabel14.setBackground(new java.awt.Color(102, 102, 102));
    jLabel14.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel14.setForeground(new java.awt.Color(115, 138, 219));
    jLabel14.setText("Username");

    registerUsername.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    registerUsername.setMaximumSize(new java.awt.Dimension(60, 30));
    registerUsername.setMinimumSize(new java.awt.Dimension(60, 30));
    registerUsername.setPreferredSize(new java.awt.Dimension(60, 30));

    jLabel15.setBackground(new java.awt.Color(102, 102, 102));
    jLabel15.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    jLabel15.setForeground(new java.awt.Color(115, 138, 219));
    jLabel15.setText("Password");

    registerPassword.setFont(new java.awt.Font("Cascadia Code", 0, 18));
    registerPassword.setMaximumSize(new java.awt.Dimension(60, 30));
    registerPassword.setMinimumSize(new java.awt.Dimension(60, 30));
    registerPassword.setPreferredSize(new java.awt.Dimension(60, 30));

    registerBtn =
        new Button("Register") {
          public void btnMousePressed(MouseEvent evt) {
            CustomerDTO profile =
                new CustomerDTO(
                    firstname.getText(),
                    lastname.getText(),
                    email.getText(),
                    phone.getText(),
                    registerUsername.getText(),
                    new String(registerPassword.getPassword()));
            try {
              profilePanelController.register(profile);
              JOptionPane.showMessageDialog(parent, "Registration Successful!");
            } catch (InvalidInputException e) {
              JOptionPane.showMessageDialog(parent, e.getMessage());
            }
          }
        };

    jLabel16.setFont(new java.awt.Font("Cascadia Code", 1, 36));
    jLabel16.setForeground(new java.awt.Color(115, 138, 219));
    jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel16.setText("REGISTER");
    jLabel16.setPreferredSize(new java.awt.Dimension(120, 50));

    jLabel17.setForeground(new java.awt.Color(255, 255, 255));
    jLabel17.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLabel17.setText("I Already have an account");

    jLogin7.setFont(new java.awt.Font("Cascadia Code", 1, 12));
    jLogin7.setForeground(new java.awt.Color(115, 138, 219));
    jLogin7.setText("Login");
    jLogin7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLogin7.addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            cardLayout.show(jPanel3, "card2");
          }
        });

    GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel10Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel10Layout
                            .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(
                                registerUsername,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addGroup(
                                GroupLayout.Alignment.LEADING,
                                jPanel10Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        jLogin7,
                                        GroupLayout.PREFERRED_SIZE,
                                        54,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                GroupLayout.Alignment.LEADING,
                                jPanel10Layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        registerBtn,
                                        GroupLayout.PREFERRED_SIZE,
                                        140,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        backBtn1,
                                        GroupLayout.PREFERRED_SIZE,
                                        140,
                                        GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, GroupLayout.Alignment.LEADING)
                            .addComponent(
                                registerPassword, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(
                jPanel10Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel10Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(
                                jPanel10Layout
                                    .createSequentialGroup()
                                    .addGap(134, 134, 134)
                                    .addComponent(
                                        jLabel16,
                                        GroupLayout.PREFERRED_SIZE,
                                        220,
                                        GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel10Layout
                    .createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(
                        jLabel16,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addComponent(jLabel14)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        registerUsername,
                        GroupLayout.PREFERRED_SIZE,
                        40,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel15)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        registerPassword,
                        GroupLayout.PREFERRED_SIZE,
                        40,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addGroup(
                        jPanel10Layout
                            .createParallelGroup()
                            .addComponent(
                                registerBtn,
                                GroupLayout.PREFERRED_SIZE,
                                37,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                backBtn1,
                                GroupLayout.PREFERRED_SIZE,
                                37,
                                GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(
                        jPanel10Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLogin7)
                            .addComponent(jLabel17))
                    .addGap(0, 0, 0)));

    GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel9Layout
                    .createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(
                        jPanel10,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)));
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel9Layout
                    .createSequentialGroup()
                    .addGap(148, 148, 148)
                    .addComponent(
                        jPanel10,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE)));

    jPanel3.add(jPanel9, "card5");

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addComponent(
                        jPanel2,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        jPanel3,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel2,
                GroupLayout.DEFAULT_SIZE,
                GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE));
  }
}
