package testData;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

public class TestTransformFile {

	private static Logger logger = Logger.getLogger(TestTransformFile.class
			.getName());

	ArrayList<String> lignes = new ArrayList<String>();

	public TestTransformFile() {
		String inputFile = "/home/deltadrone3/development/autofocus/calibration/test/calib_prod1_3.data";
		String outputFile = "/home/deltadrone3/development/autofocus/calibration/test/calib_prod1_3_IMU_ACCEL.data";
		// Read
		try {
			InputStream ips = new FileInputStream(inputFile);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				// int indexOfFirstSpace = ligne.indexOf(" ");
				// String s = ligne.substring(0, indexOfFirstSpace);
				// s += " 5";
				// s += ligne.substring(ligne.indexOf(" ", indexOfFirstSpace +
				// 1));
				// lignes.add(s);
				if (ligne.contains("ACCEL")) {
					lignes.add(ligne);
				}

			}
			br.close();
		} catch (Exception e) {
			logger.info(e.toString());
		}
		// Write
		try {
			String nl = System.getProperty("line.separator");
			FileWriter fs = new FileWriter(outputFile);
			for (String line : lignes) {
				fs.write(line);
				fs.write(nl);
			}
			fs.close();
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestTransformFile();
	}

}
