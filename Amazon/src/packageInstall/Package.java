package packageInstall;

import java.util.ArrayList;
import java.util.List;

public class Package {
	     
		String id;
		List<Package> neighbors;
		Status status; 
		 
		
		public Package(String id) {
			this.id = id;
			this.neighbors = new ArrayList<>();
			this.status = Status.Initial; 
			
		}
		 
		@Override
		public int hashCode() {
			return id.hashCode();
		}
		
		@Override
		public boolean equals (Object o) {
			if(o == null) {
				return false;
			}
			if(o instanceof Package) {
				Package that =  (Package) o;
				return this.id.equals(that.id);
			}else {
				return false;
			}
		}
		@Override 
		public String toString() {
			return this.id;
		}
	 
}
