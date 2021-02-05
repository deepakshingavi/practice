public class DiscreteCosineTransformation {
    public static void main(String[] args) {
//        transform();

        double[][] test = {
                {52, 55, 61, 66, 70, 61, 64, 73},
                {63, 59, 55, 90, 109, 85, 69, 72},
                {62, 59, 68, 113, 144, 104, 66, 73},
                {63, 58, 71, 122, 154, 106, 70, 69},
                {67, 61, 68, 104, 126, 88, 68, 70},
                {79, 65, 60, 70, 77, 68, 58, 75},
                {85, 71, 64, 59, 55, 61, 65, 83},
                {87, 79, 69, 68, 65, 76, 78, 94}
        };


        dctTransform(test);
    }

    public static void transform() {
        int u;
        int v;
        double alphau;
        double alphav;

        double[][] test = {
                {52, 55, 61, 66, 70, 61, 64, 73},
                {63, 59, 55, 90, 109, 85, 69, 72},
                {62, 59, 68, 113, 144, 104, 66, 73},
                {63, 58, 71, 122, 154, 106, 70, 69},
                {67, 61, 68, 104, 126, 88, 68, 70},
                {79, 65, 60, 70, 77, 68, 58, 75},
                {85, 71, 64, 59, 55, 61, 65, 83},
                {87, 79, 69, 68, 65, 76, 78, 94}
        };


        double[][] coefficients = new double[8][8];

        for(int x = 0; x < test.length; x++)
        {
            double summation = 0;
            for(int y = 0; y < test[x].length; y++)
            {
                //Inner discrete transform.
                u = x % 8;
                v = y % 8;

                double cosu = Math.cos(Math.toRadians((((2 * x) + 1) * u * Math.PI) / 16));
                double cosv = Math.cos(Math.toRadians((((2 * y) + 1) * v * Math.PI) / 16));

                summation = ((test[y][x]) * cosu * cosv) + summation;
                System.out.print(test[y][x] - 128 + ", ");
            }
            System.out.println("");
        }

        System.out.println("");


        for(int i = 0; i < 8; i++)
        {
            double summation = 0;
            for(int j = 0; j < 8; j++)
            {
                //Outer discrete transform.
                alphau = 1.0;
                alphav = 1.0;

                if(i == 0) {
                    alphav = 1 / Math.sqrt(2);
                }
                if(j == 0) {
                    alphau = 1 / Math.sqrt(2);
                }

                coefficients[i][j] = .25 * alphau * alphav * summation;

                System.out.print(coefficients[i][j] + ", ");
            }
            System.out.println("");
        }

    }

    public static int n = 8,m = 8;
    public static double pi = 3.142857;

    static void dctTransform(double matrix[][])
    {
        int i, j, k, l;

        // dct will store the discrete cosine transform
        double[][] dct = new double[m][n];

        double ci, cj, dct1, sum;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                // ci and cj depends on frequency as well as
                // number of row and columns of specified matrix
                if (i == 0)
                    ci = 1 / Math.sqrt(m);
                else
                    ci = Math.sqrt(2) / Math.sqrt(m);

                if (j == 0)
                    cj = 1 / Math.sqrt(n);
                else
                    cj = Math.sqrt(2) / Math.sqrt(n);

                // sum will temporarily store the sum of
                // cosine signals
                sum = 0;
                for (k = 0; k < m; k++)
                {
                    for (l = 0; l < n; l++)
                    {
                        dct1 = matrix[k][l] *
                                Math.cos((2 * k + 1) * i * pi / (2 * m)) *
                                Math.cos((2 * l + 1) * j * pi / (2 * n));
                        sum = sum + dct1;
                    }
                }
                dct[i][j] = ci * cj * sum;
            }
        }

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
                System.out.printf("%f\t", dct[i][j]);
            System.out.println();
        }
    }
}
