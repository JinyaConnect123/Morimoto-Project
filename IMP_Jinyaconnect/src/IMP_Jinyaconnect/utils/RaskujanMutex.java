package IMP_Jinyaconnect.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Properties;

import IMP_Jinyaconnect.JinyaException;
import IMP_Jinyaconnect.Util;

public class RaskujanMutex {
	private FileOutputStream os = null;
	private FileChannel fc = null;
	private FileLock lock = null;
	
	public RaskujanMutex() throws JinyaException {
		// Propertiesオブジェクトを生成
		Properties sysConfig = new Properties();
		try {
			// アプリ起動用必須パラメータを取得する
			InputStream input= sysConfig.getClass().getResourceAsStream("/config.properties");
			sysConfig.load(input);
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
			String[] ps = new String[] {"「config.properties」ファイル"};
			JinyaException re = new JinyaException(90, "error.config.error", ps);
			throw re;
		}
		
		String mutexPath = sysConfig.getProperty("mutex.file.path");
		
		if ( Util.isStringEmpty(mutexPath) ) {
			String[] ps = new String[] {"「mutex.file.path」定義"};
			JinyaException re = new JinyaException(90, "error.config.error", ps);
			throw re;
		}
		
		try {
			File lockFile = new File(mutexPath + "lock");
			os = new FileOutputStream(lockFile);
			fc = os.getChannel();
			lock = fc.tryLock();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public FileLock getLock() {
		return lock;
	}
	
	public boolean fileMutex(Properties sysConfig) throws JinyaException {
		boolean ret = false;
		try {
			String mutexPath = sysConfig.getProperty("mutex.file.path");
			if ( Util.isStringEmpty(mutexPath) ) {
				JinyaException re = new JinyaException(90, "", new String[] {});
				throw re;
			}
			File lockFile = new File("lock");
			FileOutputStream fos = new FileOutputStream(lockFile);
			final FileChannel fc = fos.getChannel();
			final FileLock lock = fc.tryLock();
			if (lock != null) {
				return true;
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		return ret;
	}
	
	public void releaseMutex() {
		try {
			if (lock != null) {
				if (lock.isValid()) lock.release();
			}
			fc.close();
			os.close();
		} catch (IOException e) {
		}
	}
}
