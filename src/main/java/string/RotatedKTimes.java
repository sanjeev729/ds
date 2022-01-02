package string;

public class RotatedKTimes {

	public static boolean isRotated(String str1, String str2, int k) {

		String clockwise = str1.substring(str1.length() - k-1) + 
				           str1.substring(0, str1.length() - k-1);

		String antiClockwise = str1.substring(0, k) +
				               str1.substring(k);

		return clockwise.equals(str2) || antiClockwise.equals(str2);

		// Your code here

	}

	public static void main(String[] args) {
		String str1 = "amazon";
        String str2 = "azonam";
      
        System.out.println(isRotated(str1, str2,3) ?  "Yes"
                              : "No");

	}

}
