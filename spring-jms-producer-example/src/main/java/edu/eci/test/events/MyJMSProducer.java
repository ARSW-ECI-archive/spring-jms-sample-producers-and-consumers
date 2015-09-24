package edu.eci.test.events;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;



public class MyJMSProducer {


	protected JmsTemplate jmsTemplate; 



	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	public void sendMessages(final Serializable message) throws JMSException {

		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {

				ObjectMessage om=session.createObjectMessage(message);

				return om;

			}

		});

	}

}
