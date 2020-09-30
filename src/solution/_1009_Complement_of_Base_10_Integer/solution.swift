class Solution {
    func bitwiseComplement(_ N: Int) -> Int {
        if(N==0){
          return 1
        }
        var n = N
        var cp = 0
        var i = 1
        while n>0 {
          if n%2==0 {
            cp+=i
          }
          i*=2
          n/=2
        }
        return cp
    }
}

print(Solution().bitwiseComplement(5))
print(Solution().bitwiseComplement(10))
