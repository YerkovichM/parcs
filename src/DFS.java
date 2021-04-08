import parcs.AM;
import parcs.AMInfo;
import parcs.channel;
import parcs.point;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class DFS implements AM {
    public void run(AMInfo info) {
        String name = (String) info.parent.readObject();
        System.out.println("[" + name + "] Build started.");
        StringBuffer res = encrypt(name, 4);
        System.out.println("[" + name + "] Build finished.");
        info.parent.write(res);
    }

    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

}
