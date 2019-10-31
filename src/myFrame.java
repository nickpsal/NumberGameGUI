import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myFrame extends JFrame{
	private static final long serialVersionUID = 2L;
	
	private int rnd;
	private int counter=1;
	
	private JPanel panel;
	private JLabel labelInput;
	private JTextField numberInput;
	private JButton buttonNumber;
	private JButton buttonInfo;
	
	public myFrame() {
		
		Random rd = new Random();
		rnd = rd.nextInt(2000);	
		
		panel = new JPanel();
		
		labelInput = new JLabel();
		labelInput.setText("Δώστε ένα νούμερο απο το  1 εως το 2000");
		numberInput = new JTextField(35);
		buttonNumber = new JButton("Έλεγχος Νούμερου");
		buttonInfo = new JButton("Πληροφορίες");
		
		panel.add(labelInput);
		panel.add(numberInput);
		panel.add(buttonNumber);
		panel.add(buttonInfo);
				
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		buttonNumber.addActionListener(listener);
		buttonInfo.addActionListener(listener);
						
		this.setVisible(true);
		this.setSize(450,450);
		this.setTitle("Παίχνιδι με Νούμερα!!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonNumber) {
				int minima = Integer.parseInt(numberInput.getText());
				if ((minima <=0) || (minima >2000)) {
					JOptionPane.showMessageDialog(panel, "Ο Αριθμός είναι εκτός ορίων. Δώσε ένα νούμερο απο το 1 εως το 2000",
							"ΣΦΑΛΜΑ", JOptionPane.INFORMATION_MESSAGE);
					numberInput.setText(null);
				}else if (rnd > minima) {
					JOptionPane.showMessageDialog(panel, "Ο αριθμός σου είναι μικρότερος απο του Υπολογιστή",
							"ΠΛΗΡΟΦΟΡΙΑ", JOptionPane.INFORMATION_MESSAGE);
					numberInput.setText(null);
					counter++;
				}else if (rnd < minima) {
					JOptionPane.showMessageDialog(panel, "Ο αριθμός σου είναι μεγαλύτερος απο του Υπολογιστή",
							"ΠΛΗΡΟΦΟΡΙΑ", JOptionPane.INFORMATION_MESSAGE);
					numberInput.setText(null);
					counter++;
				}else {
					JOptionPane.showMessageDialog(panel, "ΣΥΓΧΑΡΗΤΗΡΙΑ ΤΟΝ ΒΡΗΚΕΣ ΜΕ " + counter + " ΑΠΟΠΕΙΡΕΣ",
							"ΝΙΚΗΣΕΣ", JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(panel, "Προγραμματιστης : Ψαλτακης Νικολαος StormRideR "
						+ "(c)2019 \nΟ Υπολογιστής μαντεύει εναν αριθμό απο το 1 εως το 2000 και ο χρήστης προσπαθεί να τον μαντέψει.",
						"ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}