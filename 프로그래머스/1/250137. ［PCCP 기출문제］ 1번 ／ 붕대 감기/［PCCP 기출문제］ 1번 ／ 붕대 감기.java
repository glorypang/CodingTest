class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = 0;
        int max = health;
        int count = 0;
        for(int i = 0 ; i < attacks.length; i++){
            while(true){
                if(time == attacks[i][0]){
                    health -= attacks[i][1];
                    count = 0;
                    if(health <= 0){
                        return -1;
                    }
                    System.out.println(time +" "+health+" "+ count );
                    time++;
                    break;
                    
                }
                if(max > health){
                    health += bandage[1];
                    count++;
                    if(count%bandage[0] == 0){
                        health += bandage[2];
                        count = 0;
                        if(health > max){
                            health = max;
                        }
                    }
                    if(health > max){
                        health = max;
                    }
                }
                System.out.println(time +" "+health+" "+ count );
                time++;
            }
        }
        if(health <= 0){
            return -1;
        }
        else{
            return health;
        }
    }
}