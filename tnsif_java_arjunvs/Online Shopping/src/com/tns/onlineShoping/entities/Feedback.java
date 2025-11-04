package com.tns.onlineShoping.entities;

public class Feedback {
	 private int feedbackId;
	    private int orderId;
	    private String customerName;
	    private String message;
		private int getFeedbackId() {
			return feedbackId;
		}
		private void setFeedbackId(int feedbackId) {
			this.feedbackId = feedbackId;
		}
		private int getOrderId() {
			return orderId;
		}
		private void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		private String getCustomerName() {
			return customerName;
		}
		private void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		private String getMessage() {
			return message;
		}
		private void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "Feedback [feedbackId=" + feedbackId + ", orderId=" + orderId + ", customerName=" + customerName
					+ ", message=" + message + "]";
		}


}
