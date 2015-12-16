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
public class Kisokadai2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
		System.out.println("数当てゲームHigh&Low！");
		int ans = new java.util.Random().nextInt(99) + 1;
		for (int i = 10; i > 0; i--) {
			System.out.println("↓1～100までの数字を一つ入力してください↓チャンスはあと" + i + "回！");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String kai = null;
			try {
				kai = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (checkStringNumber(kai)) {

				int x = Integer.parseInt(kai);
				if (x == ans) {
					System.out.println("正解!!");
					break;
				} else if (x < ans) {
					System.out.println("低すぎます");
				} else {
					System.out.println("高すぎます");
				}
			} else {
				System.out.println("半角数字でお願いします。");i++;
			}
			continue;
		}
		System.out.println("ゲーム終了！答えは" + ans + "でした。");
		System.out.println("もう一度の場合は１を終了する時はそれ以外の数字を入力して下さい");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String a=null;
		try {
			a = br.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(checkStringNumber(a)) {
			int b=Integer.parseInt(a);
			if(b==1){
				continue;
			}else{break;
			}
			}else{continue;
		}
		}
	}
	public static boolean checkStringNumber(String number) {
		Pattern p = Pattern.compile("^[0-9]*$||^[０-９]*$");
		Matcher m = p.matcher(number);

		return m.find();
	}

}
