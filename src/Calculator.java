import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Container;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Calculator extends JFrame {

    private GridBagConstraints constraints;
    private GridBagLayout bagLayout;
    private Container container;
    public JTextField field;
    History history;
    String result;
    char state = 10;

    Calculator(String title){
        super(title);
        makeFrame();
        makeLayout();
        result="";
    }

    public void makeFrame(){
        this.setSize(new Dimension(300, 300));
        this.setBackground(Color.GRAY);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
    }

    public void makeLayout(){
        constraints = new GridBagConstraints();
        bagLayout = new GridBagLayout();
        container = this.getContentPane();
        container.setLayout(bagLayout);

        //makeHistory();
        makeField();
        makeButtons();

        container.setBackground(Color.LIGHT_GRAY);
    }

    public void makeHistory(){
        //history = new JLabel();
        history = new History();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        //constraints.ipady = 5;
        //constraints.gridheight = 2;
        constraints.insets = new Insets(5,5,5,5);
        container.add(history, constraints);
    }

    public class History extends JPanel implements MouseListener {

        JLabel display;
        ArrayList<Double> argFirst = new ArrayList<Double>();
        ArrayList<Character> sign = new ArrayList<Character>();
        ArrayList<Double> argSec = new ArrayList<Double>();

        History(){
            //this.setSize(new Dimension(100, 100));
            this.setBackground(Color.RED);
            display = new JLabel("");
            this.add(display);
            this.addMouseListener(this);
        }

        public void setOperation(String string){
            display.setText(string);
        }

        public void addOperation(String operation){
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public void makeField(){
        field = new JTextField(25);
        //field.addActionListener(this);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.gridwidth = 5;
        //constraints.insets = new Insets(5,5,5,5);
        container.add(field, constraints);
    }

    public void makeButtons(){
        makeNumbers();
        makeSigns();
    }

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
/*
                button.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent event){

                    }
                });
*/
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
        if(field.getText().length() > 0){

            if(field.getText().substring(0,1).equals("-")){
                field.setText(field.getText().substring(1));
            }else{
                field.setText("-" + field.getText());
            }

            System.out.println(result);
        }
    }

    public void clearState(){
        result="";
        field.setText(result);
        state=10;
    }

    public void clearField(){
        field.setText("");
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
           public void run(){
                Calculator calc = new Calculator("Calculator Swing");
           }
        });
    }
}
