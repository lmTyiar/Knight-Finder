
import java.util.*;
class Chess extends Node{
    public Chess(int x, int y) {
        super(x, y);
    }

    private static int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
    private static int[] col = {1, -1, 1, -1, 2, -2, 2, -2};

    private static boolean onBoard(int x, int y, int Z){
        return(x >= 0 && x < Z) && (y >= 0 && y < Z);
    }

    public static int bfs(Node start, Node end, int Z) {
        ArrayList<Node> visited = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<>();   
        
        queue.add(start);

        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            if(cur.x == end.x && cur.y == end.y) {
                return cur.dist;
            }
            if(!visited.contains(cur)) {
                visited.add(cur);
                for(int i = 0; i < row.length; i++) {
                    int x = cur.x + row[i];
                    int y = cur.y + col[i];
                    if(onBoard(x,y,Z)) {
                        Node newNode = new Node (x,y, cur.dist + 1);
                        queue.add(newNode);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[]args) {
        int Z = 8;
        Node start = new Node(2,3,0);
        Node end = new Node (4,4);
        System.out.println(bfs(start,end, Z));
    }

}
