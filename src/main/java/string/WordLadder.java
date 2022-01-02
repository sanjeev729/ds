package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/*T:O(M*N^2)  m=length of all words in the list
	          n=length of dequeued word
	
	BFS is used for getting shorted path in graphs*/
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord))
			return 0;

		Queue<String> q = new LinkedList<String>();
		int level = 1;
		q.add(beginWord);
     
		while (!q.isEmpty()) {   //BFS call
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String current_word = q.poll();
				if (current_word.equals(endWord)) {
					return level;
				}
				char[] word = current_word.toCharArray();
				for (int j = 0; j < current_word.length(); j++) {  //O(N)
					char orig_char = word[j];
					for (char c = 'a'; c < 'z'; c++) {
						word[j] = c;
						String newStr = String.valueOf(word);  //O(N)  for each char we have to prepare new string ,it involves traversal internally 
						if (newStr.equals(endWord)) {
							return level + 1;
						}
						if (wordSet.contains(newStr)) {
							q.add(newStr);
							wordSet.remove(newStr);  // visited and sink ,serves the purpose of visited list
						}
					}
					word[j] = orig_char;
				}
			}
			level++;
		}
		return 0;
	}
    
    
    }
