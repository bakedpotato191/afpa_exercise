package bean;

import java.sql.Timestamp;

public class Token {

	private String email;
	private String tkn;
	private Timestamp expirationDate;
	private boolean tokenUsed;

	public Token() {
		super();
	}

	public Token(String email, String tkn, Timestamp expirationDate, boolean tokenUsed) {
		super();
		this.email = email;
		this.tkn = tkn;
		this.expirationDate = expirationDate;
		this.tokenUsed = tokenUsed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return tkn;
	}

	public void setToken(String tkn) {
		this.tkn = tkn;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isTokenUsed() {
		return tokenUsed;
	}

	public void setTokenUsed(boolean tokenUsed) {
		this.tokenUsed = tokenUsed;
	}

}
