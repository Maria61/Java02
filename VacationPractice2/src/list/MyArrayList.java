package list;

import java.util.Arrays;

public class MyArrayList implements List {
    int[] array = null;
    int size = 0;

    public void ensureCapcity(){
        if(array != null && size<array.length){
            return;
        }
        if(array == null){
            array = new int[1];
        }else{
            array = Arrays.copyOf(array,2*array.length);
        }


    }

    @Override
    public boolean add(int element) {

        return add(size,element);
    }

    @Override
    public boolean add(int index, int element) {
        //检查下标是否合法
        if(index<0 || index>size){
            System.out.println("下标不合法");
            return false;
        }
        //检查空间是否足够
        ensureCapcity();
        //将index之后的数据后移一位
        System.arraycopy(array,index,array,index+1,size-index);
        array[index] = element;
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        if(index<0||index>size){
            System.out.println("下标不合法");
            return -1;
        }
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        if(index<0||index>=size) {
            System.out.println("下标不合法");
            return -1;
        }
            array[index] = val;
            return 0;

    }

    @Override
    public int remove(int index) {
        System.arraycopy(array,index+1,array,index,size-index-1);
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
