# LeetCode Solutions (Java)

This repository contains my daily practice solutions from [LeetCode](https://leetcode.com/problemset/), written in **Java**.  
Organized by topic for better readability and revision.

---

## Problems Solved

### 1. Search in Rotated Sorted Array
- **Problem Link:** [Search In Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- **Approach:** Modified **Binary Search** to handle rotation. At each step, determine whether the left half or right half is sorted, then decide which half to continue searching.
- **Complexity:**
    - **Time:** O(log n)
    - **Space:** O(1)
- **Notes:** Works only for arrays that are sorted and then rotated (e.g., `[5,6,1,2,3,4]`). For arrays with duplicates, a slight modification is needed (LeetCode 81).
