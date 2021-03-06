/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.swtshell;

/**
 * @author mrk
 * Callback for channelConnect
 *
 */
public interface ConnectChannelRequester {
    /**
     * The channel has not connected.
     */
    void timeout();
}
