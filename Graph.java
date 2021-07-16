
import java.util.ArrayList;

public class Main {

    public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v){

        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public static void addEdge2(int [][] adjMatrix, int u, int v){

       adjMatrix[u][v] = 1;
       adjMatrix[v][u] = 1;
    }
    public static void main(String[] args) {

        int vCount = 7;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(vCount);

        for(int i = 0; i < vCount; i++)
            adjList.add(new ArrayList<Integer>());

        addEdge(adjList, 0,2);
        addEdge(adjList, 0,1);
        addEdge(adjList, 1,2);
        addEdge(adjList, 2,3);
        addEdge(adjList, 2,4);
        addEdge(adjList, 3,5);
        addEdge(adjList, 4,5);
        addEdge(adjList, 5,6);
        addEdge(adjList, 6,7);
        addEdge(adjList, 5,8);

    }
}