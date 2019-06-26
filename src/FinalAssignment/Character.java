package FinalAssignment;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Character {

	private String name;
	private String allegiance;
	private String messagesFile;
	private ImageIcon image;

	public Character(String name, String allegiance, String messagesFile, ImageIcon image) {
		this.name = name;
		this.allegiance = allegiance;
		this.messagesFile = messagesFile;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public String getMessagesFile() {
		return messagesFile;
	}

	public void setMessagesFile(String messagesFile) {
		this.messagesFile = messagesFile;
	}

	@Override
	public String toString() {
		return name + " is a member of " + allegiance + " and sent messages: " + messagesFile + ".";
	}

	public void printMessage() {
		for (int i = 1; i < FileHelper.loadMessages(this.messagesFile).size(); i++) {
			System.out.println(FileHelper.loadMessages(this.messagesFile).get(i));
		}
	}

	public void popUp() {
		int counterOfMessages = 0;
		for (int i = 1; i < FileHelper.loadMessages(this.messagesFile).size(); i++) {
			if (!FileHelper.loadMessages(this.messagesFile).get(i).isEmpty()) {
				counterOfMessages++;
			} else {
				continue;
			}
		}
		JOptionPane.showMessageDialog(null, "\"I sent " + counterOfMessages + " messages.\"", this.name,
				JOptionPane.INFORMATION_MESSAGE, this.image);
	}

	public static int howHappy(Character c) {
		int happy = 0;
		for (int i = 0; i < FileHelper.loadMessages(c.messagesFile).size(); i++) {
			String[] words = FileHelper.loadMessages(c.messagesFile).get(i).split(" ");
			for (String word : words) {
				for (String happyEmoji : Emoji.happyEmojis()) {
					if (word.contains(happyEmoji)) {
						happy++;
					} else {
						continue;
					}
				}
			}
		}
		return happy;
	}

	public static int howSad(Character c) {
		int sad = 0;
		for (int i = 0; i < FileHelper.loadMessages(c.messagesFile).size(); i++) {
			String[] words = FileHelper.loadMessages(c.messagesFile).get(i).split(" ");
			for (String word : words) {
				for (String sadEmoji : Emoji.sadEmojis()) {
					if (word.contains(sadEmoji)) {
						sad++;
					} else {
						continue;
					}
				}
			}
		}
		return sad;
	}

	public void disposition() {
		if (howHappy(this) > howSad(this)) {
			System.out.println(this.name + " is more happy than sad (happiness: " + howHappy(this) + " - sadness: "
					+ howSad(this) + "). -> Positive disposition");
		} else if (howHappy(this) < howSad(this)) {
			System.out.println(this.name + " is more sad than happy (happiness: " + howHappy(this) + " - sadness: "
					+ howSad(this) + "). -> Negative disposition");
		} else {
			System.out.println(this.name + " is indifferent, equally happy and sad (happiness: " + howHappy(this)
					+ " - sadness: " + howSad(this) + "). -> Neutral disposition");
		}
	}

	public static String findMostPositive(List<Character> allCharacters) {
		Character max = allCharacters.get(0);
		for (int i = 0; i < allCharacters.size(); i++) {
			Character nextOne = allCharacters.get(i);
			if (howHappy(nextOne) > howHappy(max)) {
				max = nextOne;
			}
		}
		return "Character who has the most positive disposition is: " + max.name + " (happiness: " + howHappy(max)
				+ " - sadness: " + howSad(max) + ").";
	}

	public static String findMostNegative(List<Character> allCharacters) {
		Character max = allCharacters.get(0);
		for (int i = 0; i < allCharacters.size(); i++) {
			Character nextOne = allCharacters.get(i);
			if (howSad(nextOne) > howSad(max)) {
				max = nextOne;
			}
		}
		return "Character who has the most negative disposition is: " + max.name + " (happiness: " + howHappy(max)
				+ " - sadness: " + howSad(max) + ").";
	}

	public static int loving(Character c) {
		int loving = 0;
		for (int i = 0; i < FileHelper.loadMessages(c.messagesFile).size(); i++) {
			String[] words = FileHelper.loadMessages(c.messagesFile).get(i).split(" ");
			for (String word : words) {
				for (String lovingEmoji : Emoji.lovingEmojis()) {
					if (word.contains(lovingEmoji)) {
						loving++;
					} else {
						continue;
					}
				}
			}
		}
		return loving;
	}

	public static void lovesMore(Character chOne, Character chTwo) {
		if (loving(chOne) > loving(chTwo)) {
			System.out.print(chOne.name + " loves " + chTwo.name + " more ");
		} else if (loving(chOne) < loving(chTwo)) {
			System.out.print(chOne.name + " loves " + chTwo.name + " less ");
		} else {
			System.out.print("They love each other equally ");
		}
		System.out.println("(Intensity of " + chOne.name + "'s love: " + loving(chOne) + "; intensity of " + chTwo.name
				+ "'s love: " + loving(chTwo) + ").");
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<String>> rmd = ReadMetaData.readFile();

		Character daenerysStormborn = new Character(rmd.get(0).get(0), rmd.get(1).get(0), rmd.get(2).get(0),
				new ImageIcon("resource/daenerys.png"));
		Character jonSnow = new Character(rmd.get(0).get(1), rmd.get(1).get(1), rmd.get(2).get(1),
				new ImageIcon("resource/jon.png"));
		Character tyrionLannister = new Character(rmd.get(0).get(2), rmd.get(1).get(2), rmd.get(2).get(2),
				new ImageIcon("resource/tyrion.png"));
		Character cerseiLannister = new Character(rmd.get(0).get(3), rmd.get(1).get(3), rmd.get(2).get(3),
				new ImageIcon("resource/cersei.png"));

		System.out.println(daenerysStormborn);
		System.out.println(jonSnow);
		System.out.println(tyrionLannister);
		System.out.println(cerseiLannister);
		System.out.println();

		System.out.println("All Daenerys' messages: ");
		daenerysStormborn.printMessage();
		System.out.println();

		daenerysStormborn.popUp();
		jonSnow.popUp();
		tyrionLannister.popUp();
		cerseiLannister.popUp();

		System.out.println("Does Tyrion have a positive disposition?");
		tyrionLannister.disposition();
		System.out.println();

		List<Character> gameOfThrones = new ArrayList<Character>();
		gameOfThrones.add(daenerysStormborn);
		gameOfThrones.add(jonSnow);
		gameOfThrones.add(tyrionLannister);
		gameOfThrones.add(cerseiLannister);

		System.out.println("Who has the most positive disposition?");
		System.out.println(findMostPositive(gameOfThrones));
		System.out.println();

		System.out.println("Who has the most negative disposition?");
		System.out.println(findMostNegative(gameOfThrones));
		System.out.println();

		System.out.println("Does Jon love Daenerys more than she loves him?");
		lovesMore(jonSnow, daenerysStormborn);

	}

}
