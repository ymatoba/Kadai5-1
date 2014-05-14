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
		else if(n<=9999)return third(n);
		else if(n<=99999)return forth(n);

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
	
	static String first2(int n){
		String a[]={"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixtenn","seventeen","eighteen","nineteen"};
		return a[n];
	}	

	static String second(int n){
		String a[]={"","one","two","three","four","five","six","seven","eight","nine"};
		String b[]={"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

		if(n<=99){
			int x=n/10;
			int y=n-10*x;    	
			if(y==0) return b[x-2];
			else return b[x-2]+" "+a[y];
		}

		else if(n<=999){
			int x=n/100;//100の位の数
			int y=(n-x*100)/10;//10の位の数
			int z=n-y*10-x*100;//1の位の数

			int w;
			w=n-x*100;
			if(w<=19&&w>=10){return a[x]+" handred "+first(w);} 		
			else{
				if(z==0 && y==0) {return a[x]+" hundred ";}//200
				if(z==0 && y!=0) {return a[x]+" hundred "+b[y-2];}
				if(y==0 && z!=0) {return a[x]+ " hundred "+a[z];}//201
				else{return a[x]+" hundred "+b[y-2]+" "+a[z];}//222
			}
		}

		else return "";
	}
	
	static String third(int n){
		String a[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		int x=n/1000;//1000の位
		int p=(n-x*1000);
		
		if(p<=19){return a[x]+" thousand "+first2(p);}
		else{return a[x]+" thousand "+second(p);}
	}
	
	static String forth(int n){
		String a[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		int x=n/10000;//10000の位
		int y=(n-x*10000)/1000;//1000の位
		
		int p=x*10+y;//上位2桁
		int q=(n-p*1000);//下位3桁
		if(p<=19){ //first2処理
			if(q<=19)return first2(p)+" thousand "+first2(q);
			else return first2(p)+" thousand "+second(q);
		
		}
		else{ //not first2
			if(q<=19)return second(p)+" thousand "+first2(q);
			else return second(p)+" thousand "+second(q);
		}
	}
}