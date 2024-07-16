class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return [sum(x in nums2 for x in nums1), sum(x in nums1 for x in nums2)]
