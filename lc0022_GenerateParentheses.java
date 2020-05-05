package lc0022;

import java.util.*;
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<>();
	        if(n <= 0) {
	        	return res;
	        }
	        int delta = 0;
	        
	        dfs(res, new StringBuilder(), n, delta);//解說1
	        return res;
	}
	
	private void dfs(List<String> res, StringBuilder path, int n, int delta) {
		
		int len = path.length();
		//成功的路徑
		if(delta == 0 && len == 2*n ) {
			res.add(path.toString());
			return;
		}
		//失敗的路徑
		if(len == 2*n || delta < 0 ) {//解說2
			return;
		}
		
		path.append('(');// update current status;
		dfs(res, path, n, delta +1);
		path.setLength(len);//set back
		
		path.append(')');// update current status;
		dfs(res, path, n, delta - 1);
		path.setLength(len);//set back
		

	}

	public static void main(String[] args) {
		GenerateParentheses x = new GenerateParentheses();
		List<String> outcome = x.generateParenthesis(3);
		System.out.println(outcome);

	}
	

}
