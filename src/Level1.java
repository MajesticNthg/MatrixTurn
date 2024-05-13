public class Level1 {
    static int g = 0;
    static int inside = 0;

    public static void MatrixTurn(String Matrix[], int M, int N, int T) {
        int[][] newMatrix = new int[M][N];
        int f = 0;
        int min = 0;

        if (M >= N) {
            min = N;
        } else {
            min = M;
        }

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                char c = Matrix[x].charAt(y);
                int z = Character.getNumericValue(c);
                newMatrix[x][y] = z;
            }
        }

        for (int y = 0; y < T; y++) {
            inside = 0;
            for (int x = 0; x < min / 2; x++) {
                upTurn(newMatrix, M, N, g, f, inside);
                inside++;
            }
        }

        StringBuilder newString = new StringBuilder();
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                newString.append(newMatrix[x][y]);
            }
            Matrix[x] = newString.toString();
            newString.delete(0, N);
        }

    }

    public static void upTurn(int[][] newMatrix, int M, int N, int g, int f, int inside) {
        for (int x = inside; x < N - 1 - inside; x++) {
            if (x == inside) {
                f = newMatrix[inside][x + 1];
                newMatrix[inside][x + 1] = newMatrix[inside][x];
            } else {
                g = newMatrix[inside][x + 1];
                newMatrix[inside][x + 1] = f;
                f = g;
            }
        }
        rightTurn(newMatrix, M, N, g, f, inside);
    }

    public static void rightTurn(int[][] newMatrix, int M, int N, int g, int f, int inside) {
        for (int x = 1 + inside; x < M - 1 - inside; x++) {
            if (x == 1 + inside) {
                f = newMatrix[x][N - 1 - inside];
                newMatrix[x][N - 1 - inside] = g;
            } else {
                g = newMatrix[x][N - 1 - inside];
                newMatrix[x][N - 1 - inside] = f;
                f = g;
            }
        }
        downTurn(newMatrix, M, N, g, f, inside);
    }

    public static void downTurn(int[][] newMatrix, int M, int N, int g, int f, int inside) {
        for (int x = N - 1 - inside; x >= inside; x--) {
            if (x == N - 1 - inside) {
                f = newMatrix[M - 1 - inside][x];
                newMatrix[M - 1 - inside][x] = g;
            } else {
                g = newMatrix[M - 1 - inside][x];
                newMatrix[M - 1 - inside][x] = f;
                f = g;
            }
        }
        leftTurn(newMatrix, M, N, g, f, inside);
    }

    public static void leftTurn(int[][] newMatrix, int M, int N, int g, int f, int inside) {
        for (int x = M - 2 - inside; x >= inside; x--) {
            if (x == M - 2 - inside) {
                f = newMatrix[x][inside];
                newMatrix[x][inside] = g;
            } else {
                g = newMatrix[x][inside];
                newMatrix[x][inside] = f;
                f = g;
            }
        }
    }
}


