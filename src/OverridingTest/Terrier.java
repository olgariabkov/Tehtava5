package OverridingTest;

import java.io.IOException;

public class Terrier extends Dog{
    //public String walk() { metodi walk pitää olla void
      //  return "Walk the Dog";
    //}
    //private void walk(); virhe, metodi ilmoitettu, mutta ei ole toteutettu
    //public void walk() throws IOException { //ei voi olla poikkeus kun Dog luokassa ei ole

        //public void walk(int metres) {
            @Override public void walk() {
                System.out.println("Terrier::walk()");
            };
    //metodi ei voi määritellä muiden metodien sisällä
            //@Override public Dog run() {
                //return new Dog();
            //}
            @Override public Terrier run() {
                return new Terrier();
            //}
            //@Override public Dog run() {
                //return new Terrier();
            }
        }
  //  }
//}
