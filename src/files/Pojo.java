package files;

import java.util.List;

public class Pojo {
	private String id;
	NestedClass nestedClass;
	List<String> stringList;
	
	public Pojo(String id) {
		this.id = id;
	}
	public Pojo() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public NestedClass getNestedClass() {
		return nestedClass;
	}
	public void setNestedClass(NestedClass nestedClass) {
		this.nestedClass = nestedClass;
	}
	public List<String> getStringList() {
		return stringList;
	}
	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}
	
	//23473hj
	@Override
	public String toString() {
		return "Pojo [id=" + id + ", nestedClass=" + nestedClass + ", stringList=" + stringList + "]";
	}
	
	
	
	
}