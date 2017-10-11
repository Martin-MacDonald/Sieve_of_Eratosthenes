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

public class SieveOfEratosthenesSimulator extends JFrame{
	
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
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JComboBox<Integer> numberList = new JComboBox<>(createNumberList());

		JButton calcBtn = new JButton("Find Primes");
		ButtonModel calcBtnModel = calcBtn.getModel();
		calcBtnModel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				PrimeCalc pc = new PrimeCalc((int)numberList.getSelectedItem());
		
				System.out.println(pc.getPrimeNumbersArray());				
				
			}
			
		});

		panel.add(numberList);
		panel.add(calcBtn);
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
	
}