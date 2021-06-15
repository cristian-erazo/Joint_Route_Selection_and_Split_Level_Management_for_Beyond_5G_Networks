package domain.monoobjective.implementation.metaheuristics.algorithms.crossover;

import domain.monoobjective.implementation.MatrixSolution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author cristian.erazo@cinvestav.mx
 */
public class NewCrossover implements Crossover<MatrixSolution> {

    private List<MatrixSolution> parents;
    private final double prob;
    private Random rand;
    private int nChilds;

    public NewCrossover(double prob, Random rand) {
        nChilds = 0;
        this.rand = rand;
        this.prob = prob;
        parents = new ArrayList<>();
    }

    @Override
    public List<MatrixSolution> run() {
        if (nChilds > 0 && !parents.isEmpty() && parents != null && nChilds <= parents.size()) {
            int k = 0, n = parents.get(0).getN(), m = parents.get(0).getM();
            List<MatrixSolution> childs = new ArrayList<>();
            Collections.shuffle(parents, rand);
            MatrixSolution p1, p2, t;
            while (childs.size() < nChilds) {
                p1 = parents.get(k);
                k = (k + 1) % parents.size();
                p2 = parents.get(k);
                k = (k + 1) % parents.size();
                MatrixSolution c1;
                MatrixSolution c2;
                if (p1.gn == 0 && p2.gn == 0) {//las soluciones son factibles...
                    /*if (Tools.isMaximization) {//la base es quien tiene mayor valor de la funcion objetivo
                        if (p1.getObjective() > p2.getObjective()) {//p2 es mayor, intercambiar
                            t = p1;
                            p1 = p2;
                            p2 = t;
                        }
                    } else {//la base es quien tiene menor valor de la funcion objetivo
                        if (p1.getObjective() < p2.getObjective()) {//p2 es menor, intercambiar
                            t = p1;
                            p1 = p2;
                            p2 = t;
                        }
                    }*/
                    c1 = p1.copy();
                    c2 = p2.copy();
                    for (int i = 0; i < n; i++) {
                        if (rand.nextDouble() < prob) {
                            c1.accepted[i] = p2.accepted[i];
                            System.arraycopy(p2.data[i], 0, c1.data[i], 0, p2.data[i].length);
                        }
                        if (rand.nextDouble() < prob) {
                            c2.accepted[i] = p1.accepted[i];
                            System.arraycopy(p1.data[i], 0, c2.data[i], 0, p1.data[i].length);
                        }
                    }
                } else {//las soluciones son no-factibles... la base es quien tenga mas restricciones satisfechas
                    if (p1.gn > p2.gn) {//p2 viola menos restricciones, intercambiar
                        t = p1;
                        p1 = p2;
                        p2 = t;
                    }
                    c1 = p1.copy();
                    c2 = p1.copy();
                    for (int i = 0; i < n; i++) {
                        if (rand.nextDouble() < prob) {
                            c1.accepted[i] = p2.accepted[i];
                        }
                        if (rand.nextDouble() < prob) {
                            c2.accepted[i] = p2.accepted[i];
                        }
                        for (int j = 0; j < m; j++) {
                            if (rand.nextDouble() < prob) {
                                c1.data[i][j] = p2.data[i][j];
                            }
                            if (rand.nextDouble() < prob) {
                                c2.data[i][j] = p2.data[i][j];
                            }
                        }
                    }
                }
                c1.setObjective(-1.);
                c2.setObjective(-1.);
                childs.add(c1);
                childs.add(c2);
            }
            parents.clear();
            return childs;
        } else {
            System.out.println("Crossed ZERO!");
        }
        return null;
    }

    @Override
    public void setParents(List<MatrixSolution> parents) {
        if (!this.parents.isEmpty()) {
            this.parents.clear();
        }
        this.parents.addAll(parents);
    }

    @Override
    public void setNumberOfChilds(int nChilds) {
        this.nChilds = nChilds;
    }

}
