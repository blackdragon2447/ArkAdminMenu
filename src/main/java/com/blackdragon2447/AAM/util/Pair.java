package com.blackdragon2447.AAM.util;

/**
 * this class is the object for a data pair, the values of T and U dont have to be the same
 * @author Blackdragon2447
 *
 * @param <T> the first type in the pair
 * @param <U> the second type in the pair
 */
public class Pair<T, U>{
	
	T p1;
	U p2;
	
	/**
	 * makes a new pair
	 * @param a the value to be set for the first field
	 * @param b the value to be set for the second field
	 */
	public Pair(T a, U b){
		this.p1 = a;
		this.p2 = b;
	}
	
	/**
	 * same as the constructor but for an exsitent pair.
	 * @param a the value to be set for the first field 
	 * @param b the value to be set for the second field
	 */
	public void setValue(T a, U b){
		this.p1 = a;
		this.p2 = b;
	}
	
	/**
	 * @return returns the pair.
	 */
	public Pair<T, U> getValue(){
		return this;
	}
	
	/**
	 * @return returns the first value of the pair
	 */
	public T getFirstValue() {
		return p1;
	}
	
	/**
	 * @return returns the second value of the pair
	 */
	public U getSecondValue() {
		return p2;
	}
	
	/**
	 * tries to make a csv vlaue of the pair
	 * @return returns the result of the pairs csv value
	 */
	public String GetcsvValue() {
		return p1.toString() + ", " + p2.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Pair<T, U> compObj = (Pair<T, U>) obj;
		return ((this.p1 == compObj.p1) && (this.p2 == compObj.p2));
	}

}
