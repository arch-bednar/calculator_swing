import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDisplay extends JTextField implements ActionListener{

    /*
        class JDisplay based on JTextField
     */


    JDisplay(int columns){
        super(columns);         //calls inherited constructor
        setEditable(false);     //edition in display is disabled
        setFocusable(false);
        setText("0");           //set 0 as main value
        setListener();          //set listener
    }

    private void setListener(){
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        setFocusable(false);
    } //prevent focusing on Display
}
