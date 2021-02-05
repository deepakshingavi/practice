public class SortNos {

    public static float add(int i, float j){ return i+j;}

    public float add(float i, int j){ return i*j; }

    public static void main(String[] args) {

//        final List<Integer> integers = Arrays.asList(0, 1, 2);

//        int zeroIndex = 0;
//        int oneIndex = 0;
//        int twoIndex = 0;

//        int[] sampleArr = new int[]{0, 1, 2, 2, 1, 0, 0, 0, 2, 2, 1, 0, 2, 1, 0};
//        int[] sampleArr = new int[]{2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0};
//        int[] sampleArr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        int[] sampleArr = new int[]{0,0,0,0,2,0,0,0};

        for (int i = 0; i < (sampleArr.length - 1); i++) {

            if (sampleArr[i] > sampleArr[i + 1]) {
                int temp = sampleArr[i];
                sampleArr[i] = sampleArr[i + 1];
                sampleArr[i + 1] = temp;
                i = Math.max(-1,i - 2);
            }


            /*switch (sampleArr[i]) {
                case 0:
                    zeroIndex = i;
                    break;
                case 1:
                    oneIndex = i;
                    break;
                case 2:
                    twoIndex = i;
                    break;
            }

            while (zeroIndex > oneIndex || zeroIndex > twoIndex) {

                zeroIndex

            }*/

            /*if (zeroIndex > oneIndex && oneIndex != -1) {
                int temp = sampleArr[oneIndex];
                sampleArr[oneIndex] = sampleArr[zeroIndex];
                sampleArr[zeroIndex] = temp;
                oneIndex = 0;
            }
            if (zeroIndex > twoIndex && twoIndex != -1) {
                int temp = sampleArr[twoIndex];
                sampleArr[twoIndex] = sampleArr[zeroIndex];
                sampleArr[zeroIndex] = temp;
                twoIndex = 0;
            }
            if (oneIndex > twoIndex && twoIndex != -1) {
                int temp = sampleArr[oneIndex];
                sampleArr[oneIndex] = sampleArr[twoIndex];
                sampleArr[twoIndex] = temp;
                twoIndex = 0;
            }*/

        }

        for (int i = 0; i < sampleArr.length; i++) {
            System.out.print(sampleArr[i] + " ,");

        }

        /*
        int[] data = new int[3];
        for (int i:integers) {

            data[i]++;
        }*/

        /*for (int i:integers) {
            data[i]++;
        }

        for (int i = 0; i < data.length; i++) {
            for(int j=0 ; j < data[i];j++) {
                System.out.print(i);
                System.out.print(" ,");
            }
        }*/

    }
}
