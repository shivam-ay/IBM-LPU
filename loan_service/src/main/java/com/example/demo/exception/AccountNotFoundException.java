package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String msg;
}
