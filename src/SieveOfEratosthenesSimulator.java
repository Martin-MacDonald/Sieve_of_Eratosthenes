package com.martin_bolton_macdonald;
import com.martin_bolton_macdonald.PrimeCalc;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonModel;
import javax.swing.JList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SieveOfEratosthenesSimulator extends JFrame{
	
	private JScrollPane pane;
	
	public SieveOfEratosthenesSimulator(){
		
		initComponents();
		
	}
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			
			public void run(){
				new SieveOfEratosthenesSimulator().setVisible(true);
			}
			
		});
		
	}
	
	public void initComponents(){
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sieve Of Eratosthenes");
		
		JLabel lbl = new JLabel("Pick a number to find all the primes from 2 up to and including the selected number");
		lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new EmptyBorder(10,10,10,10));
		
		JComboBox<Integer> numberList = new JComboBox<>(createNumberList());
		numberList.setFont(new Font(Font.SERIF, 0, 25));
		
		DefaultListModel<String> primeListModel = new DefaultListModel<>();
		JList<String> primeList = new JList<>(primeListModel);
		primeList.setFont(new Font(Font.SERIF, 0, 25));
		pane = new JScrollPane(primeList);

		JButton calcBtn = new JButton("Find Primes");
		calcBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		calcBtn.setFont(new Font(Font.SERIF, 0, 25));
		ButtonModel calcBtnModel = calcBtn.getModel();
		calcBtnModel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				PrimeCalc pc = new PrimeCalc((int)numberList.getSelectedItem());
				getPrimeList(primeListModel, pc.getPrimeNumbersArray());				
				
			}
			
		});
		
		panel.add(lbl);
		panel.add(Box.createVerticalStrut(10));
		panel.add(numberList);
		panel.add(Box.createVerticalStrut(10));
		panel.add(calcBtn);
		panel.add(Box.createVerticalStrut(10));
		panel.add(pane);
		pane.setVisible(false);
		add(panel);
		pack();
		
	}
	
	public Integer[] createNumberList(){
		
		final Integer MAX_NUMBER = 10000;
		
		Integer[] numList = new Integer[MAX_NUMBER - 1];
		
		for (int i = 2; i <= MAX_NUMBER; i++){
			
			numList[i-2] = i;
			
		}
		
		return numList;
		
	}
	
	public void getPrimeList(DefaultListModel<String> primeListModel, List<String> primeNumbersArray){
		
		primeListModel.removeAllElements();
		
		for (String s : primeNumbersArray){
			primeListModel.addElement(s);
		}

		pane.setVisible(true);
		pack();
		
	}
		
	
}