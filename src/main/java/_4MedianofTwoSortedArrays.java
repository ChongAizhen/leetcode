/*
There are two sorted arrays（有序数组） nums1 and nums2 of size m and n respectively（分别，个别）.

Find the median（中位数） of the two sorted arrays. The overall（整体的） run time complexity（运行时间复杂度） should be O(log (m+n))。

中位数的定义为：
对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。如果观察值有偶数个，通常取最中间的两个数值的平均数作为中位数

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0


Example 2:
nums1 = [1, 3]
nums2 = [2, 4]

The median is (2 + 3)/2 = 2.5
*/
public class _4MedianofTwoSortedArrays {

    public static void main(String[] args){
        int[] A = {1, 3};
        int[] B = {2, 4};
        System.out.println(findMedianSortedArrays(A, B));
    }

    //使用了二分查找，这种时间复杂度为log(m+n)
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {

        if (aStart > A.length - 1)
            return B[bStart + k - 1];
        if (bStart > B.length - 1)
            return A[aStart + k - 1];

        //A和B各有一个元素 (1+1+1)/2=1
        if (k == 1)
            return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;

        if (aStart + k/2 - 1 < A.length)
            aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length)
            bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart, k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }

}
