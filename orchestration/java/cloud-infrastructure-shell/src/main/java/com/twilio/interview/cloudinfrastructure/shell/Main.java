package com.twilio.interview.cloudinfrastructure.shell;

import java.io.IOException;

import asg.cliche.ShellFactory;

public class Main {

	public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("cim", "cloud infrastructure management\n" +
                "Enter help to list available commands.", new MainShell())
                .commandLoop();
    }
	
	
	
	

}
