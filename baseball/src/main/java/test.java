public class test {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0 ; i <=100; i++) {
            int sum = 0;
            sum = sum + i;
            if (sum % 3 == 0) {
                count++;
                System.out.println(sum);
                System.out.println(count);
            }
        }
    }
}
