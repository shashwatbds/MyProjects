# -*- coding: utf-8 -*-
"""FindMedianOfSortedArrays.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1ZIf6ouy223BPTOjbPeksBp88o7L7rrGH

**Median of Two Sorted Arrays**:
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n))

**Example 1:**
1.   **Input**: nums1 = [1,3], nums2 = [2]
2.   **Output**: 2.00000
3.   **Explanation**: merged array = [1,2,3] and median is 2.

**Example 2:**
1.   **Input**: nums1 = [1,2], nums2 = [3,4]
2.   **Output**: 2.50000
3.   **Explanation**: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


**Constraints**:
1.   nums1.length == m
2.   nums2.length == n
3.   0 <= m <= 1000
4.   0 <= n <= 1000
5.   1 <= m + n <= 2000
6.   -106 <= nums1[i], nums2[i] <= 106
"""

def findMedianSortedArrays(array):
  if len(array) <2000 and all((x < 106 and -106 < x) for x in array):
    return findMedian(sorted(array))

def findMedian(nums1):
  size = len(nums1)
  print(f'Size of merged array is {size}')
  print(f'{size%2}')
  if size%2 != 0:
    mid = size//2
    median = nums1[mid]
  else:
    mid = size/2
    print(int(mid))
    median = (nums1[int(mid)-1] + nums1[int(mid)])/2
  return median

nums1 = [1,3,5]
nums2 = [2,4,6]
print(findMedianSortedArrays(nums1 + nums2))

nums1 = [1,3]
nums2 = [2]
print(findMedianSortedArrays(nums1 + nums2))

nums1 = [1,3,4,5,6,7,8]
nums2 = [2,9]
print(findMedianSortedArrays(nums1 + nums2))