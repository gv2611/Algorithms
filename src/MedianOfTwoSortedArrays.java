public class MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    int pointer1 = 0, pointer2 = 0;
    int iter = 0;
    int merged[] = new int[nums1.length + nums2.length];
    while (pointer1 < len1 && pointer2 < len2) {
      if (nums1[pointer1] <= nums2[pointer2]) {
        merged[iter++] = nums1[pointer1++];
      } else {
        merged[iter++] = nums2[pointer2++];
      }
    }
    while (pointer1 < len1) {
      merged[iter++] = nums1[pointer1++];
    }
    while (pointer2 < len2) {
      merged[iter++] = nums2[pointer2++];
    }
    int mergedLength = merged.length;
    if (mergedLength % 2 == 0) {
      return (double) (merged[mergedLength / 2] + merged[(mergedLength / 2) - 1]) / 2;
    }
    return (double) merged[mergedLength / 2];
  }

  public static void main(String[] args) {
    MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
    int nums1[] = {1, 2};
    int nums2[] = {3, 4};
    System.out.println(median.findMedianSortedArrays(nums1, nums2));
  }
}
