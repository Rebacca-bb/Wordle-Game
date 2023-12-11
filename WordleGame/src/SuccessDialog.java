import javax.swing.*;
import java.awt.*;

/**自定义一个表示游戏成功的对话框 */
public class SuccessDialog extends JDialog {
	/**创建一个指定父窗体的对话框 */
	public SuccessDialog(Frame frame) {   
		//调用父类的构造方法，第一个参数是父窗体，第二个参数是窗体标题，第三个参数表示阻塞父窗体
		super(frame,"Result",true);
		Container container=getContentPane();  //获得主容器
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JLabel jl=new JLabel("You win!");
		jl.setFont(new Font("TimesRoman",Font.PLAIN,20));//设置字体
		container.add(jl);
		setBounds(600, 225, 200, 200);
	}
}
