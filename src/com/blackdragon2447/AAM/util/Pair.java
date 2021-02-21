package com.blackdragon2447.AAM.util;

public class Pair<T, U>{
	
	public Pair(T a, U b){
		this.p1 = a;
		this.p2 = b;
	}
	
	T p1;
	U p2;
	public void setValue(T a, U b){
		this.p1 = a;
		this.p2 = b;
	}
	
	public Pair<T, U> getValue(){
		return this;
	}
	
	public T getFirstValue() {
		return p1;
	}
	public U getSecondValue() {
		return p2;
	}
	
	public String GetcsvValue() {
		return p1.toString() + ", " + p2.toString();
	}

}
