package domain.problem.virtual;

import domain.problem.graph.Link;

/**
 *
 * @author cristian.erazo@cinvestav.mx
 */
public class VirtualLink extends Link {

    /**
     * The index of the representation.
     */
    public int indx;
    /**
     * The index of the physical path.
     */
    public int indxPath;
    /**
     * The maximum delay request.
     */
    public double maxDelay;

    /**
     * This builder method instantiates a virtual link.
     *
     * @param minBw The minimum bandwith required.
     * @param maxDelay The maximum maxDelay constraint.
     * @param source The CU source.
     * @param destination The DU destination.
     */
    public VirtualLink(double minBw, double maxDelay, int source, int destination) {
        super(minBw, 0, 0, 0, 0, source, destination);
        this.indx = -1;
        this.maxDelay = maxDelay;
        this.indxPath = -1;
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", bw, maxDelay);
    }
}
