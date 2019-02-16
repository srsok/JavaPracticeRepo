package datastructure;
import java.util.*;
import java.util.stream.Collectors;


public class GraphModule {
	class Node{
		int data;
		boolean visited;
		List<Node> neighbours;
		
		Node(int data){
			this.data = data;
			this.neighbours = new ArrayList();
		}
		public void addneighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}
		public List<Node> getNeighbours(){
			return neighbours;
		}
		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
		public void setVisited(boolean visited) {
			this.visited = visited;
		}
	}
	
	public void dfs(Node node) {
		System.out.print(node.data + " ");
		List<Node> neighbours = node.getNeighbours();
		node.visited = true;
		for(int i=0; i<neighbours.size(); i++) {
			Node n = neighbours.get(i);
			if(n!=null && !n.visited) {
				dfs(n);
			}
		}
	}
	public void dfsUsingStack(Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		node.visited  = true;
		while(!stack.isEmpty()) {
			Node element = stack.pop();
			System.out.print(element.data + " ");
			
			List<Node> neighbours  = element.getNeighbours();
			for(int i=0; i<neighbours.size(); i++) {
				Node n = neighbours.get(i);
				if(n !=null && !n.visited) {
					stack.add(n);
					n.visited = true;
					
				}
			}
		}
	}
	public void breadthFirstSearch(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		node.visited = true;
		while(!queue.isEmpty()) {
			Node element = queue.poll();
			System.out.print(element.data+" ");
			List<Node> neighbours  = element.getNeighbours();
			for(int i=0; i<neighbours.size(); i++) {
				Node n = neighbours.get(i);
				if(n !=null && !n.visited) {
					queue.add(n);
					n.visited = true;
				}
			}

		}
	}
	public void test() {
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		
		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);
		System.out.println("The DFS traversal of the graph using stack");
		dfsUsingStack(node40);
		
		node40.setVisited(false);
		node10.setVisited(false);
		node20.setVisited(false);
		node30.setVisited(false);
		node60.setVisited(false);;
		node50.setVisited(false);
		node70.setVisited(false);
		
		System.out.println("\nThe DFS traversal of the graph using recursion");
		dfs(node40);
		
		node40.setVisited(false);
		node10.setVisited(false);
		node20.setVisited(false);
		node30.setVisited(false);
		node60.setVisited(false);;
		node50.setVisited(false);
		node70.setVisited(false);
		
		System.out.println("\nThe BFS traversal of the graph using queue");
		breadthFirstSearch(node40);
	}
}
