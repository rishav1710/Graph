import java.util.*;
class Graph{
    int vertices;
    LinkedList<Integer>[] list;
    
    Graph( int  v){
        this.vertices=v;
        list=new LinkedList[v];
        for(int i=0;i<vertices;i++)
        list[i]=new LinkedList<Integer>();
    }
    public boolean dfsUtil(int source,int destination,boolean[] vis){
        if(source==destination) return true;
        
        for(int a:list[source]){
            
            if(!vis[a]){
                vis[a]=true;
                boolean isConnected=dfsUtil(a,destination,vis);
                if(isConnected) return true;
            }
            
        }
        return false;
    }
    public boolean dfs(int source,int destination){
        boolean[] vis=new boolean[vertices];
        vis[source]=true;
        return dfsUtil(source,destination,vis);
    }
    public int bfs(int source,int destination){
        boolean[] vis=new boolean[vertices];
        int[] parent=new int[vertices];
        
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(source);
        parent[source]=-1;
        vis[source]=true;
        
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            if(curr==destination)
            break;
            
            for(int a:list[curr]){
                
                if(!vis[a]){
                    vis[a]=true;
                queue.add(a);
                
                parent[a]=curr;
                
                }
                
            }
            
        }
        
        int curr=destination;
        int distance=0;
        
        while(parent[curr]!=-1){
            System.out.print(curr+"->");
            curr=parent[curr];
            distance++;
        }
        System.out.print(source);
        System.out.println();
        return distance;
    }
    
    public void addEdge(int source,int destination){
        list[source].add(destination);
        list[destination].add(source);
    }
}
