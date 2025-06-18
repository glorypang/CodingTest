import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 열 이름 → 인덱스 매핑
        Map<String, Integer> keyIndex = new HashMap<>();
        keyIndex.put("code", 0);
        keyIndex.put("date", 1);
        keyIndex.put("maximum", 2);
        keyIndex.put("remain", 3);

        int extIdx = keyIndex.get(ext);
        int sortIdx = keyIndex.get(sort_by);

        // 조건에 맞는 데이터 필터링
        List<int[]> filtered = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filtered.add(row);
            }
        }

        // 정렬
        filtered.sort((a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));

        // List -> 2차원 배열 변환
        int[][] answer = new int[filtered.size()][];
        for (int i = 0; i < filtered.size(); i++) {
            answer[i] = filtered.get(i);
        }

        return answer;
    }
}
