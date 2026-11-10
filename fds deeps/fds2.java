/*### **Problem: Movie Theater Seat Arrangement**

You're managing a movie theater's seating system. 
After cancellations, some seats become empty (represented by 0). 
You need to move all empty seats to the end while keeping the order of occupied seats the same.

- **0** = Empty seat
- **Non-zero numbers** = Ticket numbers of occupied seats

**Move all empty seats (zeros) to the end while maintaining the relative order of occupied seats.**

---

### **Example 1:**
```
Input: seats = [12, 0, 5, 0, 3, 0, 8]
Output: [12, 5, 3, 8, 0, 0, 0]

Explanation:
Occupied seats: 12, 5, 3, 8 (order maintained)
Empty seats: 0, 0, 0 (moved to end)
```

---

### **Example 2:**
```
Input: seats = [0, 1, 0, 3, 12]
Output: [1, 3, 12, 0, 0]

Explanation:
Occupied seats stay in order: 1, 3, 12
Empty seats moved to end: 0, 0
```

---


---

### **Constraints:**
- 1 <= seats.length <= 10000
- 0 <= seats[i] <= 10000
- Must modify the array **in-place** (no extra array allowed)
- Maintain the relative order of non-zero elements

---

### **Your Task:**

Implement: `rearrange_seats(seats)` 

The function should modify the input array directly.

---
*/
// u made me yappy

/*import java.util.*;
class sol{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        int l=0,p=n-1;
        for(int i = 0;i<n;i++){
            int k = s.nextInt();
            if(k!=0){
                a[l] = k;
                l++;
            }
            else{
                a[p] = k;
                p--;
            }
            
        }
        System.out.println(Arrays.toString(a));
    }
}*/
//using two pointer approach
import java.util.*;
class fds2{
    public static void main(String arags[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        int i=0;
        // 1st zero
        while(i<n && arr[i]!=0){
            i++;
        }
        int j = i+1; // idi 1st declare cheayddu 
        while(j<n){
            if(arr[j]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;
                i++;
            }
            j++;
            System.out.print(Arrays.toString(arr));
        }
    }
}
/* idhi inko approach :
class Solution {
    public void moveZeroes(int[] nums) {
        // overwrite all non zeros 
        int k=0,i=0;
        while(i<nums.length){
            if(nums[i]!=0){
                nums[k++] = nums[i];
            }
            i++;
        }
        while(k<nums.length){
            nums[k++]=0;
        }
    }
}` */