public class prim {
    public static void main(String[] args) {
        int num = 2564;
        System.out.println(hasDupes(num));


    }
    public static boolean hasDupes(int num){
        boolean[] digs = new boolean[10];
        while(num > 0){
            if(digs[num%10]) return true;
            digs[num%10] = true;
            num/= 10;
        }
        return false;
    }
}
