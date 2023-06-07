package spring.proxy;

public class CalculatorStaticProxy implements Calculator{

    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    public int add(int i, int j) {
        System.out.println("日志，方法：add,参数：" + i + "," + j);
        int result = target.add(i, j);
        System.out.println("日志，方法：add,结果：" + result);
        return result;
    }

    public int sub(int i, int j) {
        return 0;
    }

    public int mul(int i, int j) {
        return 0;
    }

    public int div(int i, int j) {
        return 0;
    }
}
