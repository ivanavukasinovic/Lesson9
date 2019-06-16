package FinalAssignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadMetaData {

	static Scanner document;

	public static ArrayList<ArrayList<String>> readFile() {

		try {
			document = new Scanner(new File("resource/got_meta_data.txt"));
		} catch (Exception e) {
			System.out.println("Error!");
		}

		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> allegianceList = new ArrayList<String>();
		ArrayList<String> messageFileList = new ArrayList<String>();
		ArrayList<ArrayList<String>> superList = new ArrayList<ArrayList<String>>();

		while (document.hasNext()) {

			String nameMD = document.next();
			String allegianceMD = document.next();
			String messageFileMD = document.next();

			while (document.hasNext()) {
				nameMD = document.next() + " " + document.next().replaceAll(",", "");
				nameList.add(nameMD);
				allegianceMD = document.next() + " " + document.next().replaceAll(",", "");
				allegianceList.add(allegianceMD);
				messageFileMD = document.next();
				messageFileList.add(messageFileMD);
			}

			superList.add(nameList);
			superList.add(allegianceList);
			superList.add(messageFileList);

		}

		return superList;
	}

}
