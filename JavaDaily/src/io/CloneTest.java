package io;

import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/3 21:04
 */

class Person implements Cloneable {
    private String name;
    private List<Cloth> cloths;

    @Override
    public Person clone() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cloth> getCloths() {
        return cloths;
    }

    public void setCloths(List<Cloth> cloths) {
        this.cloths = cloths;
    }
}

class Cloth {
    private String name;
    private String brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}

public class CloneTest {

}
