package com.jayway.alphabet.tracking;

/**
 * This interface describes the internal tracker API.
 */
public interface Tracker {

    /**
     * Registers a given tag in the tracking infrastructure.
     *
     * @param tag The textual tag to register.
     */
    void send(String tag);

    /**
     * Registers a given tag in the tracking infrastructure.
     *
     * @param tag The numeric tag to register.
     */
    void send(int tag);

}
