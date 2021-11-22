import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;


public class JButtonNumber extends JButton implements ActionListener {

    private Calculator calc;
    private int number;

    public JButtonNumber(String number, Calculator calc){
        super(number);

        this.calc = calc;
        this.number = Integer.parseInt(number);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!calc.result.isEmpty() && calc.state == 10){
            calc.clearField();
            calc.field.setText(calc.field.getText()+number);
        }else if(calc.field.getText().equals("0")){
            calc.field.setText(Integer.toString(number));
        } else {
            calc.field.setText(calc.field.getText()+number);
        }
    }
}
