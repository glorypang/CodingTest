import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int correct = 0;
        for(String str : words){
            if(str.equals(target))
                  correct++;
        }
        if(correct == 0) return 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.add(begin);

        visited[0] = true;
        int depth = 0;
        
        while (!q.isEmpty()) {
            int size = q.size(); // 현재 층의 노드 수

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(target)) {
                    return depth;
                }

                for (String next : words) {
                    if (isOneLetterDifferent(word, next)) {
                        q.add(next);
                    }
                }
            }
            depth++; // 층이 끝났으니 depth 증가
        }

        
        return 0;
    }
    public boolean isOneLetterDifferent(String a, String b) {
    if (a.length() != b.length()) return false;

    int diffCount = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
            diffCount++;
        }
        if (diffCount > 1) {
            return false;
        }
    }
    return diffCount == 1;
}

}