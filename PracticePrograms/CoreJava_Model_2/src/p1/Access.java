/**
 * 	Model-2 : Interface without Implementation Class_Name
 *           (Anonymous InnerClass as Implementation)
 */

package p1;

public class Access {
	
	public static ITest getRef()
	{
		ITest ob = new ITest()
		{
			public void m1(int x)
			{
				System.out.println("****Implemented m1(x)****");
				System.out.println("The value x:"+x);
			}
			
			public void m2(int y)
			{
				System.out.println("****Implemented m2(y)****");
				System.out.println("The value y: "+y);
			}
			
		};
		return ob;
	} //OuterClass static method
} //OuterClass
