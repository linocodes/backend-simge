package br.gov.mg.meioambiente.simge.service;

import org.springframework.context.ApplicationEvent;

/**
 * This is an optional class used in publishing application events.
 * This can be used to inject events into the Spring Boot audit management endpoint.
 */
public class HotelServiceEvent extends ApplicationEvent {

	private static final long serialVersionUID = 8711970560218883880L;

	public HotelServiceEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My HotelService Event";
    }
}