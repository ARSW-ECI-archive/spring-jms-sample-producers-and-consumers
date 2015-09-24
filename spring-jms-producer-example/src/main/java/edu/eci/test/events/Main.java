package edu.eci.test.events;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MyJMSProducer mp=ac.getBean(MyJMSProducer.class);
		
            try {                
                    mp.sendMessages(new String("hola mundo!"));
            } catch (JMSException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	
}
