import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int nRows = relation.length;
        int nCols = relation[0].length;

        List<Set<Integer>> candidateKeys = new ArrayList<>();

        // 1 ~ nCols 길이의 모든 조합을 검사
        for (int size = 1; size <= nCols; size++) {
            combination(nCols, size, 0, new LinkedHashSet<>(), relation, candidateKeys);
        }

        return candidateKeys.size();
    }

    // 조합 생성과 후보키 조건 체크를 동시에 수행
    private void combination(int nCols, int size, int start, Set<Integer> currentSet,
                             String[][] relation, List<Set<Integer>> candidateKeys) {
        if (currentSet.size() == size) {
            // 유일성 검사
            if (!isUnique(currentSet, relation)) return;

            // 최소성 검사
            for (Set<Integer> key : candidateKeys) {
                if (currentSet.containsAll(key)) {
                    return;
                }
            }

            // 조건 만족 → 후보키 등록
            candidateKeys.add(new HashSet<>(currentSet));
            return;
        }

        for (int i = start; i < nCols; i++) {
            currentSet.add(i);
            combination(nCols, size, i + 1, currentSet, relation, candidateKeys);
            currentSet.remove(i);
        }
    }

    // 현재 조합이 relation에서 유일성을 가지는지 확인
    private boolean isUnique(Set<Integer> cols, String[][] relation) {
        Set<String> seen = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder key = new StringBuilder();
            for (int col : cols) {
                key.append(row[col]).append(",");
            }
            if (!seen.add(key.toString())) {
                return false; // 중복 발견 → 유일성 실패
            }
        }

        return true;
    }
}
