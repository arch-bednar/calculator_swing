import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.lang.Math;

class JButtonAction extends JButton implements ActionListener{

    private String operation;
    private Calculator calculator;

    public JButtonAction(String operation, Calculator calc){
        super(operation);

        this.operation = operation;
        this.calculator = calc;
        this.addActionListener(this);
    }

    public String concat(String sign){
        return "";
    }

    public void sqrt(){
        calculator.result = String.valueOf(Math.sqrt(Double.parseDouble(calculator.field.getText())));
        calculator.field.setText(calculator.result);
        setState();
    }

    public void makeDouble(){
        if(! getNumber().contains(".")){
            calculator.field.setText(getNumber()+".");
        }
    }

    public void setOperation(char sign){
        setState(sign);
        //System.out.println("show state "+calculator.state);
        calculator.result = getNumber();
        setNumber();
    }

    public void calculate(){

        if(calculator.state != ' '){
            //System.out.println("state "+calculator.state);

            switch(calculator.state){
                case '+':
                    //System.out.println("state +"+state);
                    calculator.result = String.valueOf(Double.parseDouble(calculator.result) + Double.parseDouble(getNumber()));
                    //System.out.println("wynik +"+getNumber());
                    //System.out.println("dodawanie");
                    setNumber(calculator.result);
                    break;
                case '-':
                    calculator.result = String.valueOf(Double.parseDouble(calculator.result) - Double.parseDouble(getNumber()));
                    setNumber(calculator.result);
                    break;
                case '*':
                    calculator.result = String.valueOf(Double.parseDouble(calculator.result) * Double.parseDouble(getNumber()));
                    setNumber(calculator.result);
                    break;
                case '/':
                    calculator.result = String.valueOf(Double.parseDouble(calculator.result) / Double.parseDouble(getNumber()));
                    setNumber(calculator.result);
                    break;
                case '%':
                    calculator.result = String.valueOf(Double.parseDouble(calculator.result) * Double.parseDouble(getNumber())/100);
                    setNumber(calculator.result);
                    break;
                default:
                    //System.out.println("derfault");
                    break;
            }
            setState();
        }
    }

    private String getNumber(){
        return calculator.field.getText();
    }

    private void setNumber(){
        calculator.field.setText("");
    }

    private void setNumber(String number){
        calculator.field.setText(number);
    }

    private void setState(){
        calculator.state = 10;
    }

    private void setState(char state){
        calculator.state = state;
        //System.out.println("setState" + calculator.state);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(operation.equals(".")){
            makeDouble();
        }else if(operation.equals("sqrt")){
            try{
                sqrt();
            }catch(RuntimeException exception){
                calculator.field.setText("0.0");
            }
        }else if(operation.equals("+/-")){
            calculator.changeNegative();
        }else if(operation.equals("+")){
            setOperation('+');
        }else if(operation.equals("-")){
            setOperation('-');
        }else if(operation.equals("*")){
            setOperation('*');
        }else if(operation.equals("/")){
            setOperation('/');
        }else if(operation.equals("%")){
            setOperation('%');
        }else if(operation.equals("C")){
            calculator.clearState();
        }else if(operation.equals("CE")){
            calculator.clearField();
        }else if(operation.equals("=")){
            calculate();
        }
    }
}
