package packageInstall;

import java.util.*;

import packageInstall.Package;

public class Package_Install_BFS {
	public static List<Package> pkgSchedule(List<Package> pkgs){
		if(pkgs == null || pkgs.size() == 0) {
			  return new ArrayList<Package>();
		}
		int count = 0;
		int len = pkgs.size();
		Map<Package, Integer> indegree = new HashMap<>();
		for(Package cur : pkgs) {
			indegree.putIfAbsent(cur, 0);
			for(Package next : cur.neighbors) {
				indegree.putIfAbsent(next, 0);
				indegree.put(next, indegree.get(next)+1);
			}
		}
		
		
		Queue<Package> que = new LinkedList<>();
		List<Package> res = new ArrayList<>();
		for(Package p : indegree.keySet()) {
			if(indegree.get(p) == 0) {
				
				que.add(p);
				res.add(p);
				count++;
			}
		}
		while(!que.isEmpty()) {
			Package cur = que.poll();
			for(Package next : cur.neighbors) {
				int curDegree = indegree.get(next);
				curDegree -= 1;
				indegree.put(next, curDegree);
				if(curDegree == 0) {
					que.offer(next);
					res.add(next);
					count++;
				}
			}
		}
		for(Package p : indegree.keySet()) {
			System.out.println(p.id +", " + indegree.get(p));
		}
		return count == len ? res : new ArrayList<Package>();
		 
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
	
		List<Package> res = Package_Install_BFS.pkgSchedule(pkgs);
		System.out.println(res);
		 
		 
	}

}
