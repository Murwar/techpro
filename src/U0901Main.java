
public class U0901Main {
    public static void main(String[] args) throws Exception {
        Integer intArr[] = { 10, 20, 15 };
        Float floatArr[] = new Float[10];
        for (int i = 0; i < floatArr.length; i++) {
            floatArr[i] = (float) Math.random() * 100;
        }
        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<>(floatArr);
        System.out.println("sum of floatArr = " + insWorkArrayFloat.sum());
        System.out.println("sum of intArr = " + insWorkArrayInt.sum());
        
        // try {
        //     String strArr[] = { "purr", "pur", "pu", "p" };
        //     Integer strIntArr[] = new Integer[strArr.length];
        //     for (int i = 0; i < strArr.length; i++) {
        //         strIntArr[i] = Integer.valueOf(strArr[i]);
        //     }
        //     U0901WorkArray<Integer> insWorkArrayStr = new U0901WorkArray<>(strIntArr);
        //     System.out.println("sum of strArr = " + insWorkArrayStr.sum());
        // } catch (Exception e) {
        //     System.out.println(e);
        // }

    }
}