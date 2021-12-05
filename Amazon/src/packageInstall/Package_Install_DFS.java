package packageInstall;

import java.util.*;

public class Package_Install_DFS {
	
	  public static List<Package> pkgSchedule(List<Package> pkgs){
		  if(pkgs == null || pkgs.size() == 0) {
			  return new ArrayList<Package>();
		  }
		  // 0 : initial , 1 : visiting , 2 : visited
		  HashMap<Package, Integer> status = new HashMap<>();
		  for(Package p : pkgs) {
			  status.put(p, 0);
		  }
		  List<Package> res = new LinkedList<>();
		  for(Package p : pkgs) {
			  if(hasCycle(p, res, status)) {
				  throw new RuntimeException("input is valid");
			  }
		  }
		  return res;
		  
	  }
	  private static boolean hasCycle(Package cur, List<Package> res, HashMap<Package, Integer> status){
		  if(status.get(cur) == 1) {
			  return true;
		  }
		  if(status.get(cur) == 2) {
			  return false;
		  }
		  status.put(cur, 1);
		  for(Package next : cur.neighbors) {
			  if(hasCycle(next, res, status)) {
				  return true;
			  }
		  }
		  status.put(cur, 2);
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
		List<Package> res = Package_Install_DFS.pkgSchedule(pkgs);
		System.out.println(res);
	}

}
 