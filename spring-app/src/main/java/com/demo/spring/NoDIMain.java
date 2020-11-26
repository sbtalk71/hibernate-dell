package com.demo.spring;

public class NoDIMain {

	public static void main(String[] args) {

		Message message = new Message("Tea Break", "Tea break at 4:00pm");

		Mail mail = new Mail();
		mail.setMessage(message);
		mail.setFromAddress("Trainer");
		mail.setToAddress("All");
		
		System.out.println(mail.getMessage().getBody());
	}

}
