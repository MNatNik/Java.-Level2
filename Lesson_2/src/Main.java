public class Main {

    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; // Матрица без Exception
        //String str = "10 3 1\n2 3 2 2\n5 6 7 1\n300 3 1 0"; // Exception: Размер матрицы, полученной из строки, не равен 4x4
        //String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\nfail 3 1 0"; // NumberFormatException: В одной из ячеек полученной матрицы не число, а слово
        //String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\nf 3 1 0"; // NumberFormatException: В одной из ячеек полученной матрицы не число, а символ

        calculateMatrix(convertStrToArray(str));

    }

    static  String[][] convertStrToArray(String str) {
        String tmpStr = str + "\n";
        for (int i = 0, spaceBetween = 0; i < tmpStr.length(); i++) {
            if (tmpStr.charAt(i) == ' ') spaceBetween++;
            if (tmpStr.charAt(i) == '\n') {
                if (spaceBetween == 3) spaceBetween = 0;
                else throw new Exception("Размер матрицы, полученной из строки, не равен 4x4");
            }
        }
        int length = str.split("\n").length;
        String[][] result = new String[length][length];
        String[] clearN = str.split("\n");

        for (int i = 0; i < length; i++) {
            String[] clearSpaces = clearN[i].split(" ");
            for (int j = 0; j < length; j++) {
                result[i][j] = clearSpaces[j];
            }
        }
        return result;
    }

    static void calculateMatrix(String[][] a){
        int x = a.length;
        double sum = 0;
        System.out.print("\nПечать матрицы:\n");
        for (int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                try {
                    System.out.print(a[i][j] + " ");
                    sum += Integer.parseInt(a[i][j]);
                } catch (NumberFormatException e) {
                    if (a[i][j].length() == 1) {
                        System.out.println("\nB одной из ячеек полученной матрицы не число, а символ " + a[i][j]);
                        e.printStackTrace();
                        System.exit(1);
                    }
                    if (a[i][j].length() > 1) {
                        System.out.println("\nB одной из ячеек полученной матрицы не число, а слово " + a[i][j]);
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            } System.out.println();
        }
        System.out.println("\nСумма всех элементов матрицы равна: "+sum);
        System.out.println("Сумма всех элементов матрицы, деленная на 2 равна: "+ (sum / 2));
    }

    private static class Exception extends RuntimeException {
        private String message;
        public Exception(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
