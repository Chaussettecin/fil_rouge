package Control;

import java.util.List;



public class ChatBox implements UI.Subject {

	@Override
	public void addObserver(UI.Observer o) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	private Observer observer;
	private ChatTree chat;
	private int counter = 0;
	private List<String> flow;

	public void receive(String answerkey) {
		
		System.out.println(counter);
		
		if (counter>flow.size()) {
			this.chat.nextNode(answerkey);
			this.flow = this.chat.getNextFlow();
			this.counter = 0;
		
		} this.observer.update();
	}

	public String[] extract() {
		System.out.println(counter);
		String[] res;
		if (counter<flow.size()) {
			res = new String[] {flow.get(counter)};
		} else {
			res = this.chat.getNextChoice();
		}
		counter += 1;
		return res;
	}
	
	public void terminate() {
		this.counter = 0;
		this.chat.rewind();
		this.chat = null;
		this.flow = null;
	}
	
	public void upload(ChatTree chat) {
		this.chat = chat;
		this.flow = chat.getNextFlow();
		this.observer.update();
	}

	@Override
	public void addObserver(ui.Observer o) {
		this.observer = o;
		
	}
	
	*/
}
