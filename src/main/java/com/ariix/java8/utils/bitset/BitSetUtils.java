package com.ariix.java8.utils.bitset;

import java.util.BitSet;

public class BitSetUtils {
	public static void main(String[] args) {
		BitSet bitSet = new BitSet(100);
		bitSet.set(0, 50, true);
		System.out.println(bitSet.cardinality());
	}
}
