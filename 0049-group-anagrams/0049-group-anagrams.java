class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for(String s : strs){
            char[] S = s.toCharArray();
            Arrays.sort(S);
            String sortS = new String(S);
            res.putIfAbsent(sortS, new ArrayList<>());
            res.get(sortS).add(s);
    }return new ArrayList<>(res.values());
    }
}