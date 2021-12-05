package packageInstall;

import java.util.ArrayList;
import java.util.List;

public class Vertex{
	char id;
	List<Vertex> neighbors;
	Status status;
	public Vertex(char ch) {
		this.id = ch;
		this.neighbors = new ArrayList<>();
		this.status = Status.Initial;
	}
	@Override
	public String toString() {
		return String.valueOf(id);
	}

}