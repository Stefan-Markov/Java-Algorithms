import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort_DFS {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nextLine = scan.nextLine();
            if (nextLine.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+")).map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(nextNodes);
            }
        }
        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected component: ");
            for (int integer : connectedComponent) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                components.add(new ArrayDeque<>());

                bfs(i, components, graph, visited);
            }
        }
        return components;
    }

    private static void bfs(int start, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();

        visited[start] = true;

        queue.push(start);

        while (!queue.isEmpty()) {

            int node = queue.pop();

            components.get(components.size() - 1).offer(node);

            for (int child : graph.get(node)) {
                if (!visited[child]) {

                    visited[child] = true;

                    queue.push(child);
                }
            }
        }
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            for (int child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }
            components.get(components.size() - 1).offer(node);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {

        List<String> sorted = new ArrayList<>();

        Set<String> visited = new HashSet<>();

        Set<String> detectCycles = new HashSet<>();


        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dfs(node.getKey(), visited, graph, sorted, detectCycles);
        }

        Collections.reverse(sorted);
        return sorted;
    }

    public static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted, Set<String> detectCycles) {
        if (detectCycles.contains(key)) {
            throw new IllegalArgumentException();
        }
        if (!visited.contains(key)) {
            visited.add(key);
            detectCycles.add(key);
            for (String child : graph.get(key)) {
                if (!visited.contains(child)) {
                    dfs(child, visited, graph, sorted, detectCycles);
                }
                detectCycles.remove(child);
                sorted.add(key);
            }
        }
    }

    public static class Graph {
        int source;
        List<Edge> edges;

        public Graph(int source) {
            this.source = source;
            this.edges = new ArrayList<>();
        }
    }

    public static class Edge {
        public int source;
        public int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
}
