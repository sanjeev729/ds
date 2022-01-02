package trym;
class A extends Exception{}
class B extends A{}
class C extends B{}
public class TryIg {
	class Sec{
		void go(){
			System.out.println(x+""+y+""+x1+""+x2);
		}
	}
	private int x =2;
	protected int y =3;
	private static int x1 =4;
	protected static  int x2 =5;
	
	public static void main(String[] args) {
		try{
			throw new B();
		}catch(A e0){
			System.out.println("A");
		}
         catch(Exception e1){
        	 System.out.println("E");
         }
	}

}
