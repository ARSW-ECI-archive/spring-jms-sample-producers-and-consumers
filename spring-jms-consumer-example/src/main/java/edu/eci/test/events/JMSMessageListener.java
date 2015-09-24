package edu.eci.test.events;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQObjectMessage;

public class JMSMessageListener implements MessageListener {

	
	
	public JMSMessageListener() {
		super();
		System.out.println("Listening JMS...");
	}

	@Override
	public void onMessage(Message m) {
		ActiveMQObjectMessage om=(ActiveMQObjectMessage)m; 
		try {
			String receivedObject=(String)om.getObject();
			System.out.println(">>>> GOT:"+receivedObject); 
		} catch (JMSException e) {
			throw new RuntimeException("An exception occured while trying to get a JMS object:"+e.getMessage(),e);
		}

	}

}
