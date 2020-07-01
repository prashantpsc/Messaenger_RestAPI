package org.prashant.javabrain.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.prashant.javabrain.messenger.Model.Message;
import org.prashant.javabrain.messenger.database.Database;
import org.prashant.javabrain.messenger.exception.DataNotFoundException;

public class MessageService {

	private Map<Long, Message> messages = Database.getMessage();

	public MessageService()
	{
		Message m1 = new Message("Prashant",1L,"newton");
		Message m2 = new Message("Electric",2L,"Telsa");
		messages.put(1L, m1);
		messages.put(2l, m2);
	}
	
	
	public List<Message> getAllmessage()
	{
	 return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllmessagePaginated(int start, int size)
	{
		List<Message> list =new ArrayList<>(messages.values());
		if(size > list.size())
		{
			return new ArrayList();
		}
		return list.subList(start, size);
		
		
	}
	public Message getMessage(long id)
	{
		Message mes = messages.get(id);
		if(mes == null)
		{
			throw new DataNotFoundException("Id is not available in the message"); 
			
		}
		return messages.get(id);	
		
	}

	public Message addMessage(Message message)
	{
		message.setId(messages.size() +1 );
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message m)
	{
		if(m.getId() <=0)
		{
			return null;
		}
		messages.put(m.getId(), m);
		System.out.print("updates");
		return m;
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}
}
