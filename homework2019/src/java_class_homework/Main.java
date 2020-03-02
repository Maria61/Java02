package java_class_homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/20 19:01
 */
public class Main {

    public static String judgeZodiac(int year) {

        int start = 579;

        if (year <= start) {
            //据记载，南北朝时期十二生肖完全形成，设579年，十二生肖完全形成并扩展
            return "该年份十二生肖尚未完全定型";
        }
        String[] zodiac = {"子鼠", "丑牛", "寅虎", "卯兔", "辰龙", "巳蛇",
                "午马", "未羊", "申猴", "酉鸡", "戌狗", "亥猪"};
        int c = (year - start) % 12;
        if (c == 0) {
            return zodiac[11];
        }
        return zodiac[c - 1];
    }

    public static int[] statGender(Student[] s, String major) {
        int[] result = new int[2];//女生:0 , 男生:1
        for (Student student : s) {
            if (student.major.equals(major)) {
                if (student.gender.equals("男")) {
                    result[1] = result[1] + 1;
                } else {
                    result[0] = result[0] + 1;
                }
            }
        }
        return result;
    }

    public static Map<String, int[]> statistics(Student[] students) {
        Map<String, int[]> map = new HashMap<>();
        for (Student s : students) {
            if (map.containsKey(s.major)) {
                if (s.gender.equals("男")) {
                    map.get(s.major)[1] += 1;
                } else {
                    map.get(s.major)[0] += 1;
                }

            } else {
                int[] m = new int[2];
                map.put(s.major, m);
                if (s.gender.equals("男")) {
                    map.get(s.major)[1] += 1;
                } else {
                    map.get(s.major)[0] += 1;
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(judgeZodiac(2019));
        Student s1 = new Student("张三", "男", "计算机");
        Student s2 = new Student("李四", "男", "网络");
        Student s3 = new Student("王五", "男", "计算机");
        Student s4 = new Student("赵六", "女", "计算机");
        Student[] s = {s1, s2, s3, s4};
        System.out.println(Arrays.toString(statGender(s, "网络")));
        Map<String, int[]> counts = statistics(s);
        /**
         * 遍历重点看！！！
         */
        for (Map.Entry<String, int[]> m : counts.entrySet()) {
            String major = m.getKey();
            int[] g = m.getValue();
            System.out.println("专业:" + major + "," + Arrays.toString(g));
        }
    }
}
