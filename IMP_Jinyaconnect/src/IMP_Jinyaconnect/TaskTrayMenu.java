package IMP_Jinyaconnect;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import IMP_Jinyaconnect.auth.LoginUserInfo;
import IMP_Jinyaconnect.config.AppConfigManager;
import IMP_Jinyaconnect.dialog.Error;
import IMP_Jinyaconnect.dialog.ErrorDetails;
import IMP_Jinyaconnect.ui.FileWindowManager;
import IMP_Jinyaconnect.ui.UploadFile;
import IMP_Jinyaconnect.utils.RakujanMessageLoader;

public class TaskTrayMenu {
	private static String TIMER = AppConfigManager
			.loadProperty("connect.timer.interval");

	/** コンストラクタ */
	public TaskTrayMenu(final String[] args) throws IOException, AWTException {

		// タスクトレイアイコン
		Image image = ImageIO.read(TIMER.getClass().getResourceAsStream(
				"/Jconnect.png"));
		final TrayIcon icon = new TrayIcon(image);
		icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginUserInfo.getLoginInfo("", "ログイン情報変更", LoginUserInfo.RESET);
			}
		});

		// ポップアップメニュー
		PopupMenu menu = new PopupMenu();
		// メニューの例
		// MenuItem aItem = new MenuItem("メニューの例");
		MenuItem aItem = new MenuItem("設定");
		aItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginUserInfo.getLoginInfo("", "ログイン情報変更", LoginUserInfo.RESET);
			}
		});

		// メニューの例
		// MenuItem aItem = new MenuItem("メニューの例");
		MenuItem aFItem = new MenuItem("レコードの削除");
		aFItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//LoginUserInfo.getLoginInfo("", "ログイン情報変更", LoginUserInfo.RESET);
				FileWindowManager.getUploadFileWindow().show();;
			}
		});

		// エラー履歴
		MenuItem errorItem = new MenuItem("エラー履歴");
		errorItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (error != null) {
					error.setVisible(true);
				} else {
					String message = RakujanMessageLoader
							.getMessage("tray.info.noerror");
					String title = RakujanMessageLoader
							.getMessage("tray.timer.start.title");

					setWindowAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, message, title,
							JOptionPane.INFORMATION_MESSAGE);
					setWindowAlwaysOnTop(true);
				}
			}
		});

		// 終了メニュー
		MenuItem exitItem = new MenuItem("終了");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = RakujanMessageLoader
						.getMessage("tray.confirm.quit");
				String title = RakujanMessageLoader
						.getMessage("tray.timer.start.title");

				setWindowAlwaysOnTop(false);
				int ret = JOptionPane.showConfirmDialog(null, message, title,
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				setWindowAlwaysOnTop(true);
			}
		});

		// メニューにメニューアイテムを追加
		menu.add(aItem);
		menu.add(aFItem);
		//menu.add(errorItem);
		menu.add("-");
		menu.add(exitItem);
		icon.setPopupMenu(menu);

		// タスクトレイに格納
		SystemTray.getSystemTray().add(icon);

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				timerRun(icon, args);
			}
		};

		Timer timer = new Timer();

		int interval = 5; // デフォルト5分間隔
		if (!Util.isStringEmpty(TIMER)) {
			try {
				interval = Double.valueOf(TIMER).intValue();
			} catch (NumberFormatException e) {
			}
		}
		// ミリ秒に換算
		timer.scheduleAtFixedRate(task, 0, interval * 60 * 1000);
	}

	protected Error error = null;
	protected ErrorDetails tv = new ErrorDetails();

	private String getDateTime() {
		MessageFormat mf = new MessageFormat("{0,date,yyyy/MM/dd HH:mm}");
		Object[] objs = { Calendar.getInstance().getTime() };

		return mf.format(objs);
	}

	void timerRun(final TrayIcon icon, final String[] args) {

		String title = RakujanMessageLoader
				.getMessage("tray.timer.start.title");
		String message = RakujanMessageLoader
				.getMessage("tray.timer.start.message");

		icon.displayMessage(title, message, MessageType.INFO);

		List<String> errors = null;
		String dateTime = getDateTime();

		try {
			errors = JinyaMain.entry(args);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (errors != null && errors.size() > 0) {
				StringBuffer e = new StringBuffer();
				for (String err : errors) {
					e.append(err + "\n");
				}
				String errorText = e.toString();
				tv.addErrorDetal(dateTime, errorText);

				if (error == null) {
					error = new Error(JinyaMain.frame, tv, errorText);
					error.setLocationByPlatform(true);
					error.setSize(450, 400);
					error.setVisible(true);
				} else {
					error.setErrorMessage(tv, dateTime, errorText);
					error.setVisible(true);
				}
			}
		}
	}

	private void setWindowAlwaysOnTop(boolean alwaysOnTop) {
		for (Window w : JFrame.getWindows()) {
			w.setAlwaysOnTop(alwaysOnTop);
		}
	}
}
