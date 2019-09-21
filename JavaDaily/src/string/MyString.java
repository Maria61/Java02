package string;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/21 9:04
 */

import java.util.Arrays;

/**
 * 1.不可变对象
 * 不允许继承；内部属性只能被初始化，不能修改；返回String的方法操作，都需要返回新的对象
 * 2.仿造常量池的概念，实现intern方法
 */
public final class MyString implements Comparable<MyString> {

    private final char[] value;

    public MyString(char[] c) {
        value = Arrays.copyOf(c, c.length);
    }

    public MyString(char value[], int offset, int count) {
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    public MyString(MyString s) {
        this.value = s.value;
    }

    @Override
    public boolean equals(Object s) {

        if (s == this) {
            return true;
        }

        if (this == null) {
            return false;
        }

        if (!(s instanceof MyString)) {
            return false;
        }

        return Arrays.equals(value, ((MyString) s).value);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (char c : value) {
            hash = (hash ^ c);
        }
        return hash;
    }

    public MyString toUpper() {
        char[] newValue = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            if (newValue[i] >= 'a' && newValue[i] <= 'z') {
                newValue[i] = (char) (newValue[i] - 'a' + 'A');
            }
        }
        return new MyString(newValue);
    }

    public MyString upLower() {
        char[] newValue = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            if (newValue[i] >= 'A' && newValue[i] <= 'Z') {
                newValue[i] = (char) (newValue[i] - 'A' + 'a');
            }
        }
        return new MyString(newValue);

    }

    public char charAt(int index) {
        return value[index];
    }

    public char[] toCharArray() {
        return Arrays.copyOf(value, value.length);
    }

    @Override
    public int compareTo(MyString o) {
        if (o == null) {
            return 1;
        }
        int length = Math.max(value.length, o.value.length);
        for (int i = 0; i < length; i++) {
            if (value[i] - o.value[i] > 0) {
                return 1;
            } else if (value[i] - o.value[i] < 0) {
                return -1;
            }
        }
        if (value.length > o.value.length) {
            return 1;
        } else if (value.length < o.value.length) {
            return -1;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return new String(value);
    }

    public boolean equalsIgnoreCase(MyString s) {
        if (s == null) {
            return false;
        }
        if (value.length != s.value.length) {
            return false;
        }

        for (int i = 0; i < value.length; i++) {
            int a = value[i];
            int b = s.value[i];
            if (a == b) {
                continue;
            }
            if (a >= 'a' && a <= 'z') {
                a += ('A' - 'a');
                if (a == b) {
                    continue;
                }
            }
            if (a >= 'A' && a <= 'Z') {
                a += ('a' - 'A');
                if (a == b) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public MyString substring(int begin, int end) {
        char[] newValue = Arrays.copyOfRange(value, begin, end);
        return new MyString(newValue);
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        MyString s = new MyString(a);

    }
}
