package src.Model;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton)
        {
            JButton button = (JButton) source;
            try{
                String str = button.getText();
                Component component = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                if(component instanceof JTextComponent)
                {
                    JTextComponent textComponent = (JTextComponent) component;
                    if(str.equals("DEL") && !textComponent.getText().isEmpty())
                        textComponent.setText(textComponent.getText().substring(0,textComponent.getText().length() - 1));
                    else
                        if(!str.equals("DEL"))
                        {
                            textComponent.setText(textComponent.getText() + str);
                        }
                }
            }
            catch (Exception a)
            {
                System.out.println("no text component");
            }
        }
    }
}
