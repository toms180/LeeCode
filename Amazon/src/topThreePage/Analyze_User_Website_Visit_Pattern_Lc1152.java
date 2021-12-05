package topThreePage;


import java.util.*;

public class Analyze_User_Website_Visit_Pattern_Lc1152 {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    	if(username == null || username.length == 0 || timestamp == null || timestamp.length == 0 || website == null || website.length == 0) {
        	return new ArrayList<>();
        }
        List<Cell> cells = new ArrayList<>();
        
        for(int i = 0 ; i < username.length; i++) {
        	cells.add(new Cell(username[i],timestamp[i],website[i]));
        }
        Collections.sort(cells, (o1,o2) -> o1.timestamp - o2.timestamp);
        Map<String, List<String>> map = new HashMap<>(); // key:username, 　value : List<String> -> website
        for(Cell c : cells) {// mapping the relation between username and website
        	map.putIfAbsent(c.username, new ArrayList<>());
        	map.get(c.username).add(c.website);
        }
	    List<HashSet<String>> allCombo = new ArrayList<>();
	    
	    for(String name : map.keySet()) {
	    	List<String> sequence = map.get(name);
	    	find3websites(sequence, allCombo);
	    }
	    String threeWebSite = null;
	    Map<String, Integer> countMap = new HashMap<>();
	    int max = 0;
	    for(HashSet<String> combo : allCombo) {
	    	for(String str : combo) {
	    		countMap.putIfAbsent(str, 0);
	    		countMap.put(str, countMap.get(str) + 1);
	    		if(countMap.get(str) > max) {// count的次數比max大更新 threeWebSite
	    			threeWebSite = str;  
    				max = Math.max(max, countMap.get(str));
    			}else if(countMap.get(str) ==  max){
    				if(str.compareTo(threeWebSite) < 0) {// count的次數等於max大且字母序比現在的 threeWebSite小更新 threeWebSite
    					threeWebSite = str;
    				}
    			}
	    	}
	    }
	    String [] temp = threeWebSite.split(",");
	    List<String> res = Arrays.asList(temp);
	    return res;
    }
    private void find3websites(List<String> sequence, List<HashSet<String>> allCombo) {
    	HashSet<String> set = new HashSet<>();
    	for(int i = 0 ; i < sequence.size()-2; i++) {
    		for(int j = i + 1; j < sequence.size()-1; j++) {
    			for(int k = j + 1;k < sequence.size(); k++) {
    				StringBuilder sb = new StringBuilder();
    				sb.append(sequence.get(i) + ",");
    				sb.append(sequence.get(j) + ",");
    				sb.append(sequence.get(k));
    				set.add(sb.toString());
    			}
    		}
    	}
    	allCombo.add(set);
    }
    
    
    
    

	public static void main(String[] args) {
		Analyze_User_Website_Visit_Pattern_Lc1152 x = new Analyze_User_Website_Visit_Pattern_Lc1152();
		String [] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
		int [] timestamp = {1,2,3,4,5,6,7,8,9,10};
		String []  website = {"home","about","career","home","cart","maps","home","home","about","career"};
		System.out.println(x.mostVisitedPattern(username, timestamp, website));

	}

}
class Cell{
	String username;
	int timestamp;
	String website;
	public Cell(String username, int timestamp, String website) {
		this.username = username;
		this.timestamp = timestamp;
		this.website = website;
	}
	
}
