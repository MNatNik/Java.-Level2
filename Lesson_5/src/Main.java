public class Main {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String s[]) {
        Main arrCalc = new Main();
        arrCalc.runCalculate();
        arrCalc.runCalculateTwoThreads();
    }
    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runCalculate() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - a));
    }

    public void runCalculateTwoThreads() {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread(() -> {
            System.arraycopy(calculate(arr1), 0, arr1, 0, h);
        }).start();

        new Thread(() -> {
            System.arraycopy(calculate(arr2), 0, arr2, 0, h);
        }).start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Время выполнения второго метода (вычисление в двух потоках): " + (System.currentTimeMillis() - a));
    }
}
