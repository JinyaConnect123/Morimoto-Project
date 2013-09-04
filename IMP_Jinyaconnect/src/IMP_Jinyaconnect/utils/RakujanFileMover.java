package IMP_Jinyaconnect.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

import IMP_Jinyaconnect.JinyaException;
import IMP_Jinyaconnect.define.RakujanConst;

public class RakujanFileMover {
	private static Logger logger = Logger.getLogger(RakujanFileMover.class);
	
	private static final String _error_filemove_cannotmove_ = "errors.filemove.cannotmove";
	
	public static void moveFile(String sourcePath, String targetPath, String fileName) throws IOException {
		logger.info("moveFile Start [" + fileName + "]");
		String sourceFileName = sourcePath + fileName;
		File sourceFile = new File(sourceFileName);
		
		String targetFileName = targetPath + fileName;
		File overFile = new File(targetFileName);
		
		// 同名ファイル存在
		if (overFile.isFile()) {
			long moveTime = (new Date()).getTime(); //overFile.lastModified();
			String timeStamp = RakujanConst.DATE_FMT3.format(moveTime);
			String targetBackup = targetPath + fileName + "." + timeStamp;
			
			File target = new File(targetBackup);
			if (target.isFile()) {
				target.renameTo(new File( "(copy)" + targetBackup));
			}
			overFile.renameTo(new File(targetBackup));
		}
		
		// 移動先ファイル名
		File moveFile = new File(targetFileName);
		boolean isMoved = sourceFile.renameTo(moveFile);
		if (!isMoved) {
			logger.error("moveFile error end [" + fileName + "]");
			// MessageKey: XXXX1
			// Message: "取込み済のXMLファイルが処理済フォルダーに移動できない。({0})"
			String work = targetFileName.replaceAll("\\\\", "\\\\\\\\");
			Exception e = new JinyaException(90, _error_filemove_cannotmove_, new String[] {work} );
			
			throw new IOException( e );
		}
		logger.info("moveFile end [" + fileName + "]");
	}
}
