import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */

/**
 * @author internous
 *
 */
public class Kisokadai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
		System.out.println("↓xの値を半角数字(1～100以内)で入力して下さい↓");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String abr=null;
		try {
			abr = br.readLine();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		if(checkStringNumber(abr)){
			int x =Integer.parseInt(abr);
		System.out.println("↓yの値を半角数字(1～100以内)で入力して下さい↓");

		BufferedReader bbr=new BufferedReader(new InputStreamReader(System.in));
		String cbr = null;
		try {
			cbr = bbr.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(checkStringNumber(cbr)){
			int y =Integer.parseInt(cbr);

		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				System.out.printf(" %5d",i*j);
			}System.out.println();
		}
		}else{System.out.println("指定された範囲(半角数字)で入力して下さい");continue;}

		}else{System.out.println("指定された範囲(半角数字)で入力して下さい");continue;}
		break;}
	}

	public static boolean checkStringNumber(String abr) {
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(abr);

		return m.find();
	}

}
