# SortProject
> 排序算法项目，包括快速排序、冒泡排序、归并排序

## 快速排序

#### 基本思想
- 先选取一个中心轴，然后进行一趟排序，把比中心轴小的数都放在左边，比中心轴大的数都放在右边。然后对中心轴左边、右边的子序列递归进行相同的操作，直到每个子序列的长度都为1，那么此时就是排序完成的数组。

```
    public void quick_sort(int[] numbers, int left, int right) {
        if(left<right) {
            int base = left; //base一般取数组的第一个元素
            int i = left, j = right;
            while (i < j) {
                while (i < j && numbers[j] >= numbers[base]) j--; //内层循环的 i<j 不能省略
                while (i < j && numbers[i] <= numbers[base]) i++; //因为最后做的是i++，所以应该以i为判断基准
                swap(numbers, i, j);
            }
            swap(numbers, base, i);//交换base和i（或者j）
            quick_sort(numbers, left, i - 1);
            quick_sort(numbers, i + 1, right);
        }
    }
```
#### 代码细节
- `left < right` 为先决条件
- 先移动`j`，再移动`i`

#### 时间复杂度
冒泡是不稳定的排序算法
- 最好的情况是，每次都取中间值，所以二叉树的深度为 log(n)，所以时间复杂度为O(n*log(n))
- 最坏的情况是，也就是每次都取到了最大或者最小值，每次都有一半是空的，二叉树的深度为O(n)，所以时间复杂度为O(n²)

## 冒泡排序
#### 基本思想
在一趟排序里面，比较相邻的两个元素，如果比当前的大，那么就交换他们两个，每趟排序都能找到一个最大的元素
```
    public void maopaoSort(int nums[]){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
```

#### 代码细节
- 注意j的取值，应该以i作为参考，减去i的值
- 每次比较的是 `j` 和`j+1`，也就是相邻的两个元素

#### 时间复杂度
冒泡排序是稳定的排序算法，因为需要遍历O(n)遍，每遍都需要O(n-1)的时间，综合起来就是 O(n²)
