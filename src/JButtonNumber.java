import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class JButtonNumber extends JButton implements ActionListener {
    /*
          JButtonNumber inherits after JButton and implements it's own listener
     */

    private Calculator calc;
    private int number;
    private String num;

    public JButtonNumber(String number, Calculator calc){ //number - value for current button, calc - for easy access to variables of calculator
        super(number);
        setFocusable(false);    //prevents focusing on that button
        this.calc = calc;
        this.number = Integer.parseInt(number);
        this.num = number;
        this.addActionListener(this);   //create listener
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setFocusable(false);    //prevents focusing on that button

        //set number in display
        if(calc.getText().equals("0")){
            calc.setText(num);
        }else if(calc.getText().equals("-0")){
            calc.setText("-" + num);
        }else{
            calc.setText(calc.getText() + num);
        }
    }
}
