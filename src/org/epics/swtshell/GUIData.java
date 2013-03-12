/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.swtshell;

import org.epics.pvdata.misc.BitSet;
import org.epics.pvdata.pv.PVStructure;


/**
 * @author mrk
 *
 */
public interface GUIData {
    void get(PVStructure pvStructure,BitSet bitSet);
}