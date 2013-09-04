package IMP_Jinyaconnect.ui;

public class FileWindowManager {
	private static UploadFile uf = null;
	
	public static UploadFile getUploadFileWindow()
	{
		if(uf==null)
		{
			uf = new UploadFile();
		}
		return uf;
	}
}
