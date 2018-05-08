package com.xiaolong.simple;

/**
 *  有效的括号
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *  有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *      注意空字符串可被认为是有效字符串。
 *      示例 1:
 *          输入: "()"
 *          输出: true
 */
public class Effective  {
    
    public boolean isValid(String s) {
       char[] chars = s.toCharArray(), schars = new char[s.length()];
       int top = 0, len = s.length();
       for (int i=0; i<len; i++){
            if(chars[i]=='('){
                schars[top++]=')';
            }else if(chars[i]=='{'){
                schars[top++]='}';
            }else if(chars[i]=='['){
                schars[top++]=']';
            }else if(0==top||schars[--top]!=chars[i]){
                return false;
            }
       }
       return top==0;
    }

    public static void main(String[] args) {
        Effective main = new Effective();
        System.out.println(main.isValid("()"));
    }
}
