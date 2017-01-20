package com.lql.easy;

/**
 * Created by LQL on 2016/5/19.
 */
public class CountAndSay {

    public static String countAndSay(int n) {

        String result = "1";

        int i = 1;
        while (i < n){
            result = generateString(result);
            i++;
        }
        return result;
    }

    public static String generateString(String last){
        String result = "";
        for (int i= 0 ;i < last.length();i++){
            char c = last.charAt(i);
            int count = 1;
            int n = last.length();
            for (int j = i + 1 ; j < n;j++){
                char c1 = last.charAt(j);
                if (c1 != c){
                    break;
                }
                count++;
            }
            i = i + count - 1;
            result += count + String.valueOf(c);
        }
        return result;
    }

    public static String generateString2(String last){

        char[] lastChars = last.toCharArray();
        int len = last.length();
        int count = 1;
        StringBuffer sb = new StringBuffer("");
        for (int i = 0 ; i < len ;i++){
            char c = lastChars[i];
            if ((i + 1) < len && c == lastChars[i + 1]){
                count++;
            }else{
                sb.append(count);
                sb.append(c);
                count = 1;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
