/*
 * Hash codes for primitive types as described in sec. 27.3.1
 */
package Liang.chpt25;

/**
 *
 * @author bobgi
 */
public class HashDemo {
    public static void main(String[] argv){
        
        //Primitive key hash code
        //           01234567012345670123456701234567
        int unsignedKey = 0x80000000;
        int key=0x80000000;
        
        System.out.println("0123456701234567012345670123456701234567012345670123456701234567");
        System.out.printf ("%32s\n", Integer.toBinaryString((int)unsignedKey));
        System.out.printf ("%32s\n", Integer.toBinaryString((int)(unsignedKey >>> 16)));
        System.out.printf("%32s\n", Integer.toBinaryString((int)(unsignedKey ^ (unsignedKey >>> 16))));  // folding

        
        System.out.println("\n0123456701234567012345670123456701234567012345670123456701234567");
        System.out.printf ("%32s\n", Integer.toBinaryString((int)key));
        System.out.printf ("%32s\n", Integer.toBinaryString((int)(key >> 16)));
        System.out.printf("%32s\n", Integer.toBinaryString((int)(key ^ (key >> 16))));  // folding
        
        // String key hash code using Horner's algorithm
        System.out.println("AB8C".hashCode());
        System.out.println((('A'*31+'B')*31+'8')*31+'C');
        
        System.out.println(((('A'-'A' + 10)*16+('B'-'A' + 10))*16+('8'-'0'))*16+('C'-'A' + 10));
    }
}
