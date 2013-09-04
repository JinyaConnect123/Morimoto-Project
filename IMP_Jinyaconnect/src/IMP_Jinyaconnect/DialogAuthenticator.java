package IMP_Jinyaconnect;

import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class DialogAuthenticator extends Authenticator {


  private JDialog passwordDialog;  
  private JLabel mainLabel = new JLabel("Please enter username and password: ");
  private JLabel userLabel = new JLabel("Username: ");
  private JLabel passwordLabel = new JLabel("Password: ");
  private JTextField usernameField = new JTextField(20);
  private JPasswordField passwordField = new JPasswordField(20);
  private JButton okButton = new JButton("OK");
  private JButton cancelButton = new JButton("Cancel");
  
  public DialogAuthenticator() {
    this("", new JFrame());
    
    TextTestFrame frame = new TextTestFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
    
  public DialogAuthenticator(String username) {
    this(username, new JFrame());
  }
    
  public DialogAuthenticator(JFrame parent) {
    this("", parent);
  }
    
  public DialogAuthenticator(String username, JFrame parent) {
    
    this.passwordDialog = new JDialog(parent, true);  
    Container pane = passwordDialog.getContentPane();
    pane.setLayout(new GridLayout(4, 1));
    pane.add(mainLabel);
    JPanel p2 = new JPanel();
    p2.add(userLabel);
    p2.add(usernameField);
    usernameField.setText(username);
    pane.add(p2);
    JPanel p3 = new JPanel();
    p3.add(passwordLabel);
    p3.add(passwordField);
    pane.add(p3);
    JPanel p4 = new JPanel();
    p4.add(okButton);
    p4.add(cancelButton);
    pane.add(p4);   
    passwordDialog.pack();
    
    ActionListener al = new OKResponse();
    okButton.addActionListener(al);
    usernameField.addActionListener(al);
    passwordField.addActionListener(al);
    cancelButton.addActionListener(new CancelResponse());
    
  }
  
  @SuppressWarnings("deprecation")
private void show() {
    
    String prompt = this.getRequestingPrompt();
    if (prompt == null) {
      String site     = this.getRequestingSite().getHostName();
      String protocol = this.getRequestingProtocol();
      int    port     = this.getRequestingPort();
      if (site != null & protocol != null) {
        prompt = protocol + "://" + site;
        if (port > 0) prompt += ":" + port;
      }
      else {
        prompt = ""; 
      }
      
    }

    mainLabel.setText("Please enter username and password for " + prompt + ": ");
    passwordDialog.pack();
    passwordDialog.show();
    
  }
  
  PasswordAuthentication response = null;

  class OKResponse implements ActionListener {
  
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
      
      passwordDialog.hide();
      // The password is returned as an array of 
      // chars for security reasons.
      char[] password = passwordField.getPassword();
      String username = usernameField.getText();
      // Erase the password in case this is used again.
      passwordField.setText("");
      response = new PasswordAuthentication(username, password);
      
    } 
    
  }

  class CancelResponse implements ActionListener {
  
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
      
      passwordDialog.hide();
      // Erase the password in case this is used again.
      passwordField.setText("");
      response = null;
      
    } 
    
  }

  public PasswordAuthentication getPasswordAuthentication() {
    
    this.show();    
    return this.response;
    
  }
  
  @SuppressWarnings("serial")
  class TextTestFrame extends JFrame {
    public TextTestFrame(){
      setTitle("TextTest");
      //setSize(300, 120);
      setBounds(640, 480, 300, 120); 
      
      final JTextField textField = new JTextField();
      final JPasswordField passwordField = new JPasswordField();
      final JButton button = new JButton("OK");
      
      button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0) {
          String password = new String(
            passwordField.getPassword());
          JOptionPane.showMessageDialog(
            null, 
            textField.getText() + " - " + password);
        }
      });
      
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(3,2));
      panel.add(new JLabel("Username:", SwingConstants.LEFT));
      panel.add(textField);
      panel.add(new JLabel("Password:", SwingConstants.LEFT));
      panel.add(passwordField);
      panel.add(button);
      
      add(panel, BorderLayout.NORTH);
    }
  }

}