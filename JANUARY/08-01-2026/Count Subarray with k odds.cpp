#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int countSubarrays(vector<int>& arr, int k) {
        unordered_map<int, int> countMap;
        countMap[0] = 1;
        int prefixSum = 0;
        int result = 0;
        for (int num : arr) {
            if (num % 2 != 0) 
                prefixSum += 1;
            if (countMap.find(prefixSum - k) != countMap.end()) {
                result += countMap[prefixSum - k];
            }
            countMap[prefixSum]++;
        }
        return result;
    }
};