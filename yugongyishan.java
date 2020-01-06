package UML;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class yugongyishan extends JFrame implements ActionListener {
	Container container;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JTextField jt3;
	JComboBox<String> level;
	int number=1;//分数

	// 在类中定义主函数
	public static void main(String[] args) {
		// 在主函数中，实例化对象，调用初始化界面的方法
		new yugongyishan();
	}

	public yugongyishan() {
		// 设置窗体对象的属性值
		this.setTitle("愚公移山");// 设置窗体标题
		container = this.getContentPane();
		this.setSize(400, 400);// 设置窗体大小，只对顶层容器生效
		this.setDefaultCloseOperation(3);// 设置窗体关闭操作，3表示关闭窗体退出程序
		this.setLocationRelativeTo(null);// 设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
		this.setResizable(false);// 禁止调整窗体大小
		//实例化容器
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		// 实例化组件
		JButton jb4 = new JButton();
		jb4.setText("开始");
		JButton jb1 = new JButton();
		jb1.setText("干！");
		JButton jb2 = new JButton();
		jb2.setText("帮助");
		JButton jb3 = new JButton();
		jb3.setText("退出");
		//添加组件到容器当中
		jp1.add(jb4);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		this.add(jp1, BorderLayout.SOUTH);
		// 实例化组件
		jl1 = new JLabel("山的大小：");
		jl4 = new JLabel();
		jl2 = new JLabel("坑的大小：");
		jl5 = new JLabel();
		//添加组件到容器当中
		jp2.add(jl1);
		jp2.add(jl4);
		jp2.add(jl2);
		jp2.add(jl5);
		this.add(jp2, BorderLayout.NORTH);
		// 实例化组件
		jl3 = new JLabel("铲的大小：");
		jt3 = new JTextField(10);
		jl6 = new JLabel("游戏难度：");
		level = new JComboBox<String>();
		level.addItem("初级");
		level.addItem("中级");
		level.addItem("高级");
		//添加组件到容器当中
		jp3.add(jl3);
		jp3.add(jt3);
		jp3.add(jl6);
		jp3.add(level);
		this.add(jp3, BorderLayout.CENTER);

		this.setVisible(true);// 窗体可见，一定要放在所有组件加入窗体后
		// 添加监听
		jb2.addActionListener(new ActionLis2());
		jb3.addActionListener(new ActionLis3());
		jb4.addActionListener(new ActionLis4());
		jb1.addActionListener(this);
	}
	// 输入错误提示
	class ActionLis2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String msg = "每次请输入2的n次方来减少山的大小，例如：12=2*2*2+2*2";
			String title = "游戏说明";
			JOptionPane.showMessageDialog(container, msg, title, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	// 退出游戏提示
	class ActionLis3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String msg = "真的退出游戏？";
			String title = "提示信息";
			int result = JOptionPane.showConfirmDialog(container, msg, title, JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				// 单击是
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
	}
	// 难度选择栏
	class ActionLis4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ("开始".equals(e.getActionCommand())) {
				if (level.getSelectedItem() == "初级") {
					Random random = new Random();
					int i = random.nextInt(10);
					jl4.setText(String.valueOf(i));
					jl5.setText(String.valueOf(0));
				} else if (level.getSelectedItem() == "中级") {
					Random random = new Random();
					int i = random.nextInt(91)+10;
					jl4.setText(String.valueOf(i));
					jl5.setText(String.valueOf(0));
				} else {
					Random random = new Random();
					int i = random.nextInt(901)+100;
					jl4.setText(String.valueOf(i));
					jl5.setText(String.valueOf(0));
				}
			}
		}
	}
	// 游戏提示
	public void actionPerformed(ActionEvent e) {
		Random random = new Random();
		if ("干！".equals(e.getActionCommand())) {
			//判断是否有山
			if (jl4.getText().equals("")) {
				String msg = "没有山挖哦";
				String title = "游戏说明";
				JOptionPane.showMessageDialog(container, msg, title, JOptionPane.INFORMATION_MESSAGE);
			}else if(jt3.getText().equals("")){
				//判断是否有铲
				String msg = "还没有铲哦";
				String title = "游戏说明";
				JOptionPane.showMessageDialog(container, msg, title, JOptionPane.INFORMATION_MESSAGE);
			}else {
				int mountain = Integer.parseInt(jl4.getText());
				int keng = Integer.parseInt(jl5.getText());
				int wa = Integer.parseInt(jt3.getText());
				if (Check1(wa)) {
					mountain = mountain - wa;
					if (mountain == 0) {
						// 山被挖完
						String msg = "山挖完啦";
						String title = "游戏说明";
						JOptionPane.showMessageDialog(container, msg, title, JOptionPane.INFORMATION_MESSAGE);
						jl4.setText("");
						jl5.setText("");
						jt3.setText("");
						if(number<6) {//得分模块
						String msg1 = Integer.toString(random.nextInt(16)+85);
						String title1 = "本局得分";
						JOptionPane.showMessageDialog(container, msg1, title1, JOptionPane.INFORMATION_MESSAGE);						
						}else if(number>6 && number<12){
							String msg1 = Integer.toString(random.nextInt(25)+60);
							String title1 = "本局得分";
							JOptionPane.showMessageDialog(container, msg1, title1, JOptionPane.INFORMATION_MESSAGE);						
						}else{
							String msg1 = Integer.toString(random.nextInt(30)+30);
							String title1 = "本局得分";
							JOptionPane.showMessageDialog(container, msg1, title1, JOptionPane.INFORMATION_MESSAGE);		
						}
					} else if (mountain < 0) {
						// 挖出坑
						String msg = "挖出坑啦";
						String title = "游戏说明";
						JOptionPane.showMessageDialog(container, msg, title, JOptionPane.INFORMATION_MESSAGE);
						jt3.setText("");
					} else {
						//正常进行
						keng += wa;
						number++;
						jl4.setText(String.valueOf(mountain));
						jl5.setText(String.valueOf(keng));
						jt3.setText("");
					}
				} else {
					//输入错误提示
					String msg = "请输入2的n次方";
					String title = "游戏说明";
					JOptionPane.showMessageDialog(container, msg, title, JOptionPane.INFORMATION_MESSAGE);
					jt3.setText("");
				}
			}
		}
	}
	// 数据检查
	public boolean Check1(int n) {
		boolean boo = true;
		String s = Integer.toBinaryString(n);
		byte[] b = s.getBytes();
		for (int i = 1; i < b.length; i++) {
			if (b[i] != 48) {
				boo = false;
				break;
			}
		}
		return boo;
	}
}
