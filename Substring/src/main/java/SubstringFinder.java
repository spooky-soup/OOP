import java.io.*;
import java.util.ArrayList;

public class SubstringFinder {
    public static int[] findSubstring(String file, String word) {
        ArrayList<Integer> resIndexes = new ArrayList<>();
        char[] buffer = new char[word.length()];
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
         {
             int i = 0;
             var substring = word.toCharArray();
             boolean isSubstring = true;
             while (true) {
                reader.mark(2*word.length());
                if (reader.read(buffer, 0, word.length()) < word.length()) break;
                for (int k = 0; k < word.length(); k++) {
                    if (buffer[k] != substring[k]) {
                        isSubstring = false;
                        break;
                    }
                }
                if (isSubstring) {
                    resIndexes.add(i);
                }
                isSubstring = true;
                i += 1;
                reader.reset();
                if (reader.skip(1) != 1) break;
            }
            System.out.println(resIndexes);
        } catch (IOException ignored) {
        }
        return resIndexes.stream().mapToInt(Integer::intValue).toArray();
    }
}


