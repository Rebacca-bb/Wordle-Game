import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gaming extends JFrame {
	
	RandomWord ranWord=new RandomWord();			
	Judging judging=new Judging();
	private String str1=ranWord.chooseWord();
	private int numOfinput=0;								//用于计数输入的次数
		
	public Gaming() {
		Container c=getContentPane(); 						//获取窗体容器
		
		c.setLayout(new GridLayout(1,2,10,10));				//将整个容器设置为左右两块的网格布局，组件水平竖直间隔都为10像素
		/**设置左侧平面布局*/
		JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		JPanel p2=new JPanel(new GridLayout(3,1,2,2));		
		p1.setBorder(BorderFactory.createTitledBorder("The random word:")); 
		p2.setBorder(BorderFactory.createTitledBorder("Please enter your guess(5 letters):")); 		
		JPanel leftPanel=new JPanel(new GridLayout(6,1,2,2));
		leftPanel.setBorder(BorderFactory.createTitledBorder("Input content and hints")); 
		c.add(leftPanel);
		/**设置右侧平面布局*/
		JPanel rightPanel=new JPanel(new GridLayout(2,1,2,2));
		rightPanel.add(p1);
		rightPanel.add(p2);
		c.add(rightPanel);
			
		/**以下内容为面板p1的内容 */
		JLabel introSentence=new JLabel("The random word is:");
		System.out.println("The random word is:"+str1);     		//将该随机单词打印在控制台
		introSentence.setFont(new Font("TimesRoman",Font.PLAIN,25));//设置字体
		p1.add(introSentence);
		
		JLabel randomLetters=new JLabel(" "+str1);   			   	//需要猜测的单词存储在randomLetters中
		randomLetters.setFont(new Font("TimesRoman",Font.PLAIN,30));//设置字体
			
		/**以下内容为面板p2的内容 */
		JTextField jt=new JTextField(); 					//设定文本框初始值
		jt.setColumns(20);									//设置文本框长度
		jt.setFont(new Font("TimesRoman",Font.PLAIN,25));	//设置字体
		
		JLabel leftChance=new JLabel("The remaining chance:"+(6-numOfinput));  //设置"机会次数"的提示栏
		leftChance.setFont(new Font("TimesRoman",Font.PLAIN,20));
		JPanel p22=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10)); //作为p2下的一个子面板
		p22.add(leftChance);
		
		JButton jb1=new JButton("Next step");
		JButton jb2=new JButton("Clear");
		JButton jb3=new JButton("Try again");
		JPanel p23=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10)); //作为p2下的一个子面板
		p23.add(jb1);
		p23.add(jb2);
		p23.add(jb3);	
		
		/**为“确定”按钮添加事件 //添加监听方法（new 监听接口（）实现接口中的方法actionPerformed）*/					
		jb1.addActionListener(new ActionListener() {    						
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Your guess:"+jt.getText()); 			//输出当前文本框的值
				String str2=(jt.getText()).toLowerCase();   				//将输入的内容转化为小写，以至能够与ranWord相匹配，再将其存入str2
				
				if(!judging.judgeNum(str2)) {
					System.out.println("The length of word isn't equal to 5, please enter again!");
					WarnDialog1 warnDialog1=new WarnDialog1(null);  		//创建WarnDialog1对话框
					warnDialog1.setVisible(true);						  	//使对话框可见	
				}
				else if(!judging.judgeLetters(str2)) {
					System.out.println("There exists some no-allowed char, please enter again!");
					WarnDialog2 warnDialog2=new WarnDialog2(null);  		//创建WarnDialog1对话框
					warnDialog2.setVisible(true);						  	//使对话框可见	
				}
				else {
					numOfinput++; 											  		//用于记录输入的次数
					leftChance.setText("The remaining chance: "+(6-numOfinput));    //更新”机会次数“的提示栏内容

					if (numOfinput<=6){													  //当输入要求与要求不相符，但尚未到达第六次
						JPanel judgeGrid=new JPanel(new GridLayout(1,5,2,5));   	  	  //创建一个左侧平面下的子平面judgeGrid，由块内容组成
						JButton btn[]=new JButton[5];
						for(int i=0;i<5;i++) {
							String temp0=str2.substring(i,i+1);
							btn[i]=new JButton(temp0);
							btn[i].setFont(new Font("TimesRoman",Font.PLAIN,20));   //设置字体
							
							//用于调整每个字母的背景颜色
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
								
							btn[i].setEnabled(false);  		//设置按钮为不可用，只读
							judgeGrid.add(btn[i]);		
						}				
						leftPanel.add(judgeGrid);
						
						jt.setText("");  				// 将文本框置空
						jt.requestFocus();				// 焦点回到文本框								
						setVisible(true);   			//类似等于刷新了一遍
						
						if(numOfinput==6) {								  		  //当输入要求与要求不相符，且已经输入了第六次
							p1.add(randomLetters);								  //程序结束后，将答案公布
							jb1.setEnabled(false);   							  //程序结束后禁用确定按钮，防止用户乱按
							setVisible(true);   								  //等于刷新了一遍
							
							FailDialog faildialog=new FailDialog(null);			  //创建FailDialog对话框
							faildialog.setVisible(true);						  //使对话框可见
						}
						else if(str2.equals(str1)) {                                   //当输入单词与要求相符时
							p1.add(randomLetters);								  //程序结束后，将答案公布
							jb1.setEnabled(false);   							  //程序结束后禁用确定按钮，防止用户乱按
							setVisible(true);   								  //等于刷新了一遍
							
							SuccessDialog successdialog=new SuccessDialog(null);  //创建SuccessDialog对话框
							successdialog.setVisible(true);						  //使对话框可见					
						}					
					}
				}
			}
		});
		
		/** 为"清除"按钮添加事件 */
		jb2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {				
				jt.setText("");  							// 将文本框置空
				jt.requestFocus();							// 焦点回到文本框				
			}
		});
		
		/**为“再来一次”按钮添加事件 */
		jb3.addActionListener(new ActionListener() { 		
			public void actionPerformed(ActionEvent e) {
				numOfinput=0;					//将输入次数重新置为0
				//面板1的重置
				randomLetters.setText("");       //将面板1中的单词显示置空
				//面板2的重置
				jt.setText("");  				// 将文本框置空
				jt.requestFocus();				// 焦点回到文本框	
				leftChance.setText("The remaining chance: "+(6-numOfinput)); //重置输入次数
				jb1.setEnabled(true);			//让“确定”变为可用
				//左侧面板的重置
				leftPanel.removeAll();					//先移除左侧面板中的所有组件
				leftPanel.repaint();					//运用repaint进行重绘			
						
				str1=ranWord.chooseWord();				//为str0附上一个新的单词
				introSentence.setText("The random word is:");
				System.out.println("The random word is:"+str1);     //将该随机单词打印在控制台			
			}
		});			
		p2.add(jt);     //将文本框jt添入面板p2
		p2.add(p22);	//将子面板p22添入面板p2
		p2.add(p23);	//将子面板p23添入面板p2
		
		/**对容器c的设置 */		
		setTitle("Wordle Game");
		setBounds(100, 100, 800, 450);
		setVisible(true);   
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		Gaming gaming= new Gaming();			
	}

}
