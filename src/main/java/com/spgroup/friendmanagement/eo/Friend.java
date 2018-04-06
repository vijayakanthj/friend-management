package com.spgroup.friendmanagement.eo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;



@Entity
public class Friend implements Serializable {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 7861887814937239756L;

	@Embeddable
	    public static class FriendPk implements Serializable {

	        private static final long serialVersionUID = -7231723877769628539L;
	        private Long pid1, pid2;
			public Long getPid1() {
				return pid1;
			}
			public void setPid1(Long pid1) {
				this.pid1 = pid1;
			}
			public Long getPid2() {
				return pid2;
			}
			public void setPid2(Long pid2) {
				this.pid2 = pid2;
			}
	        
	        
	    }
	    @EmbeddedId
	    private FriendPk id = new FriendPk();

	    @JoinColumn(name = "PID1")
	    @MapsId("pid1")
	    @ManyToOne
	    private Person person1;

	    @JoinColumn(name = "PID2")
	    @MapsId("pid2")
	    @ManyToOne
	    private Person person2;

		public FriendPk getId() {
			return id;
		}

		public void setId(FriendPk id) {
			this.id = id;
		}

		public Person getPerson1() {
			return person1;
		}

		public void setPerson1(Person person1) {
			this.person1 = person1;
		}

		public Person getPerson2() {
			return person2;
		}

		public void setPerson2(Person person2) {
			this.person2 = person2;
		}
	    
	    
	    
	
}
