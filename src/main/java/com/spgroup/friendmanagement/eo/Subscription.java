package com.spgroup.friendmanagement.eo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Subscription implements Serializable {

    private static final long serialVersionUID = 6180210400731762562L;

    @Embeddable
    public static class SubscribePk implements Serializable {

        private static final long serialVersionUID = -7231723877769628539L;
        private Long targetId, requestorId;
		public Long getTargetId() {
			return targetId;
		}
		public void setTargetId(Long targetId) {
			this.targetId = targetId;
		}
		public Long getRequestorId() {
			return requestorId;
		}
		public void setRequestorId(Long requestorId) {
			this.requestorId = requestorId;
		}
        
        
    }
    @EmbeddedId
    private SubscribePk id = new SubscribePk();

    /**
     * target is the person who will 'give' updates to the requestor
     */
    @JoinColumn(name = "TARGET_ID")
    @MapsId("targetId")
    @ManyToOne
    private Person target;

    /**
     * requestor is the person who subscribe to updates from the target person
     */
    @JoinColumn(name = "REQUESTOR_ID")
    @MapsId("requestorId")
    @ManyToOne
    private Person requestor;

	public SubscribePk getId() {
		return id;
	}

	public void setId(SubscribePk id) {
		this.id = id;
	}

	public Person getTarget() {
		return target;
	}

	public void setTarget(Person target) {
		this.target = target;
	}

	public Person getRequestor() {
		return requestor;
	}

	public void setRequestor(Person requestor) {
		this.requestor = requestor;
	}
    
    

}
