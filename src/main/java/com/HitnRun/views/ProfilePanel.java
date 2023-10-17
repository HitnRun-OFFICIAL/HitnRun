package com.HitnRun.views;

import com.HitnRun.controllers.ProfilePanelController;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.utils.Authenticator;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.PopupFactory;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

public class ProfilePanel extends javax.swing.JPanel {
  private JFrame parent;
  private javax.swing.JLabel deleteBtn;
  private javax.swing.JTextField email;
  private javax.swing.JTextField firstname;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JPanel itemView;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField lastname;
  private javax.swing.JTextField password;
  private javax.swing.JTextField phone;
  private javax.swing.JLabel updateBtn;
  private javax.swing.JTextField username;
  private java.awt.GridLayout gridLayout;
  private CustomerDTO profile;
  private ProfilePanelController profilePanelController;
  private PopupFactory pf;
  private PopUpPanel popUpPanel;

  public ProfilePanel(JFrame parent) {
    this.parent = parent;
    initComponents();
    viewProfile();
    viewItems();
  }

  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    itemView = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    updateBtn = new javax.swing.JLabel();
    deleteBtn = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    username = new javax.swing.JTextField();
    password = new javax.swing.JTextField();
    jPanel4 = new javax.swing.JPanel();
    email = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    lastname = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    phone = new javax.swing.JTextField();
    firstname = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    profile = new CustomerDTO();
    gridLayout = new java.awt.GridLayout(1, 0, 30, 30);
    profilePanelController = new ProfilePanelController();
    pf = new PopupFactory();

    setBackground(new java.awt.Color(40, 43, 48));
    setMaximumSize(new java.awt.Dimension(1280, 728));
    setMinimumSize(new java.awt.Dimension(1280, 728));
    setPreferredSize(new java.awt.Dimension(1280, 728));

    jLabel1.setMaximumSize(new java.awt.Dimension(32, 32));
    jLabel1.setMinimumSize(new java.awt.Dimension(32, 32));
    jLabel1.setPreferredSize(new java.awt.Dimension(32, 32));
    jLabel1.setIcon(FontIcon.of(MaterialDesign.MDI_ACCOUNT_BOX, 32, Color.WHITE));

    jLabel2.setBackground(new java.awt.Color(40, 43, 48));
    jLabel2.setFont(new java.awt.Font("Cantarell", 1, 32)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(115, 132, 219));
    jLabel2.setText("Profile");

    jScrollPane1.setBackground(new java.awt.Color(40, 43, 48));
    jScrollPane1.setBorder(null);
    jScrollPane1.setHorizontalScrollBarPolicy(
        javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(
        javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane1.setMaximumSize(new java.awt.Dimension(960, 325));
    jScrollPane1.setMinimumSize(new java.awt.Dimension(960, 325));
    jScrollPane1.setPreferredSize(new java.awt.Dimension(960, 325));
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);

    itemView.setBackground(new java.awt.Color(40, 43, 48));
    itemView.setMinimumSize(new java.awt.Dimension(960, 325));
    itemView.setLayout(gridLayout);
    jScrollPane1.setViewportView(itemView);

    jPanel2.setBackground(new java.awt.Color(40, 43, 48));
    jPanel2.setPreferredSize(new java.awt.Dimension(960, 225));

    jPanel3.setBackground(new java.awt.Color(40, 43, 48));
    jPanel3.setPreferredSize(new java.awt.Dimension(325, 225));

    updateBtn.setBackground(new java.awt.Color(115, 132, 219));
    updateBtn.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    updateBtn.setForeground(new java.awt.Color(255, 255, 255));
    updateBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    updateBtn.setText("UPDATE");
    updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    updateBtn.setMaximumSize(new java.awt.Dimension(54, 25));
    updateBtn.setMinimumSize(new java.awt.Dimension(54, 25));
    updateBtn.setOpaque(true);
    updateBtn.setPreferredSize(new java.awt.Dimension(54, 25));
    updateBtn.addMouseMotionListener(
        new java.awt.event.MouseMotionAdapter() {
          public void mouseMoved(java.awt.event.MouseEvent evt) {
            updateBtnMouseMoved(evt);
          }
        });
    updateBtn.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseExited(java.awt.event.MouseEvent evt) {
            updateBtnMouseExited(evt);
          }

          public void mousePressed(java.awt.event.MouseEvent evt) {
            updateBtnMousePressed(evt);
          }
        });

    deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
    deleteBtn.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
    deleteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    deleteBtn.setText("DELETE");
    deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    deleteBtn.setMaximumSize(new java.awt.Dimension(54, 25));
    deleteBtn.setMinimumSize(new java.awt.Dimension(54, 25));
    deleteBtn.setOpaque(true);
    deleteBtn.setPreferredSize(new java.awt.Dimension(54, 25));

    deleteBtn.addMouseMotionListener(
        new java.awt.event.MouseMotionAdapter() {
          public void mouseMoved(java.awt.event.MouseEvent evt) {
            deleteBtnMouseMoved(evt);
          }
        });
    deleteBtn.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseExited(java.awt.event.MouseEvent evt) {
            deleteBtnMouseExited(evt);
          }

          public void mousePressed(java.awt.event.MouseEvent evt) {
            deleteBtnMousePressed(evt);
          }
        });

    jLabel13.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(115, 132, 219));
    jLabel13.setText("Password");

    jLabel11.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(115, 132, 219));
    jLabel11.setText("Username");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel3Layout
                    .createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        username,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(23, 23, 23)
                                    .addComponent(
                                        password,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(
                                updateBtn,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                deleteBtn,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addGap(44, 44, 44)));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(
                                username,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                25,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(
                                password,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                25,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(
                        updateBtn,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        deleteBtn,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)));

    jPanel4.setBackground(new java.awt.Color(40, 43, 48));
    jPanel4.setPreferredSize(new java.awt.Dimension(325, 225));

    jLabel6.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(115, 132, 219));
    jLabel6.setText("Phone");

    jLabel5.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(115, 132, 219));
    jLabel5.setText("Email");

    jLabel3.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(115, 132, 219));
    jLabel3.setText("Firstname");

    jLabel4.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(115, 132, 219));
    jLabel4.setText("Lastname");

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel4Layout
                    .createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(
                        jPanel4Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                    .addGap(27, 27, 27)
                    .addGroup(
                        jPanel4Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                firstname,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                200,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                phone,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                200,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                lastname,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                200,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                email,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                200,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(44, Short.MAX_VALUE)));
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel4Layout
                    .createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(
                        jPanel4Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(
                                firstname,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                25,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel4Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(
                                lastname,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                25,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel4Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(
                                email,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                25,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel4Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(
                                phone,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                25,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(36, Short.MAX_VALUE)));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        jPanel4,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                    .addComponent(
                        jPanel3,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                jPanel3,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                jPanel4,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))));

    jLabel7.setMaximumSize(new java.awt.Dimension(32, 32));
    jLabel7.setMinimumSize(new java.awt.Dimension(32, 32));
    jLabel7.setPreferredSize(new java.awt.Dimension(32, 32));
    jLabel7.setIcon(FontIcon.of(MaterialDesign.MDI_HISTORY, 32, Color.WHITE));

    jLabel8.setBackground(new java.awt.Color(40, 43, 48));
    jLabel8.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(115, 132, 219));
    jLabel8.setText("Rental History");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap(122, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        jLabel7,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8))
                            .addGroup(
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(
                                        jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        960,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        layout
                                            .createSequentialGroup()
                                            .addComponent(
                                                jLabel1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(
                                                        jPanel2,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(160, 160, 160)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(
                                jLabel1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(
                        jPanel2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        231,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(
                                jLabel7,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        325,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()));
  }

  private void updateBtnMouseMoved(java.awt.event.MouseEvent evt) {
    updateBtn.setBackground(new Color(121, 138, 225));
  }

  private void updateBtnMouseExited(java.awt.event.MouseEvent evt) {
    updateBtn.setBackground(new Color(115, 132, 219));
  }

  private void updateBtnMousePressed(java.awt.event.MouseEvent evt) {
    profile = Authenticator.getProfile();
    profile.setFirstName(firstname.getText());
    profile.setLastName(lastname.getText());
    profile.setEmail(email.getText());
    profile.setPhone(phone.getText());
    profile.setUsername(username.getText());
    String pass = new String(password.getText());
    if (!pass.equals("********")) {
      profile.setPassword(pass);
    }
    profilePanelController.updateProfile(profile);

    pf.getPopup(parent, new PopUpPanel("Successfully Updated!"), 440, 284).show();
  }

  private void deleteBtnMouseMoved(java.awt.event.MouseEvent evt) {
    deleteBtn.setBackground(new java.awt.Color(255, 67, 57));
  }

  private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {
    deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
  }

  private void deleteBtnMousePressed(java.awt.event.MouseEvent evt) {
    profile = Authenticator.getProfile();
    profilePanelController.deleteProfile(profile.getCustomerID());
    new PopupFactory().getPopup(parent, new PopUpPanel("Successfully Deleted!"), 440, 284);
    Authenticator.logout();
  }

  public void viewProfile() {
    CustomerDTO profile = Authenticator.getProfile();
    if (profile.getUsername() == null) {
      firstname.setText("[firstname]");
      lastname.setText("[lastname]");
      email.setText("[email]");
      phone.setText("[phone]");
      username.setText("[username]");
      password.setText("********");
    } else {
      firstname.setText(profile.getFirstName());
      lastname.setText(profile.getLastName());
      email.setText(profile.getEmail());
      phone.setText(profile.getPhone());
      username.setText(profile.getUsername());
      password.setText("********");
    }
  }

  private void viewItems() {
    List<RentalDTO> list = profilePanelController.getRentals();
    for (RentalDTO rental : list) {
      gridLayout.setRows(gridLayout.getRows() + 1);
      itemView.add(new HistoryItem(rental));
    }
  }
}
