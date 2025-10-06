import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class calculator {
    int bordWidth=360;
    int bordHeight=540;

    Color custumLightGray=new Color(204,204,204);
    Color custumGrey=new Color(153,153,153);
    Color custumDarkGray=new Color(102,102,102);
    Color customVeryDarkGray= new Color(51,51,51);


    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame= new JFrame("HEY!");
    JLabel displayLabel= new JLabel();
    JPanel displayPanel= new JPanel();
    JPanel buttonsPanel= new JPanel();
    String A="0";
    String operator=null;
    String B= null;

        calculator() {
//            this.frame.setVisible(true);
            this.frame.setSize(this.bordWidth, this.bordHeight);
            this.frame.setLocationRelativeTo((Component)null);
            this.frame.setResizable(false);
            this.frame.setDefaultCloseOperation(3);
            this.frame.setLayout(new BorderLayout());
            this.displayLabel.setBackground(this.custumLightGray);
            this.displayLabel.setForeground(Color.white);
            this.displayLabel.setFont(new Font("Arial", 0, 80));
            this.displayLabel.setHorizontalAlignment(4);
            this.displayLabel.setText("HEY!");
            this.displayLabel.setOpaque(true);
            this.displayPanel.setLayout(new BorderLayout());
            this.displayPanel.add(this.displayLabel);
            this.frame.add(this.displayPanel, "North");
            this.buttonsPanel.setLayout(new GridLayout(5, 4));
            this.buttonsPanel.setBackground(this.custumGrey);
            this.frame.add(this.buttonsPanel);

            for(int i = 0; i < this.buttonValues.length; ++i) {
                JButton button = new JButton();
                String buttonValue = this.buttonValues[i];
                button.setFont(new Font("Arial", 0, 30));
                button.setFocusable(false);
                button.setText(buttonValue);
                this.buttonsPanel.add(button);
                button.setBorder(new LineBorder(this.customVeryDarkGray));
                if (Arrays.asList(this.topSymbols).contains(buttonValue)) {
                    button.setBackground(this.custumGrey);
                    button.setForeground(this.custumDarkGray);
                } else if (Arrays.asList(this.rightSymbols).contains(buttonValue)) {
                    button.setBackground(this.customVeryDarkGray);
                    button.setForeground(Color.white);
                } else {
                    button.setBackground(Color.black);
                    button.setForeground(Color.white);
                }
                this.buttonsPanel.add(button);
                button.addActionListener (new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JButton button = (JButton) e.getSource();
                        String buttonValue = button.getText();
                        if (buttonValue.equals("=")){
                            if(A !=null){
                                B=displayLabel.getText();
                                double numA=Double.parseDouble(A);
                                double numB=Double.parseDouble(B);

                            if(operator.equals("+")) {

                                displayLabel.setText(removeZeroDecimal(numA + numB));
                            }
                            else if (operator.equals("-")){
                                    displayLabel.setText(removeZeroDecimal(numA - numB));
                                }
                            else if(operator.equals("×")){
                                displayLabel.setText(removeZeroDecimal(numA * numB));

                            }
                            else if (operator.equals("÷")){
                                displayLabel.setText(removeZeroDecimal(numA / numB));
                            }
                            clearAll();
                            }
                        }
                        else if ("+-×÷".contains(buttonValue)){
                            if (operator==null){
                               A= displayLabel.getText();
                                displayLabel.setText("0");
                                B="0";
                            }
                            operator=buttonValue;
                        }
                        else if (buttonValue.equals( "AC")) {
                                clearAll();
                                displayLabel.setText("0");
                            }

                            else if (buttonValue.equals("+/-")){
                                double numDisplay=Double.parseDouble(displayLabel.getText());
                                numDisplay *= -1;
                                displayLabel.setText(removeZeroDecimal(numDisplay));
                            }
                        else if (buttonValue.equals("%")){
                            double numDisplay=Double.parseDouble(displayLabel.getText());
                            numDisplay /=100 ;
                            displayLabel.setText(removeZeroDecimal(numDisplay));

                        }
                        else if (Arrays.asList(topSymbols).contains(buttonValue)){
                            if (buttonValue.equals("AC")){
                                clearAll();
                                displayLabel.setText("0");


                            }
                        }
                        else if (buttonValue.equals("√")){
                            double num = Double.parseDouble(displayLabel.getText());
                            displayLabel.setText(removeZeroDecimal(Math.sqrt(num)));
                        }
                        else{
                            if(buttonValue=="."){
                                if(!displayLabel.getText().contains(buttonValue)){
                                    displayLabel.setText(displayLabel.getText()+buttonValue);
                                }
                            }
                            else if("0123456789".contains(buttonValue)){
                                if(displayLabel.getText().equals("0") || displayLabel.getText().equals("HEY!")){
                                    displayLabel.setText(buttonValue);
                                } else {
                                    displayLabel.setText(displayLabel.getText() + buttonValue);
                                }
                            }

                        }
                    }

                });
                this.frame.setVisible(true);
            }
    }
    void clearAll(){
        A="0";
        operator=null;
        B=null;
    }
String removeZeroDecimal(double numDisplay){
            if(numDisplay %1==0){
                return Integer.toString((int) numDisplay);
            }
            return Double.toString(numDisplay);
}
}



