public class XorOps {

    public static void main(String[] args) {
        System.out.println(getXor(5, 8));
    }

    static long getMod4(int a) {
        long[] res = {a, 1, a + 1, 0};
        return res[a % 4];
    }

    static long getXor(int a, int b) {
        return getMod4(b) ^ getMod4(a - 1);
    }
}
