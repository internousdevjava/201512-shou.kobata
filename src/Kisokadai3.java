import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */

/**
 * @author internous
 *
 *
 */
public class Kisokadai3 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		while(true){
		System.out.println("メニューの数字を選択してください");
		System.out.println("1:現存するファイルの参照・追記、上書き　2:ファイル新規作成　3:フォルダ新規作成　4:終了");
		System.out.println("0:指定したフォルダの参照");
		BufferedReader me = new BufferedReader(new InputStreamReader(System.in));
		String men=me.readLine();
		if(checkStringnumber1to6(men)){
			int menu = Integer.parseInt(men);
		switch(menu){
		case 1:
			System.out.println("ファイル名を(c:/***/***.***)のようにフォルダの場所から入力してください");
			BufferedReader be=new BufferedReader(new InputStreamReader(System.in));
			String fn=be.readLine();
		while(true){
			System.out.println("メニューを選択してください");
			System.out.println("1:参照　2:追記　3:上書き　4:メインメニューへ戻る");
			System.out.println(fn+"選択中");
			BufferedReader mmm = new BufferedReader(new InputStreamReader(System.in));
			String mff=mmm.readLine();
			int mcc = 0;
			if(checkStringnumberXtoY(mff)){
				mcc = Integer.parseInt(mff);
			}else{System.out.println("1～4の半角数字で入力して下さい");continue;}

			switch (mcc) {
		case 1://参照
			System.out.println("選択されたファイルの内容を表示します");
			System.out.println(fn+"選択中");
			System.out.println();
			try {
				File file = new File(fn);

				if (checkBeforeReadfile(file)) {
					BufferedReader br = new BufferedReader(new FileReader(file));

					String str;
					while ((str = br.readLine()) != null) {
						System.out.println(str);
					}

					br.close();
				} else {
					System.out.println("ファイルが見つかりません");
				}
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}continue;
		case 2://追記
			File file =new File(fn);
			System.out.println("出力された文字の下から入力して下さい");
			System.out.println(fn+"選択中");
			System.out.println("改行して .end と打つと保存して終了します。");
			System.out.println();
			try {

				BufferedReader br = new BufferedReader(new FileReader(file));

				String str;
				while ((str = br.readLine()) != null) {
					System.out.println(str);
				}

				br.close();

				if(checkBeforeWritefile(file)){
					PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
				while(true){
				BufferedReader wr = new BufferedReader(new InputStreamReader(System.in));
				String a=wr.readLine();
				if(a .equals(".end")){break;}
				pw.println(a);
				}
				pw.close();
				}else{System.out.println("ファイルに書き込めません");}
			}catch (IOException e) {
				e.printStackTrace();
			}continue;
		case 3://上書き
			File files =new File(fn);
			System.out.println("もとあるデータを消して書き込みます");
			System.out.println(fn+"選択中");
			System.out.println("改行して .end と打つと上書きして終了します。");
			System.out.println();
			try {
				if(checkBeforeWritefile(files)){
					PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(files)));
				while(true){
				BufferedReader wr = new BufferedReader(new InputStreamReader(System.in));
				String a=wr.readLine();
				if(a .equals(".end")){break;}
				pw.println(a);
				}
				pw.close();
				}else{System.out.println("ファイルに書き込めません");}
			}catch (IOException e) {
				e.printStackTrace();
			}continue;
		case 4:
			break;

		default:
				System.out.println("メニュー番号が認識できません");continue;
			}break;
			}continue;

		case 2://フォルダの作成
			System.out.println("フォルダを作成します");
			System.out.println("作成したいフォルダ名を入力して下さい");
			System.out.println("※(c:/***/***の)ような書き方をすると作成するフォルダが選択できます");
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			String a=null;
			try {
				a = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File newdir = new File(a);

			if(newdir.mkdirs()){
				System.out.println("フォルダを作成しました");
			}else{
				System.out.println("作成ができませんでした");
			}continue;

		case 3://ファイルの作成
			System.out.println("ファイルを作成します");
			System.out.println("作成したいファイル名を拡張子まで入力して下さい");
			System.out.println("※(c:/***/***.**の)ような書き方をすると作成するフォルダが選択できます");
			BufferedReader br1 =new BufferedReader(new InputStreamReader(System.in));
			String b=null;
			try {
				b = br1.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File newfile = new File(b);

			if(newfile.createNewFile()){
			System.out.println("ファイルを作成しました");
			}else{
				System.out.println("作成に失敗しました");
			}continue;

		case 0:
			System.out.println("指定したフォルダを参照します");
			System.out.println("参照したいフォルダ名を c:/***/*** のように入力してださい");
			System.out.println("名前の頭にファイルならば[F]ディレクトリならば[D]それ以外は[?]と表示されます");
			BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
			String name =null;
			try {
				name = cr.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File file=new File(name);
			File []filelist=file.listFiles();
			for(int i=0;i<filelist.length;i++){
				if(filelist[i].isFile()){
					System.out.println("[F]"+filelist[i].getName());
				}else if(filelist[i].isDirectory()){
					System.out.println("[D]"+filelist[i].getName());
				}else{System.out.println("[?]"+filelist[i].getName());
				}}
			continue;
		case 4:
		System.out.println("終了します。");break;
	default:
			System.out.println("メニュー番号が認識できません");continue;
			}
		}else{System.out.println("1～5の半角数字で入力して下さい");continue;}break;
		}

		}


	private static boolean checkStringnumber1to6(String men) {
		Pattern p = Pattern.compile("^[0-5]*$");
		Matcher m = p.matcher(men);
		return m.find();
	}

	private static boolean checkStringnumberXtoY(String men) {
		Pattern p = Pattern.compile("^[1-4]*$");
		Matcher m = p.matcher(men);
		return m.find();
	}


	private static boolean checkBeforeWritefile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkBeforeReadfile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canRead()) {
				return true;
			}
		}
		return false;
	}

}
