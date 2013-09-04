package IMP_Jinyaconnect.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import IMP_Jinyaconnect.Util;
import IMP_Jinyaconnect.utils.RakujanMessageLoader;

public class Error extends JDialog  {

	private static final long serialVersionUID = 7928930890694388975L;
	private static Font FONT = new Font("ＭＳ ゴシック", Font.PLAIN, 12);
	
	private static String CAPTION = RakujanMessageLoader.getMessage("tray.error.caption");
	
	int  ret_val;
	protected JTextArea textArea = null;
	protected JTable table;
	protected JFrame frame;
	
	private static int WIDTH_COL_DATETIME = 125;
	
    public Error(JFrame frame, ErrorDetails tv, String errorText)  {
        super(frame, CAPTION, false);
        this.frame = frame;
        
        refresh(tv, errorText);
    }
    
    private void refresh(ErrorDetails tv, String errorText) {
    	getContentPane().removeAll();
    	
        JButton btn_ok = new JButton("OK");
        btn_ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ret_val = 1;
                dispose();
            }
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel pnl = new JPanel();
        pnl.setFont(FONT);

        table = new JTable(tv);	
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// ダブルクリックの処理
				if (e.getClickCount() == 1) {
					Point p = e.getPoint();
					int row = table.convertRowIndexToModel(table.rowAtPoint(p));
					String errorDetail = (String) table.getValueAt(row, ErrorDetails.ERROR_DTL);
					textArea.setText(errorDetail);
				}
			}
		});
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel) table.getColumnModel();
		TableColumn column = columnModel.getColumn(0);
		column.setPreferredWidth(WIDTH_COL_DATETIME);
		column.setMinWidth(WIDTH_COL_DATETIME);
		column.setMaxWidth(WIDTH_COL_DATETIME);
		column.setResizable(false);
		
		JScrollPane jsp = new JScrollPane(table);
		pnl.add(jsp, BorderLayout.CENTER);
		
        textArea = new JTextArea(errorText);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        Color col = Util.getColor(0xffffee, 0.5f);
        Border border = BorderFactory.createLineBorder(col, 1);
        textArea.setBorder(border);
       
        pnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl.add( Box.createVerticalGlue() );
	    pnl.add(textArea);
	    pnl.add(Box.createVerticalStrut(5));
	    pnl.add(btn_ok);
		
        getContentPane().add(pnl);
        frame.pack();
    }
    
	public void setErrorMessage(ErrorDetails tv, String dateTime, String errorText) {
		refresh(tv, errorText);
		textArea.setText(errorText);
	}
    
    int getButtonValue() {
        return ret_val;
    }
}
