class SubSets{

    public static void findSubsets(
        String ans,
        String str,
        int i
    ){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        findSubsets(ans+str.charAt(i), str, i+1);
        findSubsets(ans, str, i+1);
    }

    public static void main(String[] args) {
        findSubsets("", "abc", 0);
    }
}