package com.dimple.effectiveJava.chapter2;

import javafx.util.Builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @className: Item2
 * @description: 遇到多个构造器参数时考虑使用构建器
 * <p>
 * 静态工厂和构造器都有一个共同的局限性：他们都不能很好的扩展到大量可选的参数。
 * 重叠构造器模式在参数较少的时候可行。
 * JavaBean模式存在很大的缺点，因为JavaBean的构造过程被分到几个调用中，在构造过程中，JavaBean可能存在不一致的状态。需要确保线程安全。
 * <p>
 * 建造者模式（Builder）可以保证重叠构造器一样安全，并且可以像JavaBean模式一样有很好的可读性。
 * 不直接生成想要的对象，而是让客户端利用所有必要的参数调用构造器（或者静态工厂），得到一个Builder对象，然后客户端在Builder对象上调用类似于setter的方法，来设置相关可选参数。
 * 与构造器相比，Builder的优势在于可以有多个可变的参数，因为Builder是单独的方法来设置每一个参数。
 *
 * @auther: Dimple
 * @date: 05/15/19
 * @version: 1.0
 */
public class Item2 {
    public void test() {
        //注意NutritionFacts是不可变的，所有默认参数值都单独放在一个地方。Builder的设值方法返回的是Builder本身，以便把调用链接起来。
        NutritionFacts build = new NutritionFacts.Builer(240, 120).calories(20).carbohydrate(123).build();
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM).addTopping(Pizza.Topping.MUSHROOM).build();
        Calzone calzone = new Calzone.Builder().sauceInside().build();
    }
}

class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts(Builer builer) {
        servingSize = builer.servingSize;
        servings = builer.servings;
        calories = builer.calories;
        fat = builer.fat;
        sodium = builer.sodium;
        carbohydrate = builer.carbohydrate;
    }

    public static class Builer {
        //Required parameters
        private final int servingSize;
        private final int servings;
        //Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builer(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builer calories(int val) {
            calories = val;
            return this;
        }

        public Builer fat(int val) {
            fat = val;
            return this;
        }

        public Builer sodium(int val) {
            sodium = val;
            return this;
        }

        public Builer carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
}

abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPRT, SAUSAGE}

    final Set<Topping> toppings;

    //Pizza.builder的类型是一个泛型（generic type），带有一个递归类型参数（recursive type parameter），它和抽象的self()方法一样，允许在子类中适当的进行方法链接，不需要转换类型
    abstract static class Builer<T extends Builer<T>> {
        //创建一个Enum的空集合，指定其集合元素是Topping类的枚举值
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract public Pizza build();

        protected abstract T self();
    }

    Pizza(Builer<?> builer) {
        toppings = builer.toppings.clone();
    }
}

class NyPizza extends Pizza {

    public enum Size {SMAIL, MEDIUM, LAGER}

    private final Size size;

    private NyPizza(Builder builer) {
        super(builer);
        size = builer.size;
    }

    public static class Builder extends Pizza.Builer<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        //注意，每个子类中的build方法都应该返回正确的子类；这样客户端就可以不需要转型就能使用
        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}

class Calzone extends Pizza {
    private final boolean sauceInside;

    public Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builer<Builder> {
        private boolean sauceInside = false;//default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}

