# 🔍 Jump Search — Complete Guide (A → Z)

![Algorithm](https://img.shields.io/badge/Algorithm-Jump_Search-blue)
![Time Complexity](https://img.shields.io/badge/Time-O\(√n\)-green)
![Space Complexity](https://img.shields.io/badge/Space-O\(1\)-orange)
![Language](https://img.shields.io/badge/Language-Java-red)

---

## 📌 1. What is Jump Search?

Jump Search is a searching algorithm used on **sorted arrays**.

Instead of checking elements one by one (like Linear Search),
it **jumps ahead in blocks** and then performs a **linear search inside that block**.

---

## 🧠 2. Intuition

Think like this:

* You are searching in a book 📖
* You don’t read every page ❌
* You jump a few pages ✔️
* Then search inside that section

👉 Same logic applies here

---

## 💡 3. How It Works

1. Choose step size = √n
2. Jump in blocks
3. Find the correct block
4. Perform linear search inside it

---

## 📊 4. Example

Array:

```
[1, 3, 5, 7, 9, 11, 13, 15]
```

Target = `11`
Step size = √8 ≈ 2

Jumping:

```
1 → 5 → 9 → 13
```

Now:
👉 11 lies between 9 and 13

Then:
👉 Linear search → FOUND

---

## ⚙️ 5. Algorithm

1. step = √n
2. prev = 0
3. While arr[min(step, n) - 1] < target
   → move forward
4. Do linear search from prev to step

---

## 🔥 6. Java Implementation

```java
class JumpSearch {

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;

        int step = (int) Math.sqrt(n);
        int prev = 0;

        // Jumping phase
        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);

            if (prev >= n)
                return -1;
        }

        // Linear search phase
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 11;

        System.out.println(jumpSearch(arr, target)); // Output: 5
    }
}
```

---

## 🧠 7. Core Logic Breakdown

### ✅ Case 1: Element smaller than target

```
arr[step] < target → keep jumping
```

### ✅ Case 2: Element greater than target

```
arr[step] >= target → stop jumping → linear search
```

### ✅ Case 3: Element found

```
Found during linear search
```

---

## ⚠️ 8. Edge Cases

* Empty array
* Single element
* Target not present
* Target is first element
* Target is last element
* Duplicate elements
* Large input size

---

## 🧪 9. Test Cases

### Normal Cases

```
arr = [1,3,5,7,9], target = 5 → 2
arr = [2,4,6,8], target = 8 → 3
```

### Edge Cases

```
arr = [], target = 5 → -1
arr = [10], target = 10 → 0
arr = [1,2,3], target = 10 → -1
```

---

## ⏱️ 10. Time Complexity

```
Jumps = √n
Linear Search = √n

Total = O(√n)
```

---

## 📦 11. Space Complexity

```
O(1)
```

---

## ⚖️ 12. Comparison

| Algorithm     | Time Complexity |
| ------------- | --------------- |
| Linear Search | O(n)            |
| Jump Search   | O(√n)           |
| Binary Search | O(log n)        |

---

## 🚀 13. When to Use?

✔ Sorted array
✔ Faster than linear search needed
✔ Simpler alternative to binary search

---

## 🌍 14. Real-Life Use Cases

* Searching in large sorted logs
* File systems
* Database indexing
* Step-based searching systems

---

## 🧾 15. Quick Revision

```
Jump Search:
- Sorted array required
- Step = √n
- Jump + Linear Search

Time = O(√n)
Space = O(1)
```

---

## 🎯 16. Key Takeaways

* Faster than Linear Search
* Simpler than Binary Search
* Uses block jumping
* Good for interview basics

---

## ⭐ If this helped you

Give a ⭐ to your repo and keep learning 🚀
