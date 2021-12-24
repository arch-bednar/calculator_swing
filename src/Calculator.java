import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;

public class Calculator extends JFrame {

    private GridBagConstraints constraints;
    private GridBagLayout bagLayout;
    private ContainerAction container;
    public JDisplay textField;

    //result of any operation (is like temp variable)
    protected String result;

    //state of operation, if there is one number and pressed any operation button then it stores state of operation (like substraction) and awaits for next number
    char state = 10;

    Calculator(String title){
        super(title);
        makeFrame();
        makeLayout();
        result="0";
    }

    //makes JFrame -> Calculator class properties
    public void makeFrame(){
        this.setSize(new Dimension(300, 300));
        this.setBackground(Color.GRAY);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(false);
    }

    //creates whole layout for JFrame like grid layout and container
    public void makeLayout(){
        constraints = new GridBagConstraints();
        bagLayout = new GridBagLayout();
        //container = this.getContentPane();
        container = new ContainerAction(this);
        container.setLayout(bagLayout);

        makeField(); //makes JTextField for calculator's results
        makeButtons();
        //container.setContainerListener(new ActionEvent);
        System.out.println("xDDDD");
    /*
        KeyListener key = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e + "siema");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e + "siema");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e + "siema");
            }
        };
        */
        container.setFocusable(true);
        container.requestFocusInWindow();

        container.setBackground(Color.LIGHT_GRAY);
        this.setContentPane(container);
    }

    //makes display for calculator
    public void makeField(){
        textField = new JDisplay(25);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.gridwidth = 5;
        //constraints.insets = new Insets(5,5,5,5);
        container.add(textField, constraints);
    }

    public void makeButtons(){ //makes Buttons
        makeNumbers();
        makeSigns();
    }

    //creates all number buttons
    public void makeNumbers(){

        int[][] numbers = { {7,8,9},
                            {4,5,6},
                            {1,2,3},
                            {0}};

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                JButtonNumber button = new JButtonNumber(Integer.toString(numbers[i][j]), this);

                constraints.gridx = 0 + j;
                constraints.gridy = 4 + i;
                constraints.gridheight = 1;
                constraints.gridwidth = 1;
                constraints.insets = new Insets(5,5,5,5);

                container.add(button, constraints);
            }
        }

        JButtonNumber button = new JButtonNumber(Integer.toString(numbers[3][0]), this);
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(button, constraints);
    }

    //creates all operation buttons
    public void makeSigns(){

        JButtonAction sign = new JButtonAction(".", this);
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("+/-", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("=", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 3;
        //constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("C", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("CE", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("%", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("sqrt", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("-", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("/", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("+", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButtonAction("*", this);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

    }

    public void changeNegative(){
        //System.out.println("inside" + result.length());
        if(textField.getText().length() > 0){

            if(textField.getText().substring(0,1).equals("-")){
                textField.setText(textField.getText().substring(1));
            }else{
                textField.setText("-" + textField.getText());
            }

            System.out.println(result);
        }
    }

    public void clearState(){
        result="0";
        textField.setText(result);
        state=10;
    }

    public void clearField(){
        textField.setText("0");
    }

    //take number from display
    public String getText(){
        return textField.getText();
    }

    //set number in display to default = 0
    public void setText(){
        textField.setText("0");
    }

    //set number in display
    public void setText(String newString){
        textField.setText(newString);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
           public void run(){
                Calculator calc = new Calculator("Calculator Swing");
           }
        });
    }
}
