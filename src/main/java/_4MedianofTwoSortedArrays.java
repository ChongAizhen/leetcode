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
        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6, 7, 8, 9};
        System.out.println(findMedianSortedArrays(A, B));
    }

    //使用了二分查找，这种时间复杂度为log(m+n)
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    //if (aMid < bMid) Keep [aRight + b]
    //else Keep [bRight + a]
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

    //时间复杂度为log(min(m,n))
    public double findMedianSortedArrays1(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (n > m)
            return findMedianSortedArrays(B, A);

        // now, do binary search
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (A[midA] < B[midB])
                l = midA + 1;
            else
                r = midA;
        }

        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 

        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // if (n+m) is even, the median can be calculated by 
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
}
