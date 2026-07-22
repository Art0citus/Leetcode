class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
    'I', 1,
    'V', 5,
    'X', 10,
    'L', 50,
    'C', 100,
    'D', 500,
    'M', 1000
);

int sum = 0;
for (int i = 0; i < s.length() - 1; i++) {
    int current = map.get(s.charAt(i));
    int next = map.get(s.charAt(i + 1));
if (current < next) {
    sum = sum - current;
} else {
    sum = sum + current;
    
}

}
sum += map.get(s.charAt(s.length() - 1));
return sum;
    }
}
 
