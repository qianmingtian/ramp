package it.unibo.deis.lia.ramp.core.internode.sdn.controllerMessage;

import it.unibo.deis.lia.ramp.core.internode.sdn.applicationRequirements.ApplicationRequirements;
import it.unibo.deis.lia.ramp.core.internode.sdn.pathSelection.TopologyGraphSelector;
import it.unibo.deis.lia.ramp.core.internode.sdn.pathSelection.PathSelectionMetric;
import it.unibo.deis.lia.ramp.util.NodeStats;

import java.util.Map;

/**
 * @author Alessandro Dolci
 * @author Dmitrij David Padalino Montenero
 */
public class ControllerMessageRequest extends ControllerMessage {
    private int[] destNodeIds;

    private int[] destPorts;

    private ApplicationRequirements applicationRequirements;

    private PathSelectionMetric pathSelectionMetric;

    private int flowId;

    /**
     * PATH_REQUEST message: messageType, clientPort, destNodeIds, applicationRequirements, pathSelectionMetric, flowId,
     * MULTICAST_REQUEST message: messageType, clientPort, destNodeIds, destPorts, applicationRequirements, pathSelectionMetric, flowId
     * PRIORITY_VALUE_REQUEST message: messageType, clientPort, applicationRequirements, flowId
     * OS_ROUTING_REQUEST TODO
     */
    public ControllerMessageRequest(MessageType messageType, int clientPort, Map<String, NodeStats> nodeStats, int[] destNodeIds, int[] destPorts, ApplicationRequirements applicationRequirements, PathSelectionMetric pathSelectionMetric, int flowId) {
        super(messageType, clientPort, nodeStats);

        this.destNodeIds = destNodeIds;
        this.destPorts = destPorts;
        this.applicationRequirements = applicationRequirements;
        this.pathSelectionMetric = pathSelectionMetric;
        this.flowId = flowId;
    }

    public ControllerMessageRequest(MessageType messageType, int clientPort, int[] destNodeIds, int[] destPorts, ApplicationRequirements applicationRequirements, PathSelectionMetric pathSelectionMetric, int flowId) {
        super(messageType, clientPort);

        this.destNodeIds = destNodeIds;
        this.destPorts = destPorts;
        this.applicationRequirements = applicationRequirements;
        this.pathSelectionMetric = pathSelectionMetric;
        this.flowId = flowId;
    }

    public int[] getDestNodeIds() {
        return this.destNodeIds;
    }

    public void setDestNodeIds(int [] destNodeIds) {
        this.destNodeIds = destNodeIds;
    }

    public int[] getDestPorts() {
        return this.destPorts;
    }

    public void setDestPorts(int [] destPorts) {
        this.destPorts = destPorts;
    }

    public ApplicationRequirements getApplicationRequirements() {
        return this.applicationRequirements;
    }

    public void setApplicationRequirements(ApplicationRequirements applicationRequirements) {
        this.applicationRequirements = applicationRequirements;
    }

    public PathSelectionMetric getPathSelectionMetric() {
        return this.pathSelectionMetric;
    }

    public void setPathSelectionMetric(PathSelectionMetric pathSelectionMetric) {
        this.pathSelectionMetric = pathSelectionMetric;
    }

    public int getFlowId() {
        return this.flowId;
    }

    public void setFlowId(int flowId) {
        this.flowId = flowId;
    }
}
