package Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import asciiPanel.AsciiPanel;

public interface Screen {
	public Screen respondToUserInput(KeyEvent key);
	public void displayOutput(AsciiPanel terminal);
}
