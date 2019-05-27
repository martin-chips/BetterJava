package com.dimple.effectiveJava.chapter3;

/**
 * @className: Item12
 * @description: 始终要覆盖toString
 * 虽然Object提供了ToString方法的实现，但它返回的类的名称以及一个@符号，接着是散列码的无符号十六进制表示法。例如PhoneNum@163b91.
 * 提供好的t。String 实现可以便类用起来更加舒适，使用了这个类的系统也更易于调试。当对象被传递给println、printf、字符串连操作符（+）以及assert，或者被调试器打印出来，toString方法自动被调用。
 * 在实际应用中，ToString方法应该返回对象中包含的所有值得关注的信息。
 * @auther: Dimple
 * @date: 05/27/19
 * @version: 1.0
 */
public class Item12 {
    public static void main(String[] args) {
        PhoneNum phoneNum = new PhoneNum("123", "456");
        System.out.println(phoneNum);
        System.out.printf("%s", phoneNum);
        System.out.println("" + phoneNum);

    }
}

class PhoneNum {
    private String prefix;
    private String suffix;

    public PhoneNum(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return prefix + suffix;
    }
}
