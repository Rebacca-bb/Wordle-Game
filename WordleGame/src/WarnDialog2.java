import javax.swing.*;
import java.awt.*;
/**�����Ӵ��� */
public class WarnDialog2 extends JDialog {
	/**�ù��췽���ṩ���ڷǷ��ַ����� */
	public WarnDialog2(Frame frame) {   //����һ��ָ��������ĶԻ���
		//���ø���Ĺ��췽������һ�������Ǹ����壬�ڶ��������Ǵ�����⣬������������ʾ����������
		super(frame,"Warning",true);
		Container container=getContentPane();  //���������
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
				
		JLabel jl=new JLabel("There exists some no-allowed char, please enter again!");
		jl.setFont(new Font("TimesRoman",Font.PLAIN,14));//��������
		container.add(jl);
		setBounds(505, 275, 385, 100);
	}
}
