package datastructure;
import java.util.*;
public class TreeModule<T> {
	private T data;
	private TreeModule<T> parent;
	private List<TreeModule<T>> children;
	
	public TreeModule(T data) {
		this.data = data;
		this.children = new LinkedList<TreeModule<T>>();
	}
	public TreeModule<T> addChild(T child){
		TreeModule<T> childNode = new TreeModule<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
		return childNode;
	}
	public void addChildren(List<TreeModule<T>> children) {
		children.forEach(each->each.setParent(this));
		children.addAll(children);
	}
	public List<TreeModule<T>> getChildren(){
		return children;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	private void setParent(TreeModule<T> parent) {
		this.parent = parent;
	}
	public TreeModule<T> getParent(){
		return parent;
	}
	public TreeModule<T> getRoot(){
		if(parent ==null) {
			return this;
		}
		return parent.getRoot();
	}
	public void deleteNode() {
		if(parent != null) {
			int index = this.parent.getChildren().indexOf(this); // 이 노드의 위치를 찾음
			this.parent.getChildren().remove(this); // 지움
			for(TreeModule<T> each : getChildren()) { //하위 노드를 부모랑 이어줌
				each.setParent(this.parent);
			}
			this.parent.getChildren().addAll(index, this.getChildren()); // 부모에 하위 노드들을 추가함
		}
		else {
			deleteRootNode();
		}
		this.getChildren().clear(); // 이어준 후 자기꺼는 비워준다.
	}
	public TreeModule<T> deleteRootNode(){
		if(parent != null) {
			throw new IllegalStateException("deleteRootNode not called on root");
		}
		TreeModule<T> newParent = null;
		
		if(!getChildren().isEmpty()) {
		    newParent = getChildren().get(0);
		    newParent.setParent(null);
		    getChildren().remove(0);
		    for(TreeModule<T> each : getChildren()) {
		    	each.setParent(newParent);
		    }
		    newParent.getChildren().addAll(getChildren());
		}
		this.getChildren().clear();
		return newParent;
	}
}
