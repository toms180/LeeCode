package packageInstall;

import java.util.*;

public class Package_Install_Char_Arr_Input_DFS {
	
	  public static List<Vertex> pkgSchedule(char [][] pairs){
		  if(pairs == null || pairs.length == 0 || pairs[0].length == 0) {
			  return new ArrayList<Vertex>();
		  }
		  
		  Map<Character, Vertex> graph = new HashMap<>();
		  for(char[] c : pairs) {
			  char from = c[0];
			  char to = c[1];
			  graph.putIfAbsent(from, new Vertex(from));
			  graph.putIfAbsent(to, new Vertex(to));
			  graph.get(from).neighbors.add(graph.get(to));
		  }
		 
		  
		  List<Vertex> res = new LinkedList<>();
		  for(char ch : graph.keySet()) {
			  Vertex cur = graph.get(ch);
			  if(hasCycle(cur, res)) {
				  throw new RuntimeException("input is valid!");
			  }
		  } 
		  return res;
		  
	  }
	  private static boolean hasCycle(Vertex cur, List<Vertex> res){
		  if(cur.status == Status.visiting) {
			  return true;
		  }
		  if(cur.status == Status.visited) {
			  return false;
		  }
		  cur.status = Status.visiting;
		  for(Vertex next : cur.neighbors) {
			  if(hasCycle(next, res)) {
				  return true;
			  }
		  }
		  cur.status = Status.visited;
		  res.add(0, cur);
		  return false;
	  }
	  
	  
	
	
	

	public static void main(String[] args) {
		 
		  
		char[][] pairs = {
				{'A','B'},{'A','C'},{'B','D'},{'B','E'},{'B','F'},{'F','G'},{'C','F'}
		};
		
 
		List<Vertex> res = Package_Install_Char_Arr_Input_DFS.pkgSchedule(pairs);
		System.out.println(res);
	}

}


 
 
