
package A_practice_method_chaining_1a;

public class A2_MtdChaining {
	
	public static A2_MtdChaining a() {
		System.out.println("Execute mtd a");
		return new A2_MtdChaining();
	}
	public static A2_MtdChaining b() {
		System.out.println("Execute mtd b");
		return new A2_MtdChaining();
	}
	public static B2_MtdChaining c() {
		System.out.println("Execute mtd c");
		return new B2_MtdChaining();
	}
}
