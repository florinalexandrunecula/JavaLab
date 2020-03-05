package hello;

public class Byte {

    static byte defaultValue;

    public static void main(String[] args) {
        byte b1 = -128;
        System.out.println(b1);

        byte b2= 127;
        System.out.println(b2);
        b2++; //b2=b2+1
        System.out.println(b2++);
        System.out.println(++b2);

        //byte b3=12345; //crapa
        byte b3=(byte)12345;
        System.out.println(b3);

        System.out.println(defaultValue);
    }
}
