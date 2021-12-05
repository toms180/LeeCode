package packageInstall;

import java.util.*;

public class Package_Install_NO_HashMap_DFS {
	
	  public static List<Package> pkgSchedule(List<Package> pkgs){
		  if(pkgs == null || pkgs.size() == 0) {
			  
			  return new ArrayList<Package>();
		  }
		  List<Package> res = new LinkedList<>();
		  for(Package p : pkgs) {
			  if(hasCycle(p, res)) {
				  throw new RuntimeException("input is valid");
			  }
		  }
		  return res;
		  
	  }
	  private static boolean hasCycle(Package cur, List<Package> res){
		  if(cur.status == Status.visiting) {
			  return true;
		  }
		  if(cur.status == Status.visited) {
			  return false;
		  }
		  cur.status = Status.visiting;
		  for(Package next : cur.neighbors) {
			  if(hasCycle(next, res)) {
				  return true;
			  }
		  }
		  cur.status = Status.visited;
		  res.add(0, cur);
		  return false;
	  }

	public static void main(String[] args) {
		 
		                   //  0   1   2   3   4   5   6 
		String [] pkgsName = {"A","B","C","D","E","F","G"};
		List<Package> pkgs = new ArrayList<>();
		for(String str : pkgsName) {
			pkgs.add(new Package(str));
		}
		pkgs.get(0).neighbors.add(pkgs.get(1)); // A -> B
		pkgs.get(0).neighbors.add(pkgs.get(2)); // A- > C
		pkgs.get(1).neighbors.add(pkgs.get(3)); // B -> D
		pkgs.get(1).neighbors.add(pkgs.get(4)); // B -> E
		pkgs.get(1).neighbors.add(pkgs.get(5)); // B -> F
		pkgs.get(5).neighbors.add(pkgs.get(6)); // F -> G
		pkgs.get(2).neighbors.add(pkgs.get(5)); // C -> F
		List<Package> res = Package_Install_NO_HashMap_DFS.pkgSchedule(pkgs);
		System.out.println(res);
	}

}
 
 
