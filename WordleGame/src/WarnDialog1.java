import javax.swing.*;
import java.awt.*;

/**�����Ӵ��� */
public class WarnDialog1 extends JDialog {
	/**�ù��췽���ṩ��ĸ����������5�ĵ��� */
	public WarnDialog1(Frame frame) {   //����һ��ָ��������ĶԻ���
		//���ø���Ĺ��췽������һ�������Ǹ����壬�ڶ��������Ǵ�����⣬������������ʾ����������
		super(frame,"Warning",true);
		Container container=getContentPane();  //���������
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		
		JLabel jl=new JLabel("The length of word isn't equal to 5, please enter again!");
		jl.setFont(new Font("TimesRoman",Font.PLAIN,14));//��������
		container.add(jl);
		setBounds(505, 275, 385, 100);
	}
}
