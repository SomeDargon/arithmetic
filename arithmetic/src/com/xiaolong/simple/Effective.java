package com.xiaolong.simple;

/**
 * 
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
