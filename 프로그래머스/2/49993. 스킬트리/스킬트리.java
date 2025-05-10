import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        char[] cArr = skill.toCharArray();
        for(int i =0 ; i < skill_trees.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int j =0  ; j< skill.length(); j++){
                char c = cArr[j];
                if(skill_trees[i].contains(String.valueOf(c))){
                    list.add(skill_trees[i].indexOf(c));
                    //System.out.println(skill_trees[i].indexOf(c));
                }
                else{
                    list.add(skill_trees[i].indexOf(-1));
                }
            }
            for(int n : list){
                //System.out.println(n);
            }
            for(int k = 0 ; k < list.size()-1; k++){
                if(list.get(k) == -1 && list.get(k+1) >=0){
                    answer--;

                    //System.out.println("come 1");
                    break;
                }
                
                if(list.get(k) > list.get(k+1) && list.get(k+1) != -1) {
                    
                                        //System.out.println(list.get(k) +" come 2");

                    answer--;
                    break;
                }
            }
           // System.out.println();
            
        }
        return answer;
    }
}