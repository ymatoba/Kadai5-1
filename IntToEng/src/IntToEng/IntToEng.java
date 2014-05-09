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
    
    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {
    	
    	if(n<=19)return first(n);
    	else if(n<=999)return second(n);
    	
    	//桁数のお話
    	int length=0;
    	if(n<=9){length=1;
    	}else if(n<=99){length=2;
    	}
        return length+"";
    }
    
    static String first(int n){
    	String a[]={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixtenn","seventeen","eighteen","nineteen"};
    	return a[n];
    }
    
    static String second(int n){
    	String a[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    	String b[]={"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    	if(n<=99){
    		int x=n/10;
    		int y=n-10*x;    	
    		if(y==0) return b[x-2];
    		else return b[x-2]+" "+a[y];
    	}
    	
    	else if(n<=999){
    		int x=n/100;
    		int y=(n-x*100)/10;
    		int z=n-y*10-x*100;
    		
    		if(z==0 && y==0) {return a[x]+" hundred ";}
    		else if(z==0) {return a[x]+" hundred "+b[y-2];}
    		if(y==0) {return a[x]+ " hundred "+a[z];}
    		else {return a[x]+" hundred "+b[y-2]+a[z];}
     	}
    	
    	else return "";
    }
}