import java.awt.EventQueue;

import javax.swing.text.JTextComponent;

public class Test {

	// static void fix(String s) {
	// String t = s;
	// t = t.trim();
	// t = t.replace(' ', '_');
	// s = t;
	// }
	//
	// public static void main(String args[]) {
	// String x = "> This is a test <";
	// fix(x);
	// System.out.println(x);
	// }

	public void setTheTextBox(JTextComponent cmp, String a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				cmp.setText(a);
			}
		});
	}

}
