package com.lql.easy;

import java.util.Stack;

/**
 * Created by LQL on 2016/5/16.
 * 20Ã‚ £¨ ¿®∫≈∆•≈‰
 *
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        char[] schars = s.toCharArray();
        for (int i = 0; i < schars.length ;i++){
            if (schars[i] == '(' || schars[i] == '{' || schars[i] == '['){
                stack.push(schars[i]);
            }
            else{
                if (stack.isEmpty() == true){
                    return false;
                }else{
                    char left = stack.pop();
                    if (!match(left,schars[i])){
                        return false;
                    }
                }

            }

        }

        if (stack.size() > 0){
            return false;
        }
        return true;
    }

    public static boolean match(char left ,char right){
        if (left == '(' && right == ')'){
            return true;
        }
        else if (left == '[' && right == ']'){
            return true;
        }else if (left == '{' && right == '}'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

}
