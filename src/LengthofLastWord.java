/**
 * Created by LQL on 2016/5/16.
 */
public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {

        if (s.length() == 0 || s == null){
            return 0;
        }

        String[] strings = s.split(" ");
        if (strings.length == 0){
            return 0;
        }
        int len = strings[strings.length - 1].length();
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("  "));
    }


}
