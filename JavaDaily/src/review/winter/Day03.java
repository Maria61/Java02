package review.winter;

import java.util.HashMap;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/4/9 14:36
 */
public class Day03 {
    /**
     * 救赎金
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> ransomNoteMap = new HashMap<>();
        HashMap<Character,Integer> magazineMap = new HashMap<>();
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for(int i = 0; i < ran.length; i++){
            ransomNoteMap.put(ran[i],ransomNoteMap.getOrDefault(ran[i],0)+1);
        }
        for(int i = 0; i < mag.length; i++){
            magazineMap.put(mag[i],magazineMap.getOrDefault(mag[i],0)+1);
        }
        for(Character c : ransomNoteMap.keySet()){
            if(!magazineMap.containsKey(c) || magazineMap.get(c) < ransomNoteMap.get(c)){
                return false;
            }
        }

        return true;
    }

    /**
     * 判断回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int p = x;
        int re = 0;
        while(p != 0){
            re = re * 10 + p % 10;
            p /= 10;
        }
         if(x != re){
             return false;
         }else{
             return true;
         }
    }
    public static void main(String[] args) {
//        canConstruct("aasddffds","aaasssdddfffds");
        System.out.println(isPalindrome(1210));
    }
}
