package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearch {
	//O(ROW x COL)
	//word search 1
	public  boolean wordSearch(char[][] grid,String str) {
		
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == str.charAt(0) && dfs(grid, visited, str, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean dfs(char[][] grid, boolean[][] visited, String str, int i, int j, int count) {

		if (count == str.length()) {
			return true;
		}

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != str.charAt(count)) {
			return false;
		}

		/*
		 * char temp=grid[i][j]; grid[i][j]=''; // setting to dummy value so
		 * that it should not n=be consider again
		 */

		visited[i][j] = true; // visit and sink the island
		
		boolean found = dfs(grid, visited, str, i + 1, j, count + 1) // right
				|| dfs(grid, visited, str, i - 1, j, count + 1) // left
				|| dfs(grid, visited, str, i, j + 1, count + 1) // below
				|| dfs(grid, visited, str, i, j - 1, count + 1);// above

		// grid[i][j]=temp; //setting back the same value
		
		visited[i][j] = false;

		return found;

	}
	
	
	
    public class TrieNode{
        public boolean isWord = false;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){
            
        }
    }
    
    TrieNode root = new TrieNode();
    boolean[][] flag;
    
    
    //Word search 2
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];
        
        addToTrie(words);
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){
                    dfs(board, i, j, root, "", result);
                }
            }
        }
        
        return new LinkedList<>(result);
    }
    
    private void addToTrie(String[] words){
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, String word, Set<String> result){
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]|| node.child[board[i][j] - 'a'] == null){
            return;
        }
        
        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if(node.isWord){
            result.add(word + board[i][j]);
        }
        
        dfs(board, i-1, j, node, word + board[i][j], result);
        dfs(board, i+1, j, node, word + board[i][j], result);
        dfs(board, i, j-1, node, word + board[i][j], result);
        dfs(board, i, j+1, node, word + board[i][j], result);
        
        flag[i][j] = false;
    }
}
