
public class Main {

	static String str;
	static String myString;
	static boolean b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		try {
		b=str.length()>0;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}
System.out.println(b);

	}
}
