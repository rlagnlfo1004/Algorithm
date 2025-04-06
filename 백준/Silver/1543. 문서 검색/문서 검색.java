import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String word = br.readLine();

        int count = 0;
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == word.charAt(j)) {
                if (++j == word.length()) {
                    count++;
                    j = 0;
                }
            } else {
                i -= j;
                j = 0;
            }
        }
        System.out.println(count);
    }
}