package IMP_Jinyaconnect.auth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import IMP_Jinyaconnect.Util;
import IMP_Jinyaconnect.utils.RakujanMessageLoader;

public class DialogAuth extends JDialog {
	private static final long serialVersionUID = 4474575130160708138L;
	
	private static final String caption = RakujanMessageLoader.getMessage("tray.login.caption");
	
	private static Font FONT = new Font("ＭＳ ゴシック", Font.PLAIN, 12);
	
	public DialogAuth(String defaultUser, JFrame frame, String message) {
		super(frame, caption, true);
		
		final JTextField userField = new JTextField(defaultUser);
		final JPasswordField passField = new JPasswordField();
		final JButton btnOK = new JButton("OK");
        final JTextArea textArea = new JTextArea();
        
        textArea.setEditable(false);
        textArea.setText(message);
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(3,3,3,3));
        Color col = Util.getColor(0xffffee, 0.5f);
        Border border = BorderFactory.createLineBorder(col, 1);
        textArea.setBorder(border);
        
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String user = userField.getText();
				char[] pass = passField.getPassword();
				loginInfo = new PasswordAuthentication(user, pass);
				dispose();
			}
		});

		JPanel loginPanel = new JPanel();
		
		loginPanel.setFont(FONT); 
		loginPanel.setLayout(new GridLayout(2, 2));
		loginPanel.add(new JLabel("Username:", SwingConstants.LEFT));
		loginPanel.add(userField);
		loginPanel.add(new JLabel("Password:", SwingConstants.LEFT));
		loginPanel.add(passField);
		
		add(loginPanel, BorderLayout.NORTH);
		
		JPanel guidePanel = new JPanel();
		guidePanel.setLayout(new FlowLayout());

		guidePanel.add(btnOK);
		
		guidePanel.add(Box.createVerticalStrut(5));
        guidePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        guidePanel.setLayout(new BoxLayout(guidePanel, BoxLayout.Y_AXIS));
        guidePanel.add( Box.createVerticalGlue() );
		guidePanel.add(textArea);
		
		add(guidePanel, BorderLayout.CENTER);
		
		frame.pack();
	}
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(375, 180);
	}
	
	PasswordAuthentication loginInfo = null;

	public PasswordAuthentication getLoginInfo() {
		return this.loginInfo;
	}
}