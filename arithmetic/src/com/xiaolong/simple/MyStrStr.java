package com.xiaolong.simple;

/**
 * 28
 * 实现 strStr() 函数。
 *      给定一个 haystack 字符串和一个 needle 字符串，
 *      在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 *      输入: haystack = "hello", needle = "ll"
 *      输出: 2
 * 示例 2:
 *      输入: haystack = "aaaaa", needle = "bba"
 *      输出: -1
 */
public class MyStrStr {

    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(haystack.length()==0 ){
            return -1;
        }
        int hlen = haystack.length(), nlen = needle.length();
        for (int i=0; i<hlen - nlen; i++){
            if (haystack.substring(i, i+nlen).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyStrStr myStrStr = new MyStrStr();
        System.out.println(myStrStr.strStr("hello", "ll"));
    }
}
