/**
 * 	Model-2 : Interface without Implementation Class_Name
 *           (Anonymous InnerClass as Implementation)
 */

package p2;
import p1.*;

public class DemoModel2 {

	public static void main(String[] args) {
		
		ITest ob = Access.getRef(); //Creating and Accessing Implementation object
		
		ob.m1(11);
		ob.m2(12);
		
	}

}


/* OUTPUT

****Implemented m1(x)****
The value x:11
****Implemented m2(y)****
The value y: 12

*/