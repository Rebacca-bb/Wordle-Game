import javax.swing.*;
import java.awt.*;

/**�Զ���һ����ʾ��Ϸ�ɹ��ĶԻ��� */
public class SuccessDialog extends JDialog {
	/**����һ��ָ��������ĶԻ��� */
	public SuccessDialog(Frame frame) {   
		//���ø���Ĺ��췽������һ�������Ǹ����壬�ڶ��������Ǵ�����⣬������������ʾ����������
		super(frame,"Result",true);
		Container container=getContentPane();  //���������
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JLabel jl=new JLabel("You win!");
		jl.setFont(new Font("TimesRoman",Font.PLAIN,20));//��������
		container.add(jl);
		setBounds(600, 225, 200, 200);
	}
}
