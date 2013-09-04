package IMP_Jinyaconnect.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Properties;

import org.apache.log4j.Logger;

import IMP_Jinyaconnect.JinyaException;

public class RakujanFileGetter {
	private static Logger logger = Logger.getLogger(RakujanFileGetter.class);
	
	private static final String _digester_xmlDataPath_ = "digester.xmlDataPath";
	private static final String _digester_xmlOverPath_ = "digester.xmlOverPath";
	private static final String _digester_xmlErrorPath_ = "digester.xmlErrorPath";
	
	private static final String _error_xmlpath_readin_    = "error.xmlpath.readin";
	private static final String _error_xmlpath_writeout_  = "error.xmlpath.writeout";
	private static final String _error_xmlpath_moveover_  = "error.xmlpath.moveover";
	private static final String _error_xmlpath_moveerror_ = "error.xmlpath.moveerror";
	
	private static final int _xmlfile_get_error_code_ = 90;
	
	public static String getDataPath(Properties conProp) throws JinyaException {
		File xmlDataFolder = getXmlDataFile(conProp);
		if (!xmlDataFolder.isDirectory()) {
			boolean createDir = false;
			try {
				createDir = xmlDataFolder.mkdir();
			} catch(Exception e) {}
			
			if (!createDir){
				JinyaException e = new JinyaException(
						_xmlfile_get_error_code_, _error_xmlpath_writeout_, new String[]{});
				logger.error(e);
				throw e;
			}
		}
		
		String dataXmlDataPath = xmlDataFolder.getAbsolutePath() + File.separator ;
		
		return dataXmlDataPath;
	}
	
	private static File getXmlDataFile(Properties conProp) throws JinyaException {
		File xmlDataFolder = new File(conProp.getProperty(_digester_xmlDataPath_));
		if (!xmlDataFolder.isDirectory()) {
			JinyaException e = new JinyaException(
					_xmlfile_get_error_code_, _error_xmlpath_readin_, new String[]{});
			logger.error(e);
			throw e;
		}
		
		return xmlDataFolder;
	}

	public static String[] getSyncFileLst(Properties conProp) throws JinyaException {
		File xmlDataFolder = getXmlDataFile(conProp);
		return xmlDataFolder.list(new FilenameFilter() {
			private final String FILTER_KEYWORD = ".xml";
			@Override
			public boolean accept(File dir, String name) {
				// Fileクラスのオブジェクト生成
				File file = new File(name);

				// ディレクトリならばfalseを返却(リストに追加しない)
				if(file.isDirectory()){ return false; }

				// ファイル名の末尾が".xml"ならばtrueを返却(リストに追加)
				// そうでなければfalseを返却(リストに追加しない)
				return (name.endsWith(FILTER_KEYWORD));
			}
		});
	}

	public static String getOverPath(Properties conProp) throws JinyaException {
		File xmlOverFolder = new File( conProp.getProperty(_digester_xmlOverPath_) );
		if (!xmlOverFolder.isDirectory()) {
			boolean createDir = false;
			try {
				createDir = xmlOverFolder.mkdir();
			} catch(Exception e) {}
			
			if (!createDir){
				JinyaException e = new JinyaException(
						_xmlfile_get_error_code_, _error_xmlpath_moveover_, new String[]{});
				logger.error(e);
				throw e;
			}
		}
		
		return getFormatPath(xmlOverFolder);
	}
	
	public static String getErrorPath(Properties conProp) throws JinyaException {
		File xmlErrorFolder = new File( conProp.getProperty(_digester_xmlErrorPath_) );
		if (!xmlErrorFolder.isDirectory()) {
			boolean createDir = false;
			try {
				createDir = xmlErrorFolder.mkdir();
			} catch(Exception e) {}
			
			if (!createDir){
				JinyaException e = new JinyaException(
						_xmlfile_get_error_code_, _error_xmlpath_moveerror_, new String[]{});
				logger.error(e);
				throw e;
			}
		}
		
		return getFormatPath(xmlErrorFolder);
	}
	
	private static String getFormatPath(File folder) {
		return folder.getAbsolutePath() + File.separator ; 
	}
}
