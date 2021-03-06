package it.unibo.deis.lia.ramp.core.internode.sdn.advancedDataPlane.rulesManager.forwardingListener;

import it.unibo.deis.lia.ramp.core.e2e.BroadcastPacket;
import it.unibo.deis.lia.ramp.core.e2e.GenericPacket;
import it.unibo.deis.lia.ramp.core.e2e.UnicastHeader;
import it.unibo.deis.lia.ramp.core.e2e.UnicastPacket;
import it.unibo.deis.lia.ramp.core.internode.PacketForwardingListener;
import it.unibo.deis.lia.ramp.core.internode.sdn.advancedDataPlane.rulesManager.DataPlaneRulesManager;

/**
 * @author Dmitrij David Padalino Montenero
 */
public class DataPlaneForwardingListener implements PacketForwardingListener {

    private DataPlaneRulesManager dataPlaneRulesManager = DataPlaneRulesManager.getInstance();

    @Override
    public void receivedUdpUnicastPacket(UnicastPacket up) {
        receivedTcpUnicastPacket(up);
    }

    @Override
    public void receivedUdpBroadcastPacket(BroadcastPacket bp) {
        receivedTcpBroadcastPacket(bp);
    }

    @Override
    public void receivedTcpUnicastPacket(UnicastPacket up) {
        long dataTypeId = up.getHeader().getDataType();
        if (dataTypeId != GenericPacket.UNUSED_FIELD && dataPlaneRulesManager.containsDataPlaneRuleForDataType(dataTypeId)) {
            dataPlaneRulesManager.executeUnicastPacketDataPlaneRule(dataTypeId, up);
        }
    }

    @Override
    public void receivedTcpUnicastHeader(UnicastHeader uh) {
        long dataTypeId = uh.getDataType();
        if (dataTypeId != GenericPacket.UNUSED_FIELD && dataPlaneRulesManager.containsDataPlaneRuleForDataType(dataTypeId)) {
            dataPlaneRulesManager.executeUnicastHeaderDataPlaneRule(dataTypeId, uh);
        }
    }

    @Override
    public void receivedTcpPartialPayload(UnicastHeader uh, byte[] payload, int off, int len, boolean lastChunk) {

    }

    @Override
    public void receivedTcpBroadcastPacket(BroadcastPacket bp) {
        long dataTypeId = bp.getDataType();
        if (dataTypeId != GenericPacket.UNUSED_FIELD && dataPlaneRulesManager.containsDataPlaneRuleForDataType(dataTypeId)) {
            dataPlaneRulesManager.executeBroadcastPacketDataPlaneRule(dataTypeId, bp);
        }
    }

    @Override
    public void sendingTcpUnicastPacketException(UnicastPacket up, Exception e) {

    }

    @Override
    public void sendingTcpUnicastHeaderException(UnicastHeader uh, Exception e) {

    }
}
