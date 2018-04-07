package com.spgroup.friendmanagement.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class FriendValidation {
    private Pattern emailPattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");

    public boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

	public Pattern getEmailPattern() {
		return emailPattern;
	}

	public void setEmailPattern(Pattern emailPattern) {
		this.emailPattern = emailPattern;
	}
    
    
    
}
