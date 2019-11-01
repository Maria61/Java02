public class StringBuilderTest{
	public static void main(String[] args){
		StringBuilder s1=new StringBuilder("abcdfghjklkasf");
		String s2=s1.toString();
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s1.length());
		int i=s1.length();
		s1.insert(1,'.');//在末尾插入‘.’;
		System.out.println(s1.toString());
//		System.out.println(s1==s2);//类型不同不可比较
		System.out.println(s1.equals(s2));//false,因为s1是StringBuilder类的对象，
										//equals()传入的对象也应该是StringBuilder类型的
	}
}
