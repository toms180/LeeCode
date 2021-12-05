package topThreePage;

import java.util.*;


public class TopTreeSequence {
	 public List<String> top3Sequence(List<Log> entries) {
		 if(entries == null || entries.size() == 0) {
			 return new ArrayList<>();
		 }
		 List<String> res = new ArrayList<>();
		 Collections.sort(entries, (o1,o2) -> o1.timeStamp - o2.timeStamp);
		 Map<String, List<String>> map = new HashMap<>();  
		 for(Log log : entries) {
			 map.putIfAbsent(log.customerId, new ArrayList<>());
			 map.get(log.customerId).add(log.page);
		 } 
		 List<HashSet<String>> setList = new ArrayList<>();
		 for(String key : map.keySet()) {
			 List<String> sequence = map.get(key);
			 findtop3seq(setList, sequence);
		 }
		 int max = 0;
		 Map<String, Integer> countMap = new HashMap<>();
		 for(HashSet<String> ThreePages : setList) {
			 for(String pages : ThreePages) {
				 countMap.putIfAbsent(pages, 0);
				 countMap.put(pages, countMap.get(pages)+1);
				 if(countMap.get(pages) >= max) {
					 if(countMap.get(pages) > max) {
						 res.removeAll(res);
						 max = Math.max(countMap.get(pages), max);
					 }
					 res.add(pages);
				 }
			 }
		 }
		 return res;
	
	 }
	 
	 private void findtop3seq(List<HashSet<String>> setList, List<String> sequence) {
		 HashSet<String> set = new HashSet<>();
		 for(int i = 0; i < sequence.size() - 2; i++) {
			 for(int j = i + 1; j < sequence.size() - 1; j++) {
				 for(int k = j + 1; k < sequence.size(); k++) {
					 StringBuilder sb = new StringBuilder();
					 sb.append(sequence.get(i)+","); 
					 sb.append(sequence.get(j)+",");
					 sb.append(sequence.get(k)); 
					 set.add(sb.toString());
				 }
			 }
		 }
		 setList.add(set);
	 }
	 public static void main(String[] args) {
		 TopTreeSequence x = new TopTreeSequence();
		 Log [] a = {new Log("Toms",1,"A"), new Log("Toms",2,"B"), new Log("Toms",3,"C"), new Log("Toms",4,"D"), new Log("Toms",5,"E")};
		 Log [] b = {new Log("John",1,"E"), new Log("John",2,"B"), new Log("John",3,"C"), new Log("John",4,"D"), new Log("John",5,"A")};
		 List<Log>entries = new ArrayList<>();
		 for(int i = 0; i < a.length; i++) {
			 entries.add(a[i]);
			 entries.add(b[i]);
		 }
		 
		 System.out.println(x.top3Sequence(entries));
	 }

	  
}  

class Log {

    public String customerId;
    public int timeStamp;
    public String page;

    public Log(String customerId, int timeStamp, String page) {
        this.customerId = customerId;
        this.timeStamp = timeStamp;
        this.page = page;
    }
}
