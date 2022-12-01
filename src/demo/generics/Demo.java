package demo.generics;

public class Demo <S>{
    /*
   S,E: Element referrence
   N: Number
   T: Type
   K: Key
   V: Value

 */
    S element;

    public S getElement() {
        return element;
    }

    public void setElement(S element) {
        this.element = element;
    }


    public <E> void print(E msg){
        System.out.println(msg);
    }
}
