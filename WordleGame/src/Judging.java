  
public class Judging {
	/** 用于判断输入的单词字母数量是否为5个 */
	public boolean judgeNum(String s) {
		boolean judge=true;
		if(s.length()!=5) 
			judge=false;
		
		return judge;
	}
	/** 判断输入的是否为字母 */
	public boolean judgeLetters(String s) {
		boolean judge=true;
		for(int i=0;i<s.length();i++) {
			char temp=s.charAt(i);
			int temp_ascii=Integer.valueOf(temp);   //返回temp的ascii
			if((temp_ascii<65)||((temp_ascii>90)&&(temp_ascii<97))||(temp_ascii>122))
				judge=false;
		}
		return judge;		
	}
	
	public static void main(String[] args) {
		String s0="hello";
		String s1="helloo";
		String s2="12345";
		Judging judging=new Judging();
		System.out.println(judging.judgeNum(s0));
		System.out.println(judging.judgeLetters(s0));
		System.out.println(judging.judgeNum(s1));
		System.out.println(judging.judgeLetters(s1));
		System.out.println(judging.judgeNum(s2));
		System.out.println(judging.judgeLetters(s2));
	}
}
