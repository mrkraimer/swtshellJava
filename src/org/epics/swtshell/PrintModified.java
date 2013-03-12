/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.swtshell;

/**
 * Print the fields of a PVStructure that have been modified.
 * @author mrk
 *
 */
public interface PrintModified {
    /**
     * Print all modified fields.
     */
    void print();
}