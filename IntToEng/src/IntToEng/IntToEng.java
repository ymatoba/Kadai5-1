/**
 * 
 */
/**
 * @author g12928my
 *
 */
package IntToEng;

import java.util.Scanner;

public class IntToEng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        System.out.println(translateEng(input));
        
    }
    
    // ���l���p�󂷂�ϊ����郁�\�b�h
    static String translateEng(int n) {
    	
    	if(n<=19)return nineteen(n);
    	
    	//�����̂��b
    	int length=0;
    	if(n<=9){length=1;
    	}else if(n<=99){length=2;
    	}
        return length+"";
    }
    
    static String nineteen(int n){
    	String a[]={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","tweble","thierteen","fourteen","fifteen","sixtenn","seventeen","eighteen","nineteen"};
    	return a[n];
    }
}