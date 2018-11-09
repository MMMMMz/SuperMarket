package exp3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

import javax.swing.JTextField;


public class SuperMarket {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Font font1 = new Font("微软雅黑", Font.PLAIN, 17);	//设置弹出框的字体
	private Font font2 = new Font("微软雅黑", Font.PLAIN, 18);	//设置输入框的字体
	private BigDecimal num = new BigDecimal("0");	//表示总过的居民点个数
	private int[] x = new int[1000];
	private int[] y = new int[1000];
	private int resX;	//超市的横坐标
	private int resY;	//超市的纵坐标
	private int minLength = 0;	//求出最小长度
	private PaintPanel panel_3;
	
	/**	
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperMarket window = new SuperMarket();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SuperMarket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();	//创建一个大的框架
		frame.getContentPane().setBackground(Color.WHITE);	//设置大框架的背景颜色为白色
		frame.setBounds(100, 100, 700, 480);	//设置大框架的边界
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置大框架的默认退出方式
		frame.getContentPane().setLayout(new BorderLayout(0, 0));	//设置大的框架为边界式布局
		frame.setTitle("MaZhe的超市选址");	//设置标题
		frame.setResizable(false);	//设置不可改变大小
		JPanel panel = new JPanel();	//构造一个画板用来存放按钮的画板
		panel.setBackground(Color.WHITE);	//设置按钮的画板背景颜色为白色
		frame.getContentPane().add(panel, BorderLayout.WEST);	//将按钮的画板放在大画板西部
		panel.setLayout(new GridLayout(10, 1));	//设置按钮画板的布局为十行一列的网格式布局
		
		JLabel label = new JLabel("");	//构造一个空的标签,来创造空行
		label.setBackground(Color.WHITE);	//设置标签的背景颜色为白色
		panel.add(label);	//将空行加入到按钮画板中
		
		JLabel label_1 = new JLabel("");	
		label_1.setBackground(Color.WHITE);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.WHITE);
		panel.add(label_2);
		
		JButton button = new JButton("\u5F00\u59CB");	//构造按钮画板上的一个按钮,并添加文字
		button.addActionListener(new ActionListener() {	//给按钮添加一个点击事件
			public void actionPerformed(ActionEvent evt) {
				JDialog jd = new JDialog();	//构造一个弹出框
				jd.setBounds(330, 280, 300, 220);	//设置弹出框的大小
				jd.setTitle("超市选址");	//设置弹出框的标题
				jd.getContentPane().setLayout(new GridLayout(7, 1));	//设置为边界式布局
				
				jd.getContentPane().add(new JLabel(""));	//给弹出框加入一个空行
				JPanel tePan = new JPanel(new BorderLayout());	//给文字添加一个画板
				tePan.add(new JLabel("                "), BorderLayout.WEST);	//给文字画板添加一个空格
				JLabel label = new JLabel("请输入居民点个数:");	//添加文字
				label.setFont(font1);	//设置弹出框中的字体
				tePan.add(label,BorderLayout.CENTER);	//将文字添加到中部
				tePan.add(new JLabel("     "), BorderLayout.EAST);	//给文字画板添加一个空格
				jd.getContentPane().add(tePan);	//将文字画板添加到大的画板上
				
				jd.getContentPane().add(new JLabel(""));	//给大画板添加一个空行
				JPanel inPan = new JPanel(new BorderLayout());	//构造一个放输入框的画板,并将其布局设置为边界式布局
				inPan.add(new JLabel("                       "), BorderLayout.WEST);	//构造一个为空格的标签来调整输入框的位置
				JTextField text = new JTextField();
				text.setFont(font2);	//设置输入框的字体
				inPan.add(text,BorderLayout.CENTER);	//将输入框添加到画板的中部
				inPan.add(new JLabel("                       "), BorderLayout.EAST);
				jd.getContentPane().add(inPan);	//将画板放进大画板
				
				jd.getContentPane().add(new JLabel(""));
				JPanel buPan = new JPanel(new BorderLayout());
				buPan.add(new JLabel("                       "), BorderLayout.WEST);
				JButton bu = new JButton("确定");
				bu.addActionListener(new ActionListener() {	//为开始按钮增加点击事件
					@Override
					public void actionPerformed(ActionEvent e) {
						String textN = text.getText();
						if(!textN.equals("")) {	//当输入的不为空时开始
							num = new BigDecimal(textN);
							try {
								if(new BigDecimal(num.intValue()).compareTo(num)==0){	//判断输入的居民点是否为整数
									int count = num.intValue();
									for(int i = 0 ; i < count ; i++)
									{
											x[i] = new Random().nextInt(390) + 110;	//生成随机数
											y[i] = new Random().nextInt(370) - 10;
											System.out.println("生成的随机点为:" + x[i] + " " + y[i]);
									}
									solove();	//计算超市位置
									textField_2.setText("\u8D85\u5E02\u5750\u6807\u4E3A: ("+ resX + "," + resY + ")\u6700\u77ED\u8DDD\u79BB\u4E3A: " + minLength);	//将结果写到画板上
									panel_3.repaint();	//将画板重画
									jd.dispose();	//关闭弹窗
								}else{
									JOptionPane.showMessageDialog(null, "居民点个数必须为整数!", "错误", JOptionPane.WARNING_MESSAGE);	//如果输入的居民点不是整数弹窗提示
								}
							} catch (Exception e1) {
								
								JOptionPane.showMessageDialog(null, "居民点个数必须为整数!", "错误", JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "请输入居民点个数!", "错误", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				buPan.add(bu,BorderLayout.CENTER);
				buPan.add(new JLabel("                       "), BorderLayout.EAST);
				jd.getContentPane().add(buPan);
				
				jd.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);    
				jd.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);	//设置按钮的字体颜色
		button.setBackground(new Color(0,150,136));	//设置按钮字体的颜色
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));	//设置按钮的字体
		panel.add(button);
		
		JLabel label_3 = new JLabel("");	//添加空行
		label_3.setBackground(Color.WHITE);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");	//添加空行
		label_4.setBackground(Color.WHITE);
		panel.add(label_4);
		
		JButton button_1 = new JButton("\u9000\u51FA");	//退出按钮
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	//关闭框架
			}
		});
		button_1.setForeground(Color.WHITE);	//设置按钮的字体颜色为白色
		button_1.setBackground(new Color(255,87,34));	//设置按钮的背景颜色
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));	//设置按钮中文字的字体
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);	//设置新建画板的背景为白色
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);	//将新建的画板放在大画板的中间
		panel_1.setLayout(new BorderLayout(0, 0));	//新建一个画板用来存放除按钮之外的画板,并设置画板为边界式布局
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);	//设置字体颜色为白色
		panel_2.setBackground(Color.WHITE);	//设置背景颜色为白色
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(3,1));		//新建一个三行一列的网格式布局来存放下面的提示文字
		
		textField = new JTextField();
		textField.setDisabledTextColor(Color.BLACK);	//设置不可用的背景为白色
		textField.setEnabled(false);	//设置不可用
		textField.setBorder(BorderFactory.createEmptyBorder());	//设置文本框边界为透明
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField.setText("                                        \u7EA2\u8272\u661F\u53F7\u4EE3\u8868\u8D85\u5E02");
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);//设置文本框不可使用(即不可更改)
		textField_1.setBorder(BorderFactory.createEmptyBorder());	//将文本框的边界设置为空
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));	//设置文本框中的字体
		textField_1.setText("                                        \u9ED1\u8272\u661F\u53F7\u4EE3\u8868\u5C45\u6C11\u70B9");
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);	//设置文本框不可使用(即不可更改)
		textField_2.setDisabledTextColor(Color.BLACK);	
		textField_2.setBorder(BorderFactory.createEmptyBorder());	//将文本框的边界设置为空
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));	//设置文本框中的字体
		textField_2.setText("\u8D85\u5E02\u5750\u6807\u4E3A: (,)\t\u6700\u77ED\u8DDD\u79BB\u4E3A: ");
		panel_1.add(textField_2, BorderLayout.NORTH);	//将文本框添加到北面
		textField_2.setColumns(10);	//设置文本框占十列
		
		panel_3 = new PaintPanel();	//操作坐标系
		panel_3.setBackground(Color.WHITE);	//设置画板的背景颜色为白色
		panel_1.add(panel_3, BorderLayout.CENTER);	//将画板添加到中间
	}
	
	public void solove()	//用来计算出超市的位置
	{
		System.out.println("count = " + num.intValue());
		int[] tempX = new int[num.intValue()];
		int[] tempY = new int[num.intValue()];
	
		for(int i = 0 ; i < num.intValue() ; i++)
		{
			tempX[i] = x[i];
			tempY[i] = y[i];
		}
		
		Arrays.sort(tempX);	//对x坐标进行排序
		Arrays.sort(tempY);	//对y坐标进行排序
		
//		for(int i = 0 ; i < num.intValue() ; i++)
//		{
//			System.out.println("x = " + tempX[i] + "y = " + tempY[i]);
//		}
		
		if(num.intValue() % 2 != 0) {	//根据奇数偶数不同情况求出中位数
			resX = tempX[num.intValue() / 2];
			resY = tempY[num.intValue() / 2];
		} else {
			resX = (tempX[num.intValue() / 2] + tempX[num.intValue() / 2 + 1]) / 2;
			resY = (tempY[num.intValue() / 2] + tempY[num.intValue() / 2 + 1]) / 2;
		}
		for(int i = 0 ; i < num.intValue() ; i++)
		{
			minLength += (Math.abs((tempX[i] - resX)) + Math.abs((tempY[i] - resY)));	//求出最短的距离
		}
	}
	
	class PaintPanel extends JPanel
	{
	 //覆盖JPanel的paint方法
	//Graphics 是绘图的重要类，你可以把它理解为一直画笔
	public void paint(Graphics g)
	{
		//1，调用父类函数完成初始化
		//这句话不能少
		Graphics2D g2 = (Graphics2D)g;
		super.paint(g2);
		g2.setStroke( new BasicStroke(2));
		//画一条直线(x坐标)
		g2.drawLine(110,190,500,190);
		//在画一条直线(y坐标)
		g2.drawLine(305, 10, 305, 380);
		
		g2.setFont(new Font("微软雅黑",Font.PLAIN,25));
		
		if(!num.equals(new BigDecimal("0"))) {	//开始绘制图形
				for(int i = 0 ; i < num.intValue() ; i++)
				{
					g2.drawString("*", x[i], y[i]);
				}
				g2.setColor(Color.RED);
				g2.drawString("*", resX, resY);
			}
		}
	}
}
