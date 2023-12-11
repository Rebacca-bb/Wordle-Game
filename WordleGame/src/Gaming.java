import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gaming extends JFrame {
	
	RandomWord ranWord=new RandomWord();			
	Judging judging=new Judging();
	private String str1=ranWord.chooseWord();
	private int numOfinput=0;								//���ڼ�������Ĵ���
		
	public Gaming() {
		Container c=getContentPane(); 						//��ȡ��������
		
		c.setLayout(new GridLayout(1,2,10,10));				//��������������Ϊ������������񲼾֣����ˮƽ��ֱ�����Ϊ10����
		/**�������ƽ�沼��*/
		JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		JPanel p2=new JPanel(new GridLayout(3,1,2,2));		
		p1.setBorder(BorderFactory.createTitledBorder("The random word:")); 
		p2.setBorder(BorderFactory.createTitledBorder("Please enter your guess(5 letters):")); 		
		JPanel leftPanel=new JPanel(new GridLayout(6,1,2,2));
		leftPanel.setBorder(BorderFactory.createTitledBorder("Input content and hints")); 
		c.add(leftPanel);
		/**�����Ҳ�ƽ�沼��*/
		JPanel rightPanel=new JPanel(new GridLayout(2,1,2,2));
		rightPanel.add(p1);
		rightPanel.add(p2);
		c.add(rightPanel);
			
		/**��������Ϊ���p1������ */
		JLabel introSentence=new JLabel("The random word is:");
		System.out.println("The random word is:"+str1);     		//����������ʴ�ӡ�ڿ���̨
		introSentence.setFont(new Font("TimesRoman",Font.PLAIN,25));//��������
		p1.add(introSentence);
		
		JLabel randomLetters=new JLabel(" "+str1);   			   	//��Ҫ�²�ĵ��ʴ洢��randomLetters��
		randomLetters.setFont(new Font("TimesRoman",Font.PLAIN,30));//��������
			
		/**��������Ϊ���p2������ */
		JTextField jt=new JTextField(); 					//�趨�ı����ʼֵ
		jt.setColumns(20);									//�����ı��򳤶�
		jt.setFont(new Font("TimesRoman",Font.PLAIN,25));	//��������
		
		JLabel leftChance=new JLabel("The remaining chance:"+(6-numOfinput));  //����"�������"����ʾ��
		leftChance.setFont(new Font("TimesRoman",Font.PLAIN,20));
		JPanel p22=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10)); //��Ϊp2�µ�һ�������
		p22.add(leftChance);
		
		JButton jb1=new JButton("Next step");
		JButton jb2=new JButton("Clear");
		JButton jb3=new JButton("Try again");
		JPanel p23=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10)); //��Ϊp2�µ�һ�������
		p23.add(jb1);
		p23.add(jb2);
		p23.add(jb3);	
		
		/**Ϊ��ȷ������ť����¼� //��Ӽ���������new �����ӿڣ���ʵ�ֽӿ��еķ���actionPerformed��*/					
		jb1.addActionListener(new ActionListener() {    						
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Your guess:"+jt.getText()); 			//�����ǰ�ı����ֵ
				String str2=(jt.getText()).toLowerCase();   				//�����������ת��ΪСд�������ܹ���ranWord��ƥ�䣬�ٽ������str2
				
				if(!judging.judgeNum(str2)) {
					System.out.println("The length of word isn't equal to 5, please enter again!");
					WarnDialog1 warnDialog1=new WarnDialog1(null);  		//����WarnDialog1�Ի���
					warnDialog1.setVisible(true);						  	//ʹ�Ի���ɼ�	
				}
				else if(!judging.judgeLetters(str2)) {
					System.out.println("There exists some no-allowed char, please enter again!");
					WarnDialog2 warnDialog2=new WarnDialog2(null);  		//����WarnDialog1�Ի���
					warnDialog2.setVisible(true);						  	//ʹ�Ի���ɼ�	
				}
				else {
					numOfinput++; 											  		//���ڼ�¼����Ĵ���
					leftChance.setText("The remaining chance: "+(6-numOfinput));    //���¡��������������ʾ������

					if (numOfinput<=6){													  //������Ҫ����Ҫ�����������δ���������
						JPanel judgeGrid=new JPanel(new GridLayout(1,5,2,5));   	  	  //����һ�����ƽ���µ���ƽ��judgeGrid���ɿ��������
						JButton btn[]=new JButton[5];
						for(int i=0;i<5;i++) {
							String temp0=str2.substring(i,i+1);
							btn[i]=new JButton(temp0);
							btn[i].setFont(new Font("TimesRoman",Font.PLAIN,20));   //��������
							
							//���ڵ���ÿ����ĸ�ı�����ɫ
							if(str1.charAt(i)==(str2.charAt(i))) {
								btn[i].setBackground(Color.green);
								btn[i].setOpaque(true);
							}else if(str1.indexOf(str2.charAt(i))!=-1){
								btn[i].setBackground(Color.yellow);
								btn[i].setOpaque(true);
							}else {
								btn[i].setBackground(Color.gray);
								btn[i].setOpaque(true);
							}
								
							btn[i].setEnabled(false);  		//���ð�ťΪ�����ã�ֻ��
							judgeGrid.add(btn[i]);		
						}				
						leftPanel.add(judgeGrid);
						
						jt.setText("");  				// ���ı����ÿ�
						jt.requestFocus();				// ����ص��ı���								
						setVisible(true);   			//���Ƶ���ˢ����һ��
						
						if(numOfinput==6) {								  		  //������Ҫ����Ҫ����������Ѿ������˵�����
							p1.add(randomLetters);								  //��������󣬽��𰸹���
							jb1.setEnabled(false);   							  //������������ȷ����ť����ֹ�û��Ұ�
							setVisible(true);   								  //����ˢ����һ��
							
							FailDialog faildialog=new FailDialog(null);			  //����FailDialog�Ի���
							faildialog.setVisible(true);						  //ʹ�Ի���ɼ�
						}
						else if(str2.equals(str1)) {                                   //�����뵥����Ҫ�����ʱ
							p1.add(randomLetters);								  //��������󣬽��𰸹���
							jb1.setEnabled(false);   							  //������������ȷ����ť����ֹ�û��Ұ�
							setVisible(true);   								  //����ˢ����һ��
							
							SuccessDialog successdialog=new SuccessDialog(null);  //����SuccessDialog�Ի���
							successdialog.setVisible(true);						  //ʹ�Ի���ɼ�					
						}					
					}
				}
			}
		});
		
		/** Ϊ"���"��ť����¼� */
		jb2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {				
				jt.setText("");  							// ���ı����ÿ�
				jt.requestFocus();							// ����ص��ı���				
			}
		});
		
		/**Ϊ������һ�Ρ���ť����¼� */
		jb3.addActionListener(new ActionListener() { 		
			public void actionPerformed(ActionEvent e) {
				numOfinput=0;					//���������������Ϊ0
				//���1������
				randomLetters.setText("");       //�����1�еĵ�����ʾ�ÿ�
				//���2������
				jt.setText("");  				// ���ı����ÿ�
				jt.requestFocus();				// ����ص��ı���	
				leftChance.setText("The remaining chance: "+(6-numOfinput)); //�����������
				jb1.setEnabled(true);			//�á�ȷ������Ϊ����
				//�����������
				leftPanel.removeAll();					//���Ƴ��������е��������
				leftPanel.repaint();					//����repaint�����ػ�			
						
				str1=ranWord.chooseWord();				//Ϊstr0����һ���µĵ���
				introSentence.setText("The random word is:");
				System.out.println("The random word is:"+str1);     //����������ʴ�ӡ�ڿ���̨			
			}
		});			
		p2.add(jt);     //���ı���jt�������p2
		p2.add(p22);	//�������p22�������p2
		p2.add(p23);	//�������p23�������p2
		
		/**������c������ */		
		setTitle("Wordle Game");
		setBounds(100, 100, 800, 450);
		setVisible(true);   
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		Gaming gaming= new Gaming();			
	}

}
