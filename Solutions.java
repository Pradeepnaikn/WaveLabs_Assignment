package com.firstRound;

import java.util.Arrays;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)
            return -1;
        
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
        
        for(int i = 0; i< connections.length; i++){
            union(parent, rank, connections[i][0], connections[i][1]);
        }
        
        int countOfUnconnectedComputers =0;
        for(int i = 0; i< parent.length; i++){
            if(parent[i] == i)
                countOfUnconnectedComputers++;
            
        } 
        countOfUnconnectedComputers--; // since one root will be there
        
        return countOfUnconnectedComputers;
        
        
    }
    
    private void union(int[] parent, int[] rank, int x, int y){
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        
        if(parentX==parentY)
            return;
        
        if(rank[parentX] > rank[parentY]){
            parent[parentY] = parent[parentX];
        }else if(rank[parentX] < rank[parentY]){
             parent[parentX] = parent[parentY];
        }else{
            parent[parentY] = parent[parentX];
            rank[parentX]++;
        }
        
        return;

    }
    
    private int find(int[] parent, int x){
        if(parent[x] ==x)
            return x;
        
        return parent[x] = find(parent, parent[x]);
    }
  //  Input 1:  n=6  connections =[[0,1],[0,2],[0,3],[1,2]]  Output=-1
  //  Input 2: n= 4  connections =[[0,1],[0,2],[1,2]]   Output=1



        
    
}
