package IMP_Jinyaconnect.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import IMP_Jinyaconnect.CSVFileManager;
import IMP_Jinyaconnect.SDFCManager;

public class UploadFile extends JDialog implements ActionListener {
	static private final String newline = "\n";

	JPanel jp;
	JButton openButton, saveButton;
	JLabel flabel;

	int returnVal=0;
	JTextArea log;

	JFileChooser fc;

	public UploadFile() {
		// super(new BorderLayout());

		// Create the log first, because the action listeners
		// need to refer to it.
		this.setBounds(500, 200, 600, 450);
		this.setAlwaysOnTop(false);
		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);

		// Create a file chooser
		fc = new JFileChooser();

		// Uncomment one of the following lines to try a different
		// file selection mode. The first allows just directories
		// to be selected (and, at least in the Java look and feel,
		// shown). The second allows both files and directories
		// to be selected. If you leave these lines commented out,
		// then the default mode (FILES_ONLY) will be used.
		//
		// fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		// Create the open button. We use the image from the JLF
		// Graphics Repository (but we extracted it from the jar).
		openButton = new JButton("Choose File");
		openButton.addActionListener(this);

		// Create the save button. We use the image from the JLF
		// Graphics Repository (but we extracted it from the jar).
		saveButton = new JButton("Continue");
		saveButton.addActionListener(this);

		// For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel(); // use FlowLayout
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);

		// Add the buttons and the log to this panel.
		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {

		// Handle open button action.
		if (e.getSource() == openButton) {
			 returnVal = fc.showOpenDialog(UploadFile.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				// This is where a real application would open the file.
				log.append("Opening: " + file.getPath() + "." + newline);
				
				

	                // Allows files with .rtf extension to be seen.
	               
								
			} else {
				log.append("Open command cancelled by user." + newline);
			}
			log.setCaretPosition(log.getDocument().getLength());

			// Handle save button action.
		} else if (e.getSource() == saveButton) {
			//int returnVal = fc.showSaveDialog(UploadFile.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				// This is where a real application would save the file.
				accept(file);
				log.append("Reading: " + file.getPath() + "." + newline);
				CSVFileManager fm = new CSVFileManager();
				CSVFileManager.setFilePath(file.getPath());
				ArrayList data = fm.read();
				SDFCManager sm = new SDFCManager();
				sm.delete(data);
				log.append("Success Records." + sm.getSucessCount());
				log.append("Failed Records." + sm.getFailedCount());
				
			} else {
				log.append("Read command cancelled by user." + newline);
			}
			log.setCaretPosition(log.getDocument().getLength());
		}
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = UploadFile.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	

    public boolean accept(File f) {
        
        // Allow directories to be seen.
        if (f.isDirectory()) return true;

        // Allows files with .rtf extension to be seen.
        if (f.getName().toLowerCase().endsWith(".csv"))
            return true;

        // Otherwise file is not shown.
        return false;
    }


	@Override
	public void setSize(int width, int height) {
		super.setSize(375, 180);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		JFrame frame = new JFrame("SwingFileChooserDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JDialog newContentPane = new UploadFile();
		// newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	/*
	 * public static void main(String[] args) { //Schedule a job for the
	 * event-dispatching thread: //creating and showing this application's GUI.
	 * javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run()
	 * { createAndShowGUI(); } }); }
	 */
}
