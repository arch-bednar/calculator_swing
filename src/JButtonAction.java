import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.lang.Math;

class JButtonAction extends JButton implements ActionListener{
    /*
        JButtonAction based on JButton
        button for operations
     */

    private String operation;       //operation - property of button
    private Calculator calculator;

    public JButtonAction(String operation, Calculator calc){
        super(operation);
        setFocusable(false);
        this.operation = operation;
        this.calculator = calc;
        this.addActionListener(this);
    }

    //listener
    @Override
    public void actionPerformed(ActionEvent e) {

        /*
        if operation = '.' then make double
        else if operation = '+/-' then change sign for plus/minus of number -> changeNegative function
        else if oepration = '+' then add two numbers
        else if operation = '-' then subtract two numbers
        else if operation = '*' then multiply two numbers
        else if operation = '/' then divide two numbers
        else if operation = '%' then calculate percent of number
        else if operation = 'CE' then clear field
        else if operation = 'C' then clear field with state
        else if opertaion = '=' then calculate operation
         */

        setFocusable(false);

        if(operation.equals(".")){
            makeDouble();
        }else if(operation.equals("sqrt")){
            calculator.setOperation('q');
            try{
                //sqrt();
                calculator.calculate();
            }catch(RuntimeException exception){
                calculator.textField.setText("0.0");
            }
        }else if(operation.equals("+/-")){
            calculator.changeNegative();
        }else if(operation.equals("+")){
            calculator.setOperation('+');
        }else if(operation.equals("-")){
            calculator.setOperation('-');
        }else if(operation.equals("*")){
            calculator.setOperation('*');
        }else if(operation.equals("/")){
            calculator.setOperation('/');
        }else if(operation.equals("%")){
            calculator.setOperation('%');
        }else if(operation.equals("C")){
            calculator.clearState();
        }else if(operation.equals("CE")){
            calculator.clearField();
        }else if(operation.equals("=")){
            calculator.calculate();
        }
    }

    //makes double from number in display
    public void makeDouble(){
        if(! calculator.getNumber().contains(".")){
            calculator.textField.setText(calculator.getNumber()+".");
        }
    }
}
