
package com.pro.deepak.smart_watch.connectivity;

import java.util.ArrayList;

import android.os.Handler;

public class TransactionReceiver {
	private static final String TAG = "TransactionReceiver";
	
	private static final int PARSE_MODE_ERROR = 0;
	private static final int PARSE_MODE_WAIT_START_BYTE = 1;
	private static final int PARSE_MODE_WAIT_COMMAND = 2;
	private static final int PARSE_MODE_WAIT_DATA = 3;
	private static final int PARSE_MODE_WAIT_END_BYTE = 4;
	
	private Handler mHandler = null;
	private ArrayList<Transaction> mTransactionQueue = new ArrayList<Transaction>();
	
	private int mParseMode = PARSE_MODE_WAIT_START_BYTE;
	private int mCommand = Transaction.COMMAND_TYPE_NONE;
	private Transaction mTransaction = null;
	
	public TransactionReceiver(Handler h) {
		mHandler = h;
		mParseMode = PARSE_MODE_WAIT_START_BYTE;
	}
	
	public void setByteArray(byte[] buffer) {
		parseStream(buffer);
	}
	
	public void popTransaction() {
		// TODO: 
	}

	private void parseStream(byte[] buffer) {
		if(buffer != null && buffer.length > 0) {
			for(int i=0; i<buffer.length; i++) {
				
				switch(mParseMode) {
				case PARSE_MODE_WAIT_START_BYTE:
					parseStartByte(buffer[i]);
					break;
				case PARSE_MODE_WAIT_COMMAND:
					parseCommand(buffer[i]);
					break;
				case PARSE_MODE_WAIT_DATA:
					parseData(buffer[i]);
					break;
				case PARSE_MODE_WAIT_END_BYTE:
					parseEndByte(buffer[i]);
					break;
				}
			}	// End of for loop
		}	// End of if()
	}
	
	private void parseStartByte(byte packet) {
		if(packet == Transaction.TRANSACTION_START_BYTE) {
			mParseMode = PARSE_MODE_WAIT_COMMAND;
			mTransaction = new Transaction();
		}
	}
	
	private void parseCommand(byte cmd) {
		mCommand = cmd;
		switch(mCommand) {
		case Transaction.COMMAND_TYPE_PING:
			mParseMode = PARSE_MODE_WAIT_END_BYTE;
			break;
			
		// TODO:
			
		default:
			break;
		}	// End of switch()
	}	// End of parseCommand()
	
	private void parseData(byte packet) {
		if(packet == Transaction.TRANSACTION_END_BYTE) {
			mParseMode = PARSE_MODE_WAIT_START_BYTE;
			pushTransaction();
		}
		
		// TODO: 
	}
	
	private void parseEndByte(byte packet) {
		if(packet == Transaction.TRANSACTION_END_BYTE) {
			mParseMode = PARSE_MODE_WAIT_START_BYTE;
			pushTransaction();
		}
	}
	
	private void pushTransaction() {
		if(mTransaction != null) {
			mTransactionQueue.add(mTransaction);
			mTransaction = null;
		}
	}
	
	
	public class Transaction {
		private static final byte TRANSACTION_START_BYTE = (byte)0xfc;
		private static final byte TRANSACTION_END_BYTE = (byte)0xfd;
		
		public static final int COMMAND_TYPE_NONE = 0x00;
		public static final int COMMAND_TYPE_PING = 0x01;
		
	}
	
}
