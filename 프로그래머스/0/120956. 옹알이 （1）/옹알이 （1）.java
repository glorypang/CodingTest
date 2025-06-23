class Solution {
    static String[] baby = {"aya", "ye", "woo", "ma"};

    // 유효한 발음만으로 구성되었는지 확인
    public static boolean isValid(String target) {
        for (String word : baby) {
            // 해당 발음을 반복적으로 제거
            while (target.contains(word)) {
                target = target.replace(word, " ");
            }
        }
        System.out.println(target);
        target = target.replace(" ", "");
        // 다 제거되고 빈 문자열이면 true
        return target.equals("");
    }

    public int solution(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
        if (isValid(word)) {
                    answer++;
                }
            }
        return answer;
    }
}