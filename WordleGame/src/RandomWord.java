import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class RandomWord {
	
	/**�÷������ڵõ�һ�����5����ĸ��ɵĵ��� */
	public String chooseWord() {
		String randomletter=null;
		String string0="";				 		 //���ڴ洢�ļ��е�ȫ������    string0=null �ͻ��nullռ�˿�ͷ�ĸ��ַ�
		//File file=new File("F:\\java\\eclipse\\eclipse_workspace\\WordleGame\\src\\letters.TXT");   //�����ļ�����
		File file=new File("letters.TXT");   			//�����ļ�����  Elipse ide ���е���WordleGameĿ¼�µ�letters.TXT
												        //���������г���ʱ�����е���srcĿ¼�µ�letters.TXT
		
		try {
			FileReader fr=new FileReader(file);				//�ļ��ַ�������
			BufferedReader br= new BufferedReader(fr); 		//����������
			String string = br.readLine();					//stringΪһ����ʱ�洢ÿ�е��ַ���
			while (string != null) {  						//һ��һ�ж����ļ����������ݶ�д��string��
				string0 = string0+string;        
				string = br.readLine();
			}
			//System.out.println(string0.length());
			int amount=(int)(string0.length()/6);						//�õ����ʵ��ܸ�����һ�����ʼ���һ���ո���txt�ļ���ռ6��
			int num=(int)(amount*Math.random()+1);						//����õ�һ�����ʵ�λ�ã���1����...��num����λ�á���
			randomletter=string0.substring((num-1)*6, (num-1)*6+5); 	//�õ�����ĵ���  (num-1)*6�����ʵĿ�ͷ��λ��  (num-1)*6+5)����۳��ո�󵥴ʽ�β��λ��
			
			br.close(); 
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("error happen!");
			System.exit(1);  						//�������˳�����
		}
		
		return randomletter;
	}
	
	/** ���Բ������� */
	public static void main(String[] args) {
		RandomWord test= new RandomWord();
		String teststring=test.chooseWord();
		System.out.println(teststring);
		
	}
}
