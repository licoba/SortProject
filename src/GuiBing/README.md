# 归并排序

#### 基本思想

> 先拆分，再合并：将数组拆分成两半，然后对拆分的两半递归进行拆分操作，直到每个子集只有一个元素；然后自底向上对每个子集进行有序合并，合并完成之后的数组就是一个排序好的数组。

```

    public void guibing_sort(int[] nums, int left, int right) {
        if (left == right)
            return;
        int mid = left + (right - left) / 2;
        guibing_sort(nums, left, mid);
        guibing_sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    // 将 nums[left..mid] 和 nums[mid+1..right] 这两个有序数组合并成一个有序数组
    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = Arrays.copyOf(nums, nums.length);// 辅助数组
        // 和链表一样，数组也进行双指针，i和j分别指向两个nums的头结点
        int i = left;
        int j = mid + 1;
        for (int p = left; p <= right; p++) {
            if (i == mid + 1) { // 左边已经合并完毕了
                nums[p] = temp[j++];
            } else if (j == right + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
```

#### 代码细节

细节主要在 merge 函数

- 注意边界问题，先判断左边或者右边是否合并完毕
- 需要先用 temp 函数将 nums 存起来，这样才能原地合并 nums 数组

#### 时间复杂度

二分法拆分分成的二叉树，层高为 log(n)，对于每两个节点，都需要遍历一遍，所以时间复杂度是 O(n\*log(n))

![](https://pic3.zhimg.com/v2-cdda3f11c6efbc01577f5c29a9066772_b.webp)

---

- 参考：https://labuladong.gitee.io/algo/2/20/38/
