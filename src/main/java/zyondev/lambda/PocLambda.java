package zyondev.lambda;

import com.amazonaws.services.lambda.runtime.Context;

public class PocLambda {

	 public String myHandler(int myCount, Context context) {
	        return String.valueOf(myCount);
	    }
}
