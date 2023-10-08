import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditRiskAssessmentGUI extends JFrame {

    private JTextField creditScoreField;
    private JTextArea resultArea;

    private static double[][] transitionMatrix = {
            {0.95, 0.03, 0.02},
            {0.02, 0.93, 0.05},
            {0.01, 0.04, 0.95}
    };

    public CreditRiskAssessmentGUI(){
        setTitle("Credit Risk Assessment");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel panel = new JPanel();
        creditScoreField = new JTextField(10);
        JButton calculateButton = new JButton("calculate");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePD();
            }
        });

        panel.add(new JLabel("Enter Credit Score: "));
        panel.add(creditScoreField);
        panel.add(calculateButton);
        panel.add(new JLabel("Result: "));
        panel.add(new JScrollPane(resultArea));

        add(panel);
    }

    private void calculatePD(){
        try {
            int creditScore = Integer.parseInt(creditScoreField.getText());
            double pd = calculatePD(creditScore);
            resultArea.setText("Credit Score: " + creditScore + "\nProbability of Default (PD): " + pd);
        }catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter a valid credit score.");
        }
    }

    private double calculatePD(int creditScore) {
        int matrixIndex = getMatrixIndex(creditScore);
        return transitionMatrix[matrixIndex][matrixIndex];
    }

    private int getMatrixIndex(int creditScore){
        if (creditScore < 600) {
            return 0;
        } else if (creditScore < 700) {
            return 1;
        } else {
            return 2;
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreditRiskAssessmentGUI();
            }
        });
        int result = Recursion.sum(5, 10);
        System.out.println(result);
    }
}
