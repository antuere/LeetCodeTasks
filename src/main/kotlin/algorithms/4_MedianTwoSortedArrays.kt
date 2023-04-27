package algorithms


fun main() {

}

//fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
//    val totalSize = nums1.size + nums2.size
//    val mergedArray = ArrayList<Int>()
//    var cache1 = nums1.last()
//    var cache2 = nums2.last()
//
//    for(i in 0 until Math.min(nums1.size, nums2.size)){
//
//        if(nums1[i] > cache2){
//            mergedArray[i] = cache2
//            cache1 = nums1[i]
//            continue
//        }
//
//        if(nums2[i] > cache1){
//            mergedArray[i] = cache1
//            cache2 = nums2[i]
//            continue
//        }
//
//        if(nums1[i] < nums2[i]){
//            mergedArray[i] = nums1[i]
//            cache2 = nums2[i]
//        } else {
//            mergedArray[i] = nums2[i]
//            cache1 = nums1[i]
//        }
//    }
//}