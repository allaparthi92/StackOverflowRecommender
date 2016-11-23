package org.bhanu.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.bhanu.database.Database;

import orga.bhanu.model.Message;

public class MessageService {

	private Map<Long, Message> messages = Database.getMessages();

	public MessageService(){
		messages.put(new Long(1), new Message(1L,"Helloworld","kaushik"));
		messages.put(new Long(2), new Message(2L,"Helloworld","bhanu"));
	}
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		ArrayList<Message> list = new ArrayList<>(messages.values());	
		return(list.subList(start, start+size));
	}
	

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message AddMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put( message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
