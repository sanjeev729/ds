package dp;
public class LongestPalindomicSubsequence
{ 
	int lps(char[] X) {
		int n=X.length;
		return LongestCommonSubsequence.lcs(n, n,X, reverse(X));
	}
	
void lpsPrint(char[] X) {
		int n=X.length;
		LongestCommonSubsequence.lcsPrint(n, n,X, reverse(X));
	}
	
	static char[] reverse(char arr[]){
		char[] t=new char[arr.length];
		int i=arr.length-1;
		while(i>=0){
			t[arr.length-1-i]=arr[i];
			i--;
		}
		
		return t;
	}
	
	
 
  public static void main(String[] args)
	{
		LongestPalindomicSubsequence scs = new LongestPalindomicSubsequence();
		String s1 = "agbcba";

		char[] X = s1.toCharArray();

		System.out.println("Length of LPS is" + " " + scs.lps(X));
		scs.lpsPrint(X);

	}
 
}