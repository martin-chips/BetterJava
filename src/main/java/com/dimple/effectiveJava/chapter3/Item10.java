package com.dimple.effectiveJava.chapter3;

import java.util.Objects;

/**
 * @className: Item10
 * @description: 覆盖equals时遵守的通用约定
 * 如果不覆盖equals方法，那么这种情况下，类的每个实例都只与他本身相等，如果满足以下条件，这就是期望的结果：
 * 1. 类的每个实例本质上都是唯一的。
 * 2. 类没有必要提供“逻辑相等”logical equality 的测试功能。
 * 3. 父类已经覆盖了equals，父类的行为对于子类也是适合的。
 * 4. 类是私有的、或者是包级私有的，可以确保equals方法永远不会被调用。
 * 应该覆盖equals方法的条件：
 * 1. 类具有自身特有的逻辑相等（logical equality）的概念。
 * 2. 父类没有覆盖equals
 * 覆盖equals需要遵守的条件
 * 1. 自反性（reflexive）：对于任何非null的引用值X，X.equals(x)需要为true。
 * 2. 对称性（symmetric）： 对于任何非null的引用值x，y，x.equals(y)==y.equals(x)
 * 3. 传递性（transitive）：对于任何非null得引用值x,y,x.equals(y)，y.equals(z)都为true，那么x.equals(z)也为true
 * 4. 一致性（consistent）: 对于任何非null得引用值x,y，只要equals的比较操作对于对象中所用的信息没有被修改，多次调用x.equals(y)就会一致的返回true或者一致的返回false。
 * 5.  非空性（Non-nullity）对于任何非null的引用值，x.equals(null)为false。
 * 高质量的equals方法诀窍
 * 1. 使用==操作符检查“参数是否为这个对象的引用”
 * 2. 使用instanceof 操作符检查“参数是否为指定的类型”
 * 3. 把参数转化为正确的类型，因为转化前经过instanceof比较，所以一定会成功。
 * 4. 对于类中的每一个关键的域，检查参数中的域是否与该对象中的对应域保持一致。
 * 对于既不是float也不是double的基本类型域，可以使用==操作符进行比较，对于对象引用域，可以递归的调用equals方法。
 * 对于float域可以使用静态方法Float.compare(float,float)，对double域可以使用静态方法Double.compare(double,double)，对于Double和Float单独处理是有必要的，因为存在Float.NaN,-0.0f以及类似的double常量。
 * 虽然可以用静态方法Float.equals，但是每次都要进行自动装箱，导致效率下降。
 * 有的对象的引用域中包含null可能是合法的，所以为了避免可能导致的NullPointer Exception异常，可以使用静态方法Objects.equals(Object,Object)检查等同性。
 * <p>
 * 域的比较顺序可能会影响equals方法的性能。为了获得最佳的性能，应该最先比较最有可能不一致的域，或者是开销最小的域。
 *
 * 一般情况下，不要轻易的覆盖equals方法。如果要覆盖equals，一定需要比较这个类中的所有关键域。
 * @auther: Dimple
 * @date: 05/27/19
 * @version: 1.0
 */
public class Item10 {

    public static void main(String[] args) {
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString("test");
        String s = "test";
        System.out.println(caseInsensitiveString.equals(s));
        System.out.println(s.equals(caseInsensitiveString));

        System.out.println(Float.compare(1.2f, 123f));
        System.out.println(Float.compare(1.2f, 1.2f));
        System.out.println(Float.compare(123f, 1.2f));
        System.out.println(Objects.equals(null, new Integer("2")));
    }

}


final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase((((CaseInsensitiveString) obj).s));
        }
        //if (obj instanceof String) {
        //    return s.equalsIgnoreCase((String) obj);
        //}
        return false;
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return point.x == x && point.y == y;
    }
}

final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, " prefix");
        this.lineNum = rangeCheck(lineNum, 999, "lineNum");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) obj;
        return phoneNumber.lineNum == lineNum && phoneNumber.prefix == prefix && phoneNumber.areaCode == areaCode;
    }
}
