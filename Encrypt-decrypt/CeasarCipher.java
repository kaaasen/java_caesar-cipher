import java.util.Scanner;

public class CeasarCipher {
    private static String sentence;
    private static boolean isEncrypted;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Store sentence");
            System.out.println("2. Encrypt sentence");
            System.out.println("3. Decrypt sentence");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    storeSentence(scanner);
                    break;
                case 2:
                    encryptSentence();
                    break;
                case 3:
                    decryptSentence();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 4);
    }

    private static void storeSentence(Scanner scanner) {
        System.out.print("Enter a sentence to store: ");
        sentence = scanner.nextLine();
        isEncrypted = false;
        System.out.println("Sentence stored successfully.");
    }

    private static void encryptSentence() {
        if (sentence != null && !isEncrypted) {
            StringBuilder encryptedSentence = new StringBuilder();

            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c)) {
                        c = (char) ((c + 1 - 'A') % 26 + 'A');
                    } else {
                        c = (char) ((c + 1 - 'a') % 26 + 'a');
                    }
                }
                encryptedSentence.append(c);
            }

            sentence = encryptedSentence.toString();
            isEncrypted = true;
            System.out.println("Sentence encrypted successfully.");
            System.out.println(sentence);
        } else {
            System.out.println("No sentence stored or sentence already encrypted.");
        }
    }

    private static void decryptSentence() {
        if (sentence != null && isEncrypted) {
            StringBuilder decryptedSentence = new StringBuilder();

            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c)) {
                        c = (char) ((c - 1 - 'A' + 26) % 26 + 'A');
                    } else {
                        c = (char) ((c - 1 - 'a' + 26) % 26 + 'a');
                    }
                }
                decryptedSentence.append(c);
            }

            sentence = decryptedSentence.toString();
            isEncrypted = false;
            System.out.println("Sentence decrypted successfully.");
            System.out.println(sentence);
        } else {
            System.out.println("No sentence stored or sentence not encrypted.");
        }
    }
}
