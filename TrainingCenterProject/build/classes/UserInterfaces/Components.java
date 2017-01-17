package UserInterfaces;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Components 
{
	
	public JTextField CreateTextField(int Size , boolean Editable )
	{
		JTextField tf = new JTextField();
		tf.setColumns(Size);
		tf.setEditable(Editable);
		
		return tf;
	}
	
	public JLabel CreateLabel(String text)
	{
		JLabel l = new JLabel();
		l.setText(text);
		l.setSize(10, 15);
		return l;
	}
	
	public JPasswordField CreatePasswordField(int Size , boolean Editable )
	{
		JPasswordField tf = new JPasswordField();
		tf.setColumns(Size);
		tf.setEditable(Editable);
		
		return tf;
	}
	
	public JButton CreateButton(String Text)
	{
		return new JButton(Text);
	}

}
