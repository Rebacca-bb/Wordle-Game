import javax.swing.*;
import java.awt.*;

/**创建子窗口 */
public class WarnDialog1 extends JDialog {
	/**该构造方法提供字母数量不等于5的弹窗 */
	public WarnDialog1(Frame frame) {   //创建一个指定父窗体的对话框
		//调用父类的构造方法，第一个参数是父窗体，第二个参数是窗体标题，第三个参数表示阻塞父窗体
		super(frame,"Warning",true);
		Container container=getContentPane();  //获得主容器
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		
		JLabel jl=new JLabel("The length of word isn't equal to 5, please enter again!");
		jl.setFont(new Font("TimesRoman",Font.PLAIN,14));//设置字体
		container.add(jl);
		setBounds(505, 275, 385, 100);
	}
}
