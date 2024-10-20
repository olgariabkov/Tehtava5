package OverridingTest;

public class Dog {

    public void walk() {
        System.out.println("Dog::walk()");
    };
    public Dog run() {
        return new Dog(); }
}


