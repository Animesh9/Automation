import java.util.HashMap;
import java.util.Map;

public class TestCode {
    public static void main(String[] args) {
        String str = "some value";

        // Create a HashMap to store character frequencies
        Map<Character, Integer> charFreq = new HashMap<>();

        // Count frequency of each character in the string
        for (char c : str.toCharArray()) {
            if (charFreq.containsKey(c)) {
                charFreq.put(c, charFreq.get(c) + 1);
            } else {
                charFreq.put(c, 1);
            }
        }

        // Print character frequencies
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
