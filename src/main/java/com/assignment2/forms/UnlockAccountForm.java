package com.assignment2.forms;

import lombok.Data;

@Data
public class UnlockAccountForm {
	private String email;
	private String tempPass;
	private String confirmPass;
	private String newPass;
}
