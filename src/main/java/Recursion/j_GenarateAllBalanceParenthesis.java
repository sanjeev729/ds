package Recursion;

public class j_GenarateAllBalanceParenthesis {

	private static void genarateAllBalanceParenthesis(int n) {
		
		int open=n;
		int close=n;
		balanceParenthesis(open,close,"");
		
		}

	private static void balanceParenthesis(int open, int close, String output) {
		if (open == 0 && close == 0) {
			System.out.println(output);

		}
		
		if(open>0){
			String Output=output+"(";
			balanceParenthesis(open-1,close,Output);
		}
		if(close>open){
			String Output=output+")";
			balanceParenthesis(open,close-1,Output);
		}

	}

	public static void main(String[] args) {
        int n=4;
		genarateAllBalanceParenthesis(n);

	}

}
