package FinalAssignment;

import java.util.ArrayList;

public class Emoji {

	public static ArrayList<String> happyEmojis() {

		ArrayList<String> happyEmojiList = new ArrayList<String>();
		happyEmojiList.add("😄");
		happyEmojiList.add("🙂");
		happyEmojiList.add("😊");
		happyEmojiList.add("😍");

		return happyEmojiList;
	}

	public static ArrayList<String> sadEmojis() {

		ArrayList<String> sadEmojiList = new ArrayList<String>();
		sadEmojiList.add("😢");
		sadEmojiList.add("😭");
		sadEmojiList.add("😞");
		sadEmojiList.add("👿");

		return sadEmojiList;
	}

	public static ArrayList<String> lovingEmojis() {

		ArrayList<String> lovingEmojiList = new ArrayList<String>();
		lovingEmojiList.add("😍");
		lovingEmojiList.add("😘");

		return lovingEmojiList;
	}

}
