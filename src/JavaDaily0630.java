public class JavaDaily0630 {
    private static void testList(List list) {//List list,接口可以创建引用，不可以创建对象
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        list.insert(3, 5);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        testList(new ArrayList(10));
        System.out.println("=============");
        testList(new LinkedList());
    }
}
