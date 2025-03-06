/**
 * Model-1 : Interface with Implementation class with name.
 */

package p2;
import p1.*;

public class DemoModel1 {

	public static void main(String[] args) {
		
		IClass ob = new IClass();	//Implementation Object
		
		ob.m1(11);
		ob.m2(23);
		
	}
}


/* OUTPUT

****Implement m1(x)
The value x: 11
****Implemented m2(y)
The value y:23

*/