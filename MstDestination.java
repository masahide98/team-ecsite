package jp.co.internous.wasabi.model.domain;

import java.sql.Timestamp;

import jp.co.internous.wasabi.model.form.DestinationForm;

public class MstDestination {
	
	    private int id;
	    private int userId;
		private String familyName;
		private String firstName;
		private String address;
		private String telNumber;
		private byte status;
		private Timestamp createdAt;
		private Timestamp updatedAt;
		
		public MstDestination() {}
		
		public MstDestination(DestinationForm f) {
			userId = f.getUserId();
			familyName = f.getFamilyName();
			firstName = f.getFirstName();
			address = f.getAddress();
			telNumber = f.getTelNumber();
		}
		
		public void setId(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getUserId() {
			return userId;
		}
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}
		public String getFamilyName() {
			return familyName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getAddress() {
			return address;
		}
		public void setTelNumber(String telNumber) {
			this.telNumber = telNumber;
		}
		public String getTelNumber() {
			return telNumber;
		}
		public void setStatus(byte status) {
			this.status = status;
		}
		public byte getStatus() {
			return status;
		}
		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}
		public Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setUpdatedAt(Timestamp updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Timestamp getUpdatedAt() {
			return updatedAt;
		}	

}
