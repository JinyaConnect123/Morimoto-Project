package IMP_Jinyaconnect;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.sforce.soap.partner.LoginResult;

public class CSVFileManager {

	private static String filePath = "";

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String Path) {
		filePath = Path;
	}

	public ArrayList read() {

		try {
			ArrayList rows = new ArrayList<Object>();
			ArrayList columns = new ArrayList<Object>();
			String csvFile = getFilePath();
			if (csvFile != "") {

				File file = new File(csvFile);
				if (file.isFile()) {

					// create BufferedReader to read csv file
					BufferedReader br = new BufferedReader(new FileReader(
							csvFile));
					String line = "";
					StringTokenizer st = null;

					int lineNumber = 0;
					int tokenNumber = 0;

					// read comma separated file line by line
					while ((line = br.readLine()) != null) {
						lineNumber++;

						// use comma as token separator
						st = new StringTokenizer(line, ",");

						while (st.hasMoreTokens()) {

							// display csv values
							columns.add(st.nextToken());
							// System.out.println(st.nextToken() + "  ");

						}

						System.out.println();

						rows.add(columns);
						// reset token number
						tokenNumber = 0;
					}
				}
			}
			return rows;
		} catch (Exception e) {
			System.err.println("CSV file cannot be read : " + e);
		}
		return null;
	}

	// write data to csv file

	public boolean write(ArrayList data, String fileName, boolean isSuccessFile) {

		try {
			File file = new File(".\\xml\\" + fileName);
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			for (Object item : data) {
				fw.write(item + "," + (isSuccessFile ? "success" : "failed"));
				fw.write("\n");
			}
			fw.close();
			return true;
		} catch (Exception e) {
			System.err.println("File Not created");
			return false;
		}
	}

	public byte[] writeandread(ArrayList data, String filePath,
			boolean isSuccessFile) {

		try {
			File file = new File(filePath);
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			for (Object item : data) {
				fw.write(item + "," + (isSuccessFile ? "success" : "failed"));
				fw.write("\n");
			}
			fw.close();
			return read(filePath);
		} catch (Exception e) {
			System.err.println("File Not created");
			return null;
		}
	}

	public byte[] read(String fileName) {
		try {
			File f = new File(fileName);
			InputStream is = new FileInputStream(f);
			byte[] inbuff = new byte[(int) f.length()];
			is.read(inbuff);
			return inbuff;
		} catch (Exception ex) {
			return null;
		}
	}

}
