package com.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class jsonTest {
//this is a model for mapping the json string to jsonObject
//String url is as below
/*	
	{
		   "time": "07:52:36 PM",
		   "milliseconds_since_epoch": 1468266756973,
		   "date": "07-11-2016"
		}	

*/
	    @JsonProperty("time")
	    private String time;
	    
	    @JsonProperty("milliseconds_since_epoch")
	    private String millisec;
	    
	    @JsonProperty("date")
	    private String date;

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getMillisec() {
			return millisec;
		}

		public void setMillisec(String millisec) {
			this.millisec = millisec;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
	    
	    

}
