import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class RandomWord {
	
	/**该方法用于得到一个随机5个字母组成的单词 */
	public String chooseWord() {
		String randomletter=null;
		String string0="";				 		 //用于存储文件中的全部内容    string0=null 就会把null占了开头四个字符
		//File file=new File("F:\\java\\eclipse\\eclipse_workspace\\WordleGame\\src\\letters.TXT");   //创建文件对象
		File file=new File("letters.TXT");   			//创建文件对象  Elipse ide 运行的是WordleGame目录下的letters.TXT
												        //命令行运行程序时，运行的是src目录下的letters.TXT
		
		try {
			FileReader fr=new FileReader(file);				//文件字符输入流
			BufferedReader br= new BufferedReader(fr); 		//缓冲输入流
			String string = br.readLine();					//string为一个临时存储每行的字符串
			while (string != null) {  						//一行一行读入文件，并将内容都写入string中
				string0 = string0+string;        
				string = br.readLine();
			}
			//System.out.println(string0.length());
			int amount=(int)(string0.length()/6);						//得到单词的总个数（一个单词加上一个空格在txt文件中占6格）
			int num=(int)(amount*Math.random()+1);						//随机得到一个单词的位置（第1个、...第num个“位置”）
			randomletter=string0.substring((num-1)*6, (num-1)*6+5); 	//得到随机的单词  (num-1)*6代表单词的开头的位置  (num-1)*6+5)代表扣除空格后单词结尾的位置
			
			br.close(); 
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("error happen!");
			System.exit(1);  						//非正常退出程序
		}
		
		return randomletter;
	}
	
	/** 测试部分内容 */
	public static void main(String[] args) {
		RandomWord test= new RandomWord();
		String teststring=test.chooseWord();
		System.out.println(teststring);
		
	}
}
