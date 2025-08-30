import java.util.*;

public class EmotionDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined keywords mapped to emotions
        Map<String, String> emotionMap = new HashMap<>();
        emotionMap.put("happy", "😊 Joy");
        emotionMap.put("joy", "😊 Joy");
        emotionMap.put("glad", "😊 Joy");
        emotionMap.put("excited", "😊 Joy");
        emotionMap.put("love", "❤️ Love");

        emotionMap.put("sad", "😢 Sadness");
        emotionMap.put("cry", "😢 Sadness");
        emotionMap.put("alone", "😢 Sadness");
        emotionMap.put("depressed", "😢 Sadness");

        emotionMap.put("angry", "😡 Anger");
        emotionMap.put("mad", "😡 Anger");
        emotionMap.put("furious", "😡 Anger");
        emotionMap.put("hate", "😡 Anger");

        emotionMap.put("scared", "😨 Fear");
        emotionMap.put("fear", "😨 Fear");
        emotionMap.put("afraid", "😨 Fear");
        emotionMap.put("nervous", "😨 Fear");

        System.out.println("=== Emotion Detector from Text ===");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter a sentence: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting Emotion Detector. Goodbye!");
                break;
            }

            // Split into words
            String[] words = input.split("\\s+");
            Map<String, Integer> emotionCount = new HashMap<>();

            // Count emotions
            for (String word : words) {
                if (emotionMap.containsKey(word)) {
                    String emotion = emotionMap.get(word);
                    emotionCount.put(emotion, emotionCount.getOrDefault(emotion, 0) + 1);
                }
            }

            // Detect dominant emotion
            if (emotionCount.isEmpty()) {
                System.out.println("No emotion detected.");
            } else {
                String dominantEmotion = Collections.max(emotionCount.entrySet(), Map.Entry.comparingByValue()).getKey();
                System.out.println("Detected Emotion: " + dominantEmotion);
            }
        }

        scanner.close();
    }
}
