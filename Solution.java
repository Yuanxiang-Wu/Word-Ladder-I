package com.company; /**
 * Created by yuanxiangwu on 2/4/17.
 */
import java.lang.*;
import java.util.*;

public class Solution {
    Solution(){ }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }

        wordList.add(endWord);
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        hash.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (getNextWord(word, wordList).isEmpty()) {
                    continue;
                }
                for (String nextWord : getNextWord(word, wordList)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private ArrayList<String> getNextWord(String word, Set<String> wordList) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, i, c);
                if (wordList.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }

    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
