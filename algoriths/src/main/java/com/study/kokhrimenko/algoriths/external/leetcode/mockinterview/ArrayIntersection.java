package com.study.kokhrimenko.algoriths.external.leetcode.mockinterview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayIntersection {

	public static void main(String[] args) {
		int[] arr1 = new int[] {3,1,2},
			arr2 = new int[] {1,1};
		
		ArrayIntersection executor = new ArrayIntersection();
		int[] result = executor.intersect(arr1, arr2);
		
		Arrays.stream(result).forEach(System.out::println);
	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length ==0 || nums2 == null || nums2.length ==0) {
			return new int[0];
		}
		List<Integer> secondArrAsASet = Arrays.stream(nums1.length > nums2.length ? nums1 : nums2).boxed().collect(Collectors.toList());
        return Arrays.stream(nums1.length > nums2.length ? nums2 : nums1)
        	.filter(x -> {
        		int index = secondArrAsASet.indexOf(x);
        		if(index > -1) {
        			secondArrAsASet.remove(index);
        			return true;
        		}
        		return false;
        	})
        	.toArray();
    }
	
}
