import java.awt.event.KeyEvent;
import java.awt.Container;
import java.awt.event.KeyAdapter;

public class ContainerAction extends Container{

    Calculator calculator;

    ContainerAction(Calculator calculator){
        super();
        this.calculator = calculator;
        this.addKeyListener(setEvent());
    }

    //instead implementing interface KeyListener i used KeyAdapter
    private KeyAdapter setEvent(){

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

        KeyAdapter adapter = new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent event){
                String sign = "";

                if(event.getKeyCode() == KeyEvent.VK_MINUS){
                    calculator.changeNegative();
                }else if(event.getKeyCode() == KeyEvent.VK_PERIOD) {
                    if (!isDot()) {
                        setDot();
                    }
                }else if(event.getKeyCode() == KeyEvent.VK_ENTER){
                    if(calculator.state != 10){
                        calculate();
                    }
                }else if(event.getKeyCode() == KeyEvent.VK_P){
                    setOperation('%');
                }else if(event.getKeyCode() == KeyEvent.VK_Q){
                    sqrt();
                }else if(event.getKeyCode() == KeyEvent.VK_M){
                    setOperation('*');
                }else if(event.getKeyCode() == KeyEvent.VK_E){
                    calculator.clearField();
                }else if(event.getKeyCode() == KeyEvent.VK_D){
                    setOperation('/');
                }else if(event.getKeyCode() == KeyEvent.VK_C){
                    calculator.clearState();
                }else if(event.getKeyCode() == KeyEvent.VK_A){
                    setOperation('+');
                }else if(event.getKeyCode() == KeyEvent.VK_S){
                    setOperation('-');
                }else{
                    if(event.getKeyCode() == KeyEvent.VK_1 || event.getKeyCode() == KeyEvent.VK_NUMPAD1){
                        sign="1";
                    }else if(event.getKeyCode() == KeyEvent.VK_2 || event.getKeyCode() == KeyEvent.VK_NUMPAD2){
                        sign="2";
                    }else if(event.getKeyCode() == KeyEvent.VK_3 || event.getKeyCode() == KeyEvent.VK_NUMPAD3){
                        sign="3";
                    }else if(event.getKeyCode() == KeyEvent.VK_4 || event.getKeyCode() == KeyEvent.VK_NUMPAD4){
                        sign="4";
                    }else if(event.getKeyCode() == KeyEvent.VK_5 || event.getKeyCode() == KeyEvent.VK_NUMPAD5){
                        sign="5";
                    }else if(event.getKeyCode() == KeyEvent.VK_6 || event.getKeyCode() == KeyEvent.VK_NUMPAD6){
                        sign="6";
                    }else if(event.getKeyCode() == KeyEvent.VK_7 || event.getKeyCode() == KeyEvent.VK_NUMPAD7){
                        sign="7";
                    }else if(event.getKeyCode() == KeyEvent.VK_8 || event.getKeyCode() == KeyEvent.VK_NUMPAD8){
                        sign="8";
                    }else if(event.getKeyCode() == KeyEvent.VK_9 || event.getKeyCode() == KeyEvent.VK_NUMPAD9){
                        sign="9";
                    }else if(event.getKeyCode() == KeyEvent.VK_0 || event.getKeyCode() == KeyEvent.VK_NUMPAD0){
                        sign="0";
                    }
                    if(calculator.getText().equals("0")){
                        calculator.setText(sign);
                    }else if(calculator.getText().equals("-0")){
                        calculator.setText("-" + sign);
                    }else{
                        calculator.setText(calculator.getText()+sign);
                    }
                }
            }
        };
        return adapter;
    }
    
    /*
    IMPORTY ABY TO UŻYĆ

    import javafx.scene.input.KeyCode;
    import javax.swing.JPanel;
    import java.awt.event.KeyListener;

    @Override
    public void keyPressed(KeyEvent event){
        if(event.getKeyEvent() == KeyEvent.VK_0 || event.getKeyCode() == KeyEvent.VK_NUMPAD0){
            System.out.println("huehuehue");
        }
    }

    @Override
    public void keyTyped(KeyEvent event){}

    @Override
    public void keyReleased(KeyEvent event){}
    */
    
    private void calculate(){
        if(calculator.state != 10){
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

    private boolean isDot(){
        return calculator.getText().contains(".");
    }

    private void setDot(){
        calculator.setText(calculator.getText() + ".");
    }

    public String getNumber(){
        return calculator.getText();
    }

    public void setNumber(String number){
        calculator.setText(number);
    }

    public void setNumber(){
        calculator.setText();
    }

    public void setState(){
        calculator.state = 10;
    }

    public void setState(char state){
        calculator.state = state;
    }

    public void sqrt(){
        calculator.result = String.valueOf(Math.sqrt(Double.parseDouble(calculator.getText())));
        calculator.setText(calculator.result);
        setState();
    }

    public void setOperation(char sign){
        setState(sign);
        calculator.result=getNumber();
        setNumber();
    }

}
