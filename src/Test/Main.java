package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main{
	public static void main(String[] args){
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(4);

		System.out.println(treeSet);
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		treeSet.addAll(arr);
		System.out.println(treeSet);
	}
}
