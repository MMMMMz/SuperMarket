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
	private Font font1 = new Font("΢���ź�", Font.PLAIN, 17);	//���õ����������
	private Font font2 = new Font("΢���ź�", Font.PLAIN, 18);	//��������������
	private BigDecimal num = new BigDecimal("0");	//��ʾ�ܹ��ľ�������
	private int[] x = new int[1000];
	private int[] y = new int[1000];
	private int resX;	//���еĺ�����
	private int resY;	//���е�������
	private int minLength = 0;	//�����С����
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
		frame = new JFrame();	//����һ����Ŀ��
		frame.getContentPane().setBackground(Color.WHITE);	//���ô��ܵı�����ɫΪ��ɫ
		frame.setBounds(100, 100, 700, 480);	//���ô��ܵı߽�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���ô��ܵ�Ĭ���˳���ʽ
		frame.getContentPane().setLayout(new BorderLayout(0, 0));	//���ô�Ŀ��Ϊ�߽�ʽ����
		frame.setTitle("MaZhe�ĳ���ѡַ");	//���ñ���
		frame.setResizable(false);	//���ò��ɸı��С
		JPanel panel = new JPanel();	//����һ������������Ű�ť�Ļ���
		panel.setBackground(Color.WHITE);	//���ð�ť�Ļ��屳����ɫΪ��ɫ
		frame.getContentPane().add(panel, BorderLayout.WEST);	//����ť�Ļ�����ڴ󻭰�����
		panel.setLayout(new GridLayout(10, 1));	//���ð�ť����Ĳ���Ϊʮ��һ�е�����ʽ����
		
		JLabel label = new JLabel("");	//����һ���յı�ǩ,���������
		label.setBackground(Color.WHITE);	//���ñ�ǩ�ı�����ɫΪ��ɫ
		panel.add(label);	//�����м��뵽��ť������
		
		JLabel label_1 = new JLabel("");	
		label_1.setBackground(Color.WHITE);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.WHITE);
		panel.add(label_2);
		
		JButton button = new JButton("\u5F00\u59CB");	//���찴ť�����ϵ�һ����ť,���������
		button.addActionListener(new ActionListener() {	//����ť���һ������¼�
			public void actionPerformed(ActionEvent evt) {
				JDialog jd = new JDialog();	//����һ��������
				jd.setBounds(330, 280, 300, 220);	//���õ�����Ĵ�С
				jd.setTitle("����ѡַ");	//���õ�����ı���
				jd.getContentPane().setLayout(new GridLayout(7, 1));	//����Ϊ�߽�ʽ����
				
				jd.getContentPane().add(new JLabel(""));	//�����������һ������
				JPanel tePan = new JPanel(new BorderLayout());	//���������һ������
				tePan.add(new JLabel("                "), BorderLayout.WEST);	//�����ֻ������һ���ո�
				JLabel label = new JLabel("�������������:");	//�������
				label.setFont(font1);	//���õ������е�����
				tePan.add(label,BorderLayout.CENTER);	//��������ӵ��в�
				tePan.add(new JLabel("     "), BorderLayout.EAST);	//�����ֻ������һ���ո�
				jd.getContentPane().add(tePan);	//�����ֻ�����ӵ���Ļ�����
				
				jd.getContentPane().add(new JLabel(""));	//���󻭰����һ������
				JPanel inPan = new JPanel(new BorderLayout());	//����һ���������Ļ���,�����䲼������Ϊ�߽�ʽ����
				inPan.add(new JLabel("                       "), BorderLayout.WEST);	//����һ��Ϊ�ո�ı�ǩ������������λ��
				JTextField text = new JTextField();
				text.setFont(font2);	//��������������
				inPan.add(text,BorderLayout.CENTER);	//���������ӵ�������в�
				inPan.add(new JLabel("                       "), BorderLayout.EAST);
				jd.getContentPane().add(inPan);	//������Ž��󻭰�
				
				jd.getContentPane().add(new JLabel(""));
				JPanel buPan = new JPanel(new BorderLayout());
				buPan.add(new JLabel("                       "), BorderLayout.WEST);
				JButton bu = new JButton("ȷ��");
				bu.addActionListener(new ActionListener() {	//Ϊ��ʼ��ť���ӵ���¼�
					@Override
					public void actionPerformed(ActionEvent e) {
						String textN = text.getText();
						if(!textN.equals("")) {	//������Ĳ�Ϊ��ʱ��ʼ
							num = new BigDecimal(textN);
							try {
								if(new BigDecimal(num.intValue()).compareTo(num)==0){	//�ж�����ľ�����Ƿ�Ϊ����
									int count = num.intValue();
									for(int i = 0 ; i < count ; i++)
									{
											x[i] = new Random().nextInt(390) + 110;	//���������
											y[i] = new Random().nextInt(370) - 10;
											System.out.println("���ɵ������Ϊ:" + x[i] + " " + y[i]);
									}
									solove();	//���㳬��λ��
									textField_2.setText("\u8D85\u5E02\u5750\u6807\u4E3A: ("+ resX + "," + resY + ")\u6700\u77ED\u8DDD\u79BB\u4E3A: " + minLength);	//�����д��������
									panel_3.repaint();	//�������ػ�
									jd.dispose();	//�رյ���
								}else{
									JOptionPane.showMessageDialog(null, "������������Ϊ����!", "����", JOptionPane.WARNING_MESSAGE);	//�������ľ���㲻������������ʾ
								}
							} catch (Exception e1) {
								
								JOptionPane.showMessageDialog(null, "������������Ϊ����!", "����", JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�������������!", "����", JOptionPane.WARNING_MESSAGE);
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
		button.setForeground(Color.WHITE);	//���ð�ť��������ɫ
		button.setBackground(new Color(0,150,136));	//���ð�ť�������ɫ
		button.setFont(new Font("΢���ź�", Font.PLAIN, 18));	//���ð�ť������
		panel.add(button);
		
		JLabel label_3 = new JLabel("");	//��ӿ���
		label_3.setBackground(Color.WHITE);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");	//��ӿ���
		label_4.setBackground(Color.WHITE);
		panel.add(label_4);
		
		JButton button_1 = new JButton("\u9000\u51FA");	//�˳���ť
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	//�رտ��
			}
		});
		button_1.setForeground(Color.WHITE);	//���ð�ť��������ɫΪ��ɫ
		button_1.setBackground(new Color(255,87,34));	//���ð�ť�ı�����ɫ
		button_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));	//���ð�ť�����ֵ�����
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);	//�����½�����ı���Ϊ��ɫ
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);	//���½��Ļ�����ڴ󻭰���м�
		panel_1.setLayout(new BorderLayout(0, 0));	//�½�һ������������ų���ť֮��Ļ���,�����û���Ϊ�߽�ʽ����
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);	//����������ɫΪ��ɫ
		panel_2.setBackground(Color.WHITE);	//���ñ�����ɫΪ��ɫ
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(3,1));		//�½�һ������һ�е�����ʽ����������������ʾ����
		
		textField = new JTextField();
		textField.setDisabledTextColor(Color.BLACK);	//���ò����õı���Ϊ��ɫ
		textField.setEnabled(false);	//���ò�����
		textField.setBorder(BorderFactory.createEmptyBorder());	//�����ı���߽�Ϊ͸��
		textField.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		textField.setText("                                        \u7EA2\u8272\u661F\u53F7\u4EE3\u8868\u8D85\u5E02");
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);//�����ı��򲻿�ʹ��(�����ɸ���)
		textField_1.setBorder(BorderFactory.createEmptyBorder());	//���ı���ı߽�����Ϊ��
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setFont(new Font("΢���ź�", Font.PLAIN, 17));	//�����ı����е�����
		textField_1.setText("                                        \u9ED1\u8272\u661F\u53F7\u4EE3\u8868\u5C45\u6C11\u70B9");
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);	//�����ı��򲻿�ʹ��(�����ɸ���)
		textField_2.setDisabledTextColor(Color.BLACK);	
		textField_2.setBorder(BorderFactory.createEmptyBorder());	//���ı���ı߽�����Ϊ��
		textField_2.setFont(new Font("΢���ź�", Font.PLAIN, 18));	//�����ı����е�����
		textField_2.setText("\u8D85\u5E02\u5750\u6807\u4E3A: (,)\t\u6700\u77ED\u8DDD\u79BB\u4E3A: ");
		panel_1.add(textField_2, BorderLayout.NORTH);	//���ı�����ӵ�����
		textField_2.setColumns(10);	//�����ı���ռʮ��
		
		panel_3 = new PaintPanel();	//��������ϵ
		panel_3.setBackground(Color.WHITE);	//���û���ı�����ɫΪ��ɫ
		panel_1.add(panel_3, BorderLayout.CENTER);	//��������ӵ��м�
	}
	
	public void solove()	//������������е�λ��
	{
		System.out.println("count = " + num.intValue());
		int[] tempX = new int[num.intValue()];
		int[] tempY = new int[num.intValue()];
	
		for(int i = 0 ; i < num.intValue() ; i++)
		{
			tempX[i] = x[i];
			tempY[i] = y[i];
		}
		
		Arrays.sort(tempX);	//��x�����������
		Arrays.sort(tempY);	//��y�����������
		
//		for(int i = 0 ; i < num.intValue() ; i++)
//		{
//			System.out.println("x = " + tempX[i] + "y = " + tempY[i]);
//		}
		
		if(num.intValue() % 2 != 0) {	//��������ż����ͬ��������λ��
			resX = tempX[num.intValue() / 2];
			resY = tempY[num.intValue() / 2];
		} else {
			resX = (tempX[num.intValue() / 2] + tempX[num.intValue() / 2 + 1]) / 2;
			resY = (tempY[num.intValue() / 2] + tempY[num.intValue() / 2 + 1]) / 2;
		}
		for(int i = 0 ; i < num.intValue() ; i++)
		{
			minLength += (Math.abs((tempX[i] - resX)) + Math.abs((tempY[i] - resY)));	//�����̵ľ���
		}
	}
	
	class PaintPanel extends JPanel
	{
	 //����JPanel��paint����
	//Graphics �ǻ�ͼ����Ҫ�࣬����԰������Ϊһֱ����
	public void paint(Graphics g)
	{
		//1�����ø��ຯ����ɳ�ʼ��
		//��仰������
		Graphics2D g2 = (Graphics2D)g;
		super.paint(g2);
		g2.setStroke( new BasicStroke(2));
		//��һ��ֱ��(x����)
		g2.drawLine(110,190,500,190);
		//�ڻ�һ��ֱ��(y����)
		g2.drawLine(305, 10, 305, 380);
		
		g2.setFont(new Font("΢���ź�",Font.PLAIN,25));
		
		if(!num.equals(new BigDecimal("0"))) {	//��ʼ����ͼ��
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
