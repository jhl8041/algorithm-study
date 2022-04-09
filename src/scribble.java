import java.math.BigInteger;
import java.util.*;

public class scribble {

    public static void main(String[] args){
//        twoSum(new int[] {3,2,4}, 6);
//        validTree(5, new int[][] {{0,1},{0,2},{0,3},{1,4}});
        int[][] sampleArray = new int[][] {{3,6}, {1,8}, {6,4}, {4,9}}; // [[1,2],[2,3],[4,6],[5,7]]
        bfsHasPath(5, new int[][] {{0,2},{0,3},{1,4}}, 4, 3);
        trapRain(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        Set<int[]> visited = new HashSet<>();
        visited.add(new int[] {1,2});
        System.out.println(visited.contains(new int[] {1,2}));
    }



    private static int trapRain(int[] height){
        if (height.length == 0){
            return 0;
        }

        int leftPos = 0;
        int rightPos = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalTrappedRain = 0;

        while (leftPos < rightPos){
            if (height[leftPos] > leftMax){
                leftMax = height[leftPos];
            }
            if (height[rightPos] > rightMax){
                rightMax = height[rightPos];
            }

            if (leftMax < rightMax){
                totalTrappedRain += Math.max(0, leftMax - height[leftPos]);
                leftPos++;
            } else {
                totalTrappedRain += Math.max(0, rightMax - height[rightPos]);
                rightPos--;
            }
        }
        return totalTrappedRain;
    }

    private static boolean bfsHasPath(int n, int[][] edges, int src, int dst){
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i=0; i< n ; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(src, -1);

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node);

            for (int neighbour : adjacencyList.get(node)){

                if (parent.get(node) == neighbour){
                    continue;
                }

                if (dst == neighbour){
                    return true;
                }

                queue.add(neighbour);
                parent.put(neighbour, node);
            }
        }
        return false;
    }


    private static boolean dfsHasPath(int n, int[][] edges, int src, int dst){
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i<n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(src, -1);

        while (!stack.isEmpty()){
            int node = stack.pop();

            for (int neighbour : adjacencyList.get(node)){
                if (parent.get(node) == neighbour){
                    continue;
                }

                if (neighbour == dst){
                    return true;
                }

                stack.push(neighbour);
                parent.put(neighbour, node);
            }
        }

        return false;
    }

    private static int[] twoSum(int[] nums, int target){
        int[] answer = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i){
                answer[0] = numMap.get(complement);
                answer[1] = i;
                return answer;
            }
        }

        for (int ans : answer){
            System.out.println(ans);
        }

        return answer;
    }

    private static boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        System.out.println(adjacencyList);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0,-1);

        while (!stack.isEmpty()){
            int node = stack.pop();
            System.out.println(node);

            for (int neighbour : adjacencyList.get(node)) {
                if (parent.get(node) == neighbour){
                    continue;
                }

                if (parent.containsKey(neighbour)){
                    return false;
                }

                stack.push(neighbour);
                parent.put(neighbour, node);
            }
        }

        return parent.size() == n;
    }
}
