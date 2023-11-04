public class HugeNumberDriver
{
   /**
   * Main method with some test code
   */
   public static void main(String[] args)
   {
	   // Create a HugeNumber that is 123456789
	   HugeNumber h1 = new HugeNumber();
	   for (int i=9; i>=1; i--)
	   {
		   h1.addDigit(i);
	   }
	   System.out.println("h1 is " + h1.toString());

	   // Create a HugeNumber that is 55555555558888888888
	   HugeNumber h2 = new HugeNumber();
	   for (int i=0; i<10; i++)
	   {
		   h2.addDigit(8);
	   }
	   for (int i=0; i<10; i++)
	   {
		   h2.addDigit(5);
	   }
	   System.out.println("h2 is " + h2.toString());

	   // Make a copy of h1
	   HugeNumber h3 = new HugeNumber(h1);
	   System.out.println("h3 is " + h3.toString());

	   // Reset h1
	   h1.resetValue();
	   // Change original source for h3
	   System.out.println("h1 after reset:" + h1.toString());
	   // Should remain unchanged
	   System.out.println("h3 after h1 reset:" + h3.toString());

	   // Add h3 to 987654321
	   HugeNumber h4 = new HugeNumber();
	   for (int i=1; i<=9; i++)
	   {
		   h4.addDigit(i);
	   }
	   System.out.println("h4 is " + h4.toString());
	   System.out.println("h3 is " + h3.toString());
	   System.out.println("h3 + h4 is " + h3.add(h4).toString());

	   // Add empty to h3
	   System.out.println("h1 + h3 is " + h3.add(h1).toString());

	   // Add h2 to h3
	   System.out.println("h2 + h3 is " + h3.add(h2).toString());
   }
} // HugeNumberDriver
