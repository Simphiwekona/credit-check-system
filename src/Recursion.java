public class Recursion {

    public static int sum(int start, int end){
        if (end > start){
            return end + sum(start, end -1);
        }else {
            return end;
        }
    }
}
