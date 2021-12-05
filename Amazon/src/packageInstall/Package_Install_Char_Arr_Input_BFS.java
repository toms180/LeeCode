package packageInstall;

import java.util.*;

public class Package_Install_Char_Arr_Input_BFS {
	
	  public static List<Vertex> pkgSchedule(char [][] pairs){
		  if(pairs == null || pairs.length == 0 || pairs[0].length == 0) {
			  return new ArrayList<Vertex>();
		  }
		 
		  Map<Character, Vertex> graph = new HashMap<>();
		  Map<Vertex, Integer> indegree = new HashMap<>();
		  for(char[] c : pairs) {
			  char from = c[0];
			  char to = c[1];
			  
			 
			  
			  graph.putIfAbsent(from, new Vertex(from));
			  graph.putIfAbsent(to, new Vertex(to));
			  graph.get(from).neighbors.add(graph.get(to));
			  
			  Vertex start = graph.get(from);
			  Vertex end = graph.get(to);
			  
			  indegree.putIfAbsent(start, 0);
			  indegree.putIfAbsent(end, 0);
			  indegree.put(end, indegree.get(end) + 1);
		  }
		  
		  
		  int totalPkgNum = graph.size();
	 
		  int count = 0;
		  List<Vertex> res = new ArrayList<>();
		  Queue<Vertex> que = new LinkedList<>();
		  
		  
		  for(Vertex p : indegree.keySet()) {
			 
			  if(indegree.get(p) == 0) {
				  
				  res.add(p);
				  count++;
				  que.offer(p);
			  }
		  }
		  while(!que.isEmpty()) {
			  Vertex cur = que.poll();
			  for(Vertex next : cur.neighbors) {
				  int curIndegree = indegree.get(next);
				  curIndegree -= 1;
				  indegree.put(next, curIndegree);
				  if(curIndegree == 0) {
					  res.add(next);
					  count++;
					  que.offer(next);
				  }
			  }
		  }
		  
		  return totalPkgNum == count ? res : new ArrayList<Vertex>();
		  
		  
	  }
	  
	public static void main(String[] args) {
		 
		  
		char[][] pairs = {
				{'A','B'},{'A','C'},{'B','D'},{'B','E'},{'B','F'},{'F','G'},{'C','F'}
		};
		
 
		List<Vertex> res =  Package_Install_Char_Arr_Input_BFS.pkgSchedule(pairs);
		System.out.println(res);
	}

}

 