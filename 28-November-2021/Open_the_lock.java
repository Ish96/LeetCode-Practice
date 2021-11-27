class Solution {
    public int openLock(String[] deadends, String target) {
        //HashSet for deadends
        HashSet<String> deadend = new HashSet<>(Arrays.asList(deadends));
        
        //For visiting number combinations
        HashSet<String> visited = new HashSet<>();
        
        //Queue for bfs
        Queue<String> queue = new LinkedList<>();
        
        //Initial Value
        queue.add("0000");
        int moves = 0;
        
        //Checking queue for empty
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                String currentPosition = queue.poll();
                
                //If currentPositon in deadend or visited size-- and continue
                if(deadend.contains(currentPosition) || visited.contains(currentPosition)){
                    size--;
                    continue;
                }
                
                //Visited the currentPosition
                visited.add(currentPosition);
                
                //If currentPosition = target
                if(currentPosition.equals(target)){
                    return moves;
                }
                
                
                //Checking combination for ie. 0000
                StringBuilder sb = new StringBuilder(currentPosition);
                
                //Because of 4 wheels
                for(int i=0; i<4; i++){
                    char wheelPosition = sb.charAt(i);
                    //Chekcing all 8 combinations that can possible
                    String s1 = sb.substring(0,i) + (wheelPosition == '9' ? 0 : wheelPosition - '0' + 1) + sb.substring(i+1);
                    String s2 = sb.substring(0,i) + (wheelPosition == '0' ? 9 : wheelPosition - '0' - 1) + sb.substring(i+1);
                    //System.out.println("S1: " + s1 + " S2:" + s2);

                    if(!visited.contains(s1) && !deadend.contains(s1)){
                        queue.add(s1);
                    }

                    if(!visited.contains(s2) && !deadend.contains(s2)){
                        queue.add(s2);
                    }
                }
                size--;
            }
            moves++;
        }
        
        
        return -1;
    }
}