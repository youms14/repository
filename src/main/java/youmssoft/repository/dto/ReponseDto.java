package youmssoft.repository.dto;

import java.util.HashMap;

public class ReponseDto {
	
	HashMap<String,Object> response;
	
	
	
	
    public HashMap<String,Object> format(Code code, Object jsonData) {
        HashMap<String, Object> json = new HashMap<String, Object>();
        json.put("status", code.isSuccess() ? true : false);
        json.put("message", code.isSuccess() ? String.valueOf(code.toCode()) : String.valueOf(code.toCode() * -1));
        json.put(code.isSuccess() ? "data" : "errors", jsonData);
        this.response=json;
        return json;
    }

    public enum Code {
        SUCCESS(1000),
        FAILURE(-1001),
        VALIDATION_ERROR(-1002),
        DATA_EXIST(-1004),
        UNKNOWN_CODE(0);
        private int code;

        Code(int code) {
            this.code = code;
        }

        public int toCode() {
            return this.code;
        }

        public boolean equals(int code) {
            return this.code == code;
        }

        public boolean isSuccess() {
            return this.code > 0;
        }

        @Override
        public String toString() {
            return this.name();
        }

    }

	public HashMap<String, Object> getResponse() {
		return response;
	}

	public void setResponse(HashMap<String, Object> response) {
		this.response = response;
	}

	public ReponseDto() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReponseDto [response=");
		builder.append(response);
		builder.append("]");
		return builder.toString();
	}
    
	
    
    
}